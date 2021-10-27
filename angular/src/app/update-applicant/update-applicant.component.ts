import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Applicant } from '../applicant';
import { ApplicantService } from '../applicant.service';

@Component({
  selector: 'app-update-applicant',
  templateUrl: './update-applicant.component.html',
  styleUrls: ['./update-applicant.component.css']
})
export class UpdateApplicantComponent implements OnInit {

  id!: number;
  appli:Applicant = new Applicant();
  constructor(private appservice:ApplicantService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.appservice.getApplicantById(this.id).subscribe(data=>{

      this.appli=data;

    },
    error=>console.error()
    );
  }

  onSubmitup(){
    this.appservice.updateApplicant(this.id, this.appli).subscribe(data=>{
      this.gotoup();
    }
    );
   
  }
 
  

  gotoup(){
    this.router.navigate(['/applicant']);
  }
 
}
