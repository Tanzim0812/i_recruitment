import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { CreateApplicantComponent } from './create-applicant/create-applicant.component';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { UpdateApplicantComponent } from './update-applicant/update-applicant.component';
import { UpdateVacancyComponent } from './update-vacancy/update-vacancy.component';
import { VacancyListComponent } from './vacancy-list/vacancy-list.component';

const routes: Routes = [
  {  path:'vacancy',component:VacancyListComponent},
  
  { path:'create-vacancy',component:CreateVacancyComponent},

  { path: '', redirectTo:'vacancy',pathMatch:'full'},
  { path: 'update-vacancy/:id', component:UpdateVacancyComponent},

  { path: 'applicant',component:ApplicantListComponent},
  { path:'create-applicant',component:CreateApplicantComponent},
  { path:'update-applicant/:id',component:UpdateApplicantComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
