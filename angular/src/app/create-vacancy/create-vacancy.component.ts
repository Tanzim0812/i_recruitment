import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { Vacancy } from '../vacancy';
import { VacancyService } from '../vacancy.service';

@Component({
  selector: 'app-create-vacancy',
  templateUrl: './create-vacancy.component.html',
  styleUrls: ['./create-vacancy.component.css']
})
export class CreateVacancyComponent implements OnInit {

  vacancy:Vacancy = new Vacancy();
  constructor(private vacancyservice:VacancyService,private router:Router) { }

  ngOnInit(): void {
  }

  saveVacancy(){
    this.vacancyservice.createVacancy(this.vacancy).subscribe(data=>{
      console.log(data);
      this.gotoVacancy();
    },
    error => console.log(error));
  }

  gotoVacancy(){
    this.router.navigate(['/vacancy']);
  }

  onSubmit(){
    console.log(this.vacancy);
    this.saveVacancy();
  }

}
