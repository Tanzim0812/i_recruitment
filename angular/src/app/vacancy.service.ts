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
  createVacancy(vacancy:Vacancy): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`,vacancy);
  }
  getVacancyById(id:number):Observable<Vacancy>{
    return this.httpClient.get<Vacancy>(`${this.baseUrl}/${id}`);
  }
  updateVacancy(id:number,vacancy:Vacancy):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,vacancy);
  }
  deleteVacancy(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
