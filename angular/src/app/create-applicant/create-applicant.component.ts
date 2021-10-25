import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Applicant } from '../applicant';
import { ApplicantService } from '../applicant.service';

@Component({
  selector: 'app-create-applicant',
  templateUrl: './create-applicant.component.html',
  styleUrls: ['./create-applicant.component.css']
})
export class CreateApplicantComponent implements OnInit {

  appli:Applicant=new Applicant();
  constructor(private appservice:ApplicantService,private router:Router) { }

  ngOnInit(): void {
  }
  saveApplicant(){
    this.appservice.createApplicant(this.appli).subscribe(data=>{
      console.log(data);
      this.gotoApplicant();
    },
    error => console.log(error));
  }

  gotoApplicant(){
    this.router.navigate(['/applicant']);
  }

  onSubmitapplicant(){
    console.log(this.appli);
    this.saveApplicant();
  }
}
