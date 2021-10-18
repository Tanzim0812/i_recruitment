import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vacancy } from './vacancy';

@Injectable({
  providedIn: 'root'
})
export class VacancyService {

  private baseUrl="http://localhost:7050/api/vacancy";
  constructor( private httpClient:HttpClient) { }

  getVacancyList(): Observable<Vacancy[]>{
    return this.httpClient.get<Vacancy[]>(`${this.baseUrl}`);
  }
}
