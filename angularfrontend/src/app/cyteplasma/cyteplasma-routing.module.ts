import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdddonorComponent } from './adddonor/adddonor.component';
import { ConfirmationComponent } from './adddonor/confirmation/confirmation.component';
import { DonordetailsComponent } from './adddonor/donordetails/donordetails.component';
import { HealthdetailsComponent } from './adddonor/healthdetails/healthdetails.component';
import { BloodmenuComponent } from './bloodmenu/bloodmenu.component';

const routes: Routes = [
  {path:'menu',component:BloodmenuComponent,
    children :[
      {
        path:'donate',component:AdddonorComponent,
        children:[
          {path:'donordetails',component:DonordetailsComponent},
          {path:'healthdetails',component:HealthdetailsComponent},
          {path:'confirmation',component:ConfirmationComponent},
          {path: '',redirectTo: 'donordetails',pathMatch: 'full' }
        ]
    }
    ]
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CyteplasmaRoutingModule { }
