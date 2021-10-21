import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vacancy } from '../vacancy';
import { VacancyService } from '../vacancy.service';

@Component({
  selector: 'app-vacancy-list',
  templateUrl: './vacancy-list.component.html',
  styleUrls: ['./vacancy-list.component.css']
})
export class VacancyListComponent implements OnInit {

  vacancylist: Vacancy[] | undefined;
  constructor( private vacancyservice:VacancyService,
    private router:Router
    
    ) { }

  ngOnInit(): void {
   this.getVacancy();
  }
  private getVacancy(){
    this.vacancyservice.getVacancyList().subscribe(data =>{
      this.vacancylist=data;
    })
  }

  updateVacancy(id:number){
      this.router.navigate(['update-vacancy',id]);
  }
  deleteVacancy(id:number){
    this.vacancyservice.deleteVacancy(id).subscribe(data => {
      console.log(data);
      this.getVacancy();
      //this.router.navigate(['/vacancy']);
    })
  }

  
}
