import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Applicant } from './applicant';

@Injectable({
  providedIn: 'root'
})
export class ApplicantService {

  private baseUrl="http://localhost:7050/api/applicant";
  constructor( private httpclient:HttpClient) { }

  getApplicantList():Observable<Applicant[]>{
    return this.httpclient.get<Applicant[]>(`${this.baseUrl}`);
  }
  createApplicant(appli:Applicant): Observable<Object>{
    return this.httpclient.post(`${this.baseUrl}`,appli);
  }
}
