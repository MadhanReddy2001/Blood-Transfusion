import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { BlooddataService } from '../services/blooddata.service';
import { DonordetailsComponent } from './donordetails/donordetails.component';
import { HealthdetailsComponent } from './healthdetails/healthdetails.component';

@Component({
  selector: 'app-adddonor',
  templateUrl: './adddonor.component.html',
  styleUrl: './adddonor.component.scss'
})
export class AdddonorComponent implements OnInit{

  items: MenuItem[] | undefined;

  active: number = 0;

  submitted: boolean = false;
  submitHealth: boolean = false;
  @ViewChild('donorDetails', { static: false }) donorDetails!: DonordetailsComponent;
  @ViewChild('healthDetails', { static: false }) healthDetails!: HealthdetailsComponent;
  constructor(private route:Router,private bloodDataService: BlooddataService){}
  ngOnInit(){

    this.items = [
      {
        label : 'Donor',
        routerLink : 'donate/donordetails'
      },
      {
        label:'Health',
        routerLink:'donate/healthdetails'
      },
      {
        label:'Confirmation',
        routerLink:'donate/confirmation'
      }
    ]
  }

  handleNext(nextCallback: any, donorDetails: DonordetailsComponent): void {
    this.submitted = true;
    if (donorDetails.isFormValid()) {
      nextCallback.emit();
    } else {
      donorDetails.focusFirstInvalidField();
    }
  }

  handleHealthNext(nextCallback: any, healthDetails: HealthdetailsComponent): void {
    this.submitHealth = true;
    if (healthDetails.isFormValid()) {
      nextCallback.emit();
    } else {
      healthDetails.focusFirstInvalidField();
    }
  }

  validateAndNavigate(onClick: any, index: number) {
      if (!this.donorDetails || this.donorDetails.isFormValid()) {
          onClick.emit();
          this.active = index;
      } else {
          this.submitted = true;
      }
  }

  validateAndNavigateComplete(onClick: any, index: number) {
      if ((!this.healthDetails || this.healthDetails.isFormValid()) && (!this.donorDetails || this.donorDetails.isFormValid())) {
          onClick.emit();
          this.active = index;
      } else {
          this.submitHealth = true;
      }
  }
}

