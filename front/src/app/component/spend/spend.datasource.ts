import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { tap } from 'rxjs/operators';
import { HttpPaginationMatTableDataSource } from 'src/app/shared/util/pagination';
import { Spend } from './spend';
import { SpendService } from './spend.service';

export class SpendDataSource extends HttpPaginationMatTableDataSource<Spend> {
  personId: number;

  constructor(private spendService: SpendService, paginator: MatPaginator) {
    super(paginator, false);
  }

  goToPage(pageEvent?: PageEvent) {
    return this.spendService
      .getAll(this.personId, pageEvent?.pageIndex)
      .pipe(tap((response) => this.updateData(response)));
  }

  firstPage() {
    return this.goToPage();
  }

}
