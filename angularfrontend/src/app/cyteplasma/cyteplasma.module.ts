import { CommonModule, DatePipe } from '@angular/common';
import { NgModule } from '@angular/core';

import { PrimengModule } from '../primeng/primeng.module';
import { AdddonorComponent } from './adddonor/adddonor.component';
import { ConfirmationComponent } from './adddonor/confirmation/confirmation.component';
import { DonordetailsComponent } from './adddonor/donordetails/donordetails.component';
import { HealthdetailsComponent } from './adddonor/healthdetails/healthdetails.component';
import { BlooddataComponent } from "./blooddata/blooddata.component";
import { BloodmenuComponent } from './bloodmenu/bloodmenu.component';
import { BloodrequestComponent } from "./bloodrequests/bloodrequest/bloodrequest.component";
import { CyteplasmaRoutingModule } from './cyteplasma-routing.module';
import { CheckeligibilityComponent } from "./eligibility/checkeligibility/checkeligibility.component";
import { FilterPincodePipePipe } from './pipes/filter-pincode-pipe.pipe';
import { ViewdonorComponent } from "./viewdonors/viewdonor/viewdonor.component";


@NgModule({
  declarations: [
    BloodmenuComponent,
    AdddonorComponent,
    ConfirmationComponent,
    DonordetailsComponent,
    HealthdetailsComponent,
    BlooddataComponent
  ],
  imports: [
    CommonModule,
    CyteplasmaRoutingModule,
    PrimengModule,
    ViewdonorComponent,
    CheckeligibilityComponent,
    BloodrequestComponent
],
  providers: [
  FilterPincodePipePipe,
  DatePipe
  ]
})
export class CyteplasmaModule { }
