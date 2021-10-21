import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vacancy } from '../vacancy';
import { VacancyService } from '../vacancy.service';

@Component({
  selector: 'app-update-vacancy',
  templateUrl: './update-vacancy.component.html',
  styleUrls: ['./update-vacancy.component.css']
})
export class UpdateVacancyComponent implements OnInit {
  id!: number;
  vacancy:Vacancy = new Vacancy();
  constructor(private vacancyservice:VacancyService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.vacancyservice.getVacancyById(this.id).subscribe(data=>{

      this.vacancy=data;

    },
    error=>console.error()
      );
  }

  onSubmt(){
    this.vacancyservice.updateVacancy(this.id, this.vacancy).subscribe(data => {
      this.gotoList();
    },
    )
   
  }
  

  gotoList(){
    this.router.navigate(['/vacancy']);
  }
 


  

}
