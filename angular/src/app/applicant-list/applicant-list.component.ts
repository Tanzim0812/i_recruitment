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
   this.getApplicant();
  }
  private getApplicant(){
    this.appservice.getApplicantList().subscribe(data =>{
      this.applicantlist=data;
    })
  }

  updateApplicant(id:number){
    this.router.navigate(['update-applicant',id]);
}

deleteApplicant(id:number){
  this.appservice.deleteApplicant(id).subscribe(data => {
    console.log(data);
    this.getApplicant();
    //this.router.navigate(['/vacancy']);
  })
}


}
