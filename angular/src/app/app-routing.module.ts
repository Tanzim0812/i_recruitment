import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { UpdateVacancyComponent } from './update-vacancy/update-vacancy.component';
import { VacancyListComponent } from './vacancy-list/vacancy-list.component';

const routes: Routes = [
  {  path:'vacancy',component:VacancyListComponent},
  { path:'create-vacancy',component:CreateVacancyComponent},
  { path: '', redirectTo:'vacancy',pathMatch:'full'},
  { path: 'update-vacancy/:id', component:UpdateVacancyComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
