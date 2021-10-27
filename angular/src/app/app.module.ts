import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VacancyListComponent } from './vacancy-list/vacancy-list.component';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { FormsModule } from '@angular/forms';
import { UpdateVacancyComponent } from './update-vacancy/update-vacancy.component';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { CreateApplicantComponent } from './create-applicant/create-applicant.component';
import { UpdateApplicantComponent } from './update-applicant/update-applicant.component';

@NgModule({
  declarations: [
    AppComponent,
    VacancyListComponent,
    CreateVacancyComponent,
    UpdateVacancyComponent,
    ApplicantListComponent,
    CreateApplicantComponent,
    UpdateApplicantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
