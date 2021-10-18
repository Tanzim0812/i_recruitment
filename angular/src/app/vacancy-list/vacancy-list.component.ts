import { Component, OnInit } from '@angular/core';
import { Vacancy } from '../vacancy';
import { VacancyService } from '../vacancy.service';

@Component({
  selector: 'app-vacancy-list',
  templateUrl: './vacancy-list.component.html',
  styleUrls: ['./vacancy-list.component.css']
})
export class VacancyListComponent implements OnInit {

  vacanylist: Vacancy[] | undefined;
  constructor( private vacancyservice:VacancyService) { }

  ngOnInit(): void {
   this.getVacancy();
  }
  private getVacancy(){
    this.vacancyservice.getVacancyList().subscribe(data =>{
      this.vacanylist=data;
    })
  }
}
