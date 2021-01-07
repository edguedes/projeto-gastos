import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { Subscription } from 'rxjs';
import { switchMap, take, tap } from 'rxjs/operators';
import { PersonDataSource } from './person.datasource';
import { PersonService } from './person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss'],
})
export class PersonComponent implements OnInit, OnDestroy {
  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  displayedColumns: string[] = ['id', 'name'];

  dataSource: PersonDataSource;

  subscriptions: Subscription[] = [];

  form: FormGroup;

  constructor(private personService: PersonService, fb: FormBuilder) {
    this.form = fb.group({
      name: ['', [Validators.required, Validators.maxLength(40)]],
    });
  }

  ngOnInit(): void {
    this.dataSource = new PersonDataSource(this.personService, this.paginator);

    this.subscriptions.push(
      this.dataSource.paginator.page
        .pipe(switchMap((pageEvent) => this.dataSource.goToPage(pageEvent)))
        .subscribe()
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription$) => subscription$.unsubscribe());
    this.dataSource.disconnect();
  }

  create() {
    this.personService
      .create(this.form.value)
      .pipe(
        tap(() => this.form.reset()),
        switchMap(() => this.dataSource.firstPage()),
        take(1)
      )
      .subscribe();
  }
}
