import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { tap } from 'rxjs/operators';
import { HttpPaginationMatTableDataSource } from 'src/app/shared/util/pagination';
import { Person } from './person';
import { PersonService } from './person.service';

export class PersonDataSource extends HttpPaginationMatTableDataSource<Person> {
  constructor(private personService: PersonService, paginator: MatPaginator) {
    super(paginator, true);
  }

  goToPage(pageEvent?: PageEvent) {
    return this.personService
      .getAll(pageEvent?.pageIndex)
      .pipe(tap((response) => this.updateData(response)));
  }

  firstPage() {
    return this.goToPage();
  }
}
