import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VacancyListComponent } from './vacancy-list/vacancy-list.component';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { FormsModule } from '@angular/forms';
import { UpdateVacancyComponent } from './update-vacancy/update-vacancy.component';

@NgModule({
  declarations: [
    AppComponent,
    VacancyListComponent,
    CreateVacancyComponent,
    UpdateVacancyComponent
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
