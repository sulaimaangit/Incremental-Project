import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { RegistrationComponent } from '../registration/registration.component';
import { HomeComponent } from '../home/home.component';
import { AdminComponent } from '../admin/admin.component';
import { OrganizerComponent } from '../organizer/organizer.component';
import { ErrorComponent } from '../error/error.component';

const routes: Routes = [
    {path:'login',component:LoginComponent},
    {path:'register',component:RegistrationComponent},
    {path:"",component:HomeComponent},
    {path:"home",component:HomeComponent},
  {path:"admin",component:AdminComponent},
  {path:"organizer",component:OrganizerComponent},
  {path:"error",component:ErrorComponent},
  {path:"**",redirectTo:"/error",pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
