import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Applicant } from '../applicant';
import { ApplicantService } from '../applicant.service';
@Component({
  selector: 'app-applicant-list',
  templateUrl: './applicant-list.component.html',
  styleUrls: ['./applicant-list.component.css']
})


export class ApplicantListComponent implements OnInit {

  applicantlist: Applicant[] | undefined;
  constructor( private appservice:ApplicantService,
    private router:Router
    
    ) { }

  ngOnInit(): void {
   this.getVacancy();
  }
  private getVacancy(){
    this.appservice.getApplicantList().subscribe(data =>{
      this.applicantlist=data;
    })
  }


}
