import { CommonModule, DatePipe } from '@angular/common';
import { NgModule } from '@angular/core';

import { MessageService } from 'primeng/api';
import { MessagesModule } from 'primeng/messages';
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
import { SuccesimageComponent } from './messagecomponent/succesimage/succesimage.component';
import { FilterPincodePipePipe } from './pipes/filter-pincode-pipe.pipe';
import { ViewdonorComponent } from "./viewdonors/viewdonor/viewdonor.component";


@NgModule({
  declarations: [
    BloodmenuComponent,
    AdddonorComponent,
    ConfirmationComponent,
    DonordetailsComponent,
    HealthdetailsComponent,
    BlooddataComponent,
    ViewdonorComponent,
    SuccesimageComponent
  ],
  imports: [
    CommonModule,
    CyteplasmaRoutingModule,
    PrimengModule,
    CheckeligibilityComponent,
    BloodrequestComponent
],
  providers: [
  FilterPincodePipePipe,
  DatePipe,
  MessageService,
  MessagesModule
  ]
})
export class CyteplasmaModule { }
