import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { Observable } from 'rxjs';
import { Subscription } from 'rxjs/internal/Subscription';
import {
  filter,
  switchMap,
  take,
  tap
} from 'rxjs/operators';
import { Person } from '../person/person';
import { PersonService } from '../person/person.service';
import { SpendDataSource } from './spend.datasource';
import { SpendService } from './spend.service';

@Component({
  selector: 'app-spend',
  templateUrl: './spend.component.html',
  styleUrls: ['./spend.component.scss'],
})
export class SpendComponent implements OnInit, OnDestroy {
  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  displayedColumns: string[] = [
    'id',
    'dataTransacao',
    'descricao',
    'valor',
    'tags',
  ];

  valueMask = {
    mask: Number,
    scale: 2,
    signed: true,
    thousandsSeparator: '.',
    padFractionalZeros: true,
    normalizeZeros: true,
    radix: ',',
    mapToRadix: ['.'],
  };

  persons$: Observable<Person[]>;

  dataSource: SpendDataSource;

  subscriptions: Subscription[] = [];

  form: FormGroup;

  constructor(
    private spendService: SpendService,
    personService: PersonService,
    fb: FormBuilder
  ) {
    this.form = fb.group({
      personId: [null, [Validators.required]],
      descricao: [null, [Validators.required, Validators.maxLength(150)]],
      valor: [null, [Validators.required]],
      tags: [false],
    });

    this.persons$ = personService.getAllNotPaged();
  }

  ngOnInit(): void {
    this.dataSource = new SpendDataSource(this.spendService, this.paginator);

    this.subscriptions.push(
      this.dataSource.paginator.page
        .pipe(switchMap((pageEvent) => this.dataSource.goToPage(pageEvent)))
        .subscribe(),

      this.form.valueChanges
        .pipe(
          filter((value) => value.personId),
          tap((value) => (this.dataSource.personId = value.personId)),
          switchMap(() => this.dataSource.firstPage())
        )
        .subscribe()
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription$) => subscription$.unsubscribe());
    this.dataSource.disconnect();
  }

  create() {
    this.spendService
      .create(this.form.value)
      .pipe(
        tap(() =>
          this.form.patchValue({
            descricao: null,
            valor: null,
            tags: false,
          })
        ),
        switchMap(() => this.dataSource.firstPage()),
        take(1)
      )
      .subscribe();
  }
}
