import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { BehaviorSubject, Observable } from 'rxjs';
import { take } from 'rxjs/operators';

export class Page<T> {
  content: T[];
  number: number;
  size: number;
  totalElements: number;
}

export abstract class HttpPaginationMatTableDataSource<
  T
> extends MatTableDataSource<T> {
  data$: BehaviorSubject<T[]>;

  constructor(paginator: MatPaginator, private init = false) {
    super([]);
    this.paginator = paginator;
    this.data$ = new BehaviorSubject<T[]>([]);
  }

  connect(): BehaviorSubject<T[]> {
    if (this.init) {
      this.firstPage().pipe(take(1)).subscribe();
    }

    return this.data$;
  }

  disconnect() {
    this.data$.complete();
  }

  updateData(page: Page<T>) {
    this.data$.next(page.content);

    this.paginator.pageIndex = page.number;
    this.paginator.pageSize = page.size;
    this.paginator.length = page.totalElements;
  }

  abstract firstPage(): Observable<Page<T>>;
}
