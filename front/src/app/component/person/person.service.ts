import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Page } from 'src/app/shared/util/pagination';
import { environment } from 'src/environments/environment';
import { CreatePerson, Person } from './person';

const API = environment.api;

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  constructor(private http: HttpClient) {}

  create(person: CreatePerson) {
    const url = `${API}api/persons`;

    return this.http.post(url, person);
  }

  getAll(page = 0) {
    const url = `${API}api/persons`;
    const params = new HttpParams({
      fromObject: {
        page: page.toString(),
      },
    });

    return this.http.get<Page<Person>>(url, { params });
  }

  getAllNotPaged() {
    const url = `${API}api/persons/all`;

    return this.http.get<Person[]>(url);
  }
}
