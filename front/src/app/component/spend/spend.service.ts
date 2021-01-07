import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Page } from 'src/app/shared/util/pagination';
import { environment } from 'src/environments/environment';
import { CreateSpend, Spend } from './spend';

const API = environment.api;

@Injectable({
  providedIn: 'root',
})
export class SpendService {
  constructor(private http: HttpClient) {}

  create(spend: CreateSpend) {
    const url = `${API}api/spends/${spend.personId}`;

    return this.http.post(url, spend);
  }

  getAll(personId: number, page = 0) {
    const url = `${API}api/spends/find-all/${personId}`;
    const params = new HttpParams({
      fromObject: {
        page: page.toString(),
      },
    });

    return this.http.get<Page<Spend>>(url, { params });
  }
}
