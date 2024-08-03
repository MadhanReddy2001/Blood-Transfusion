import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-bloodmenu',
  templateUrl: './bloodmenu.component.html',
  styleUrl: './bloodmenu.component.scss'
})
export class BloodmenuComponent implements OnInit{
  menuItems: any[] = [];
  isdonate: boolean | undefined;
  mainMenuDockItems: MenuItem[] | undefined;
  currentDateTime: string | null = '';
  showDonateBlood: boolean | any;
  viewDonorDetails: boolean | any;
  checkEligibilty: boolean | any;
  isBloodRequested: boolean | any;

  constructor(private datePipe: DatePipe) { }

  ngOnInit(){
    this.updateDateTime();
    setInterval(() => {
      this.updateDateTime();
    }, 1000);

  this.menuItems = [
    {
      label : 'Blood',
      items:[
        {
          label: 'Donate',
          icon: '',
          // routerLink: 'donate/donordetails',
          command:()=>{
            
          }
        }
      ]
    }
  ]

  this.mainMenuDockItems = [
      {
        label: 'Donate Blood',
        icon: 'assets/images/add-donor.svg',
        name: 'Donate Blood',
        command: () => {
          this.showDonateBlood = true;
          this.viewDonorDetails = false;
          this.checkEligibilty = false;
          this.isBloodRequested = false;
      }
      },
      {
        label: 'View Donors',
        icon: 'assets/images/add-donor.png',
        name: 'View Donors',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = true;
          this.checkEligibilty = false;
          this.isBloodRequested = false;
        }
      },
      {
        label: 'Check Eligibility',
        icon: 'assets/images/eligibility.svg',
        name: 'Check Eligibility',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = false;
          this.checkEligibilty = true;
          this.isBloodRequested = false;
        }
      },
      {
        label: 'Request Blood',
        icon: 'assets/images/donate.png',
        name: 'Request Blood',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = false;
          this.checkEligibilty = false;
          this.isBloodRequested = true;
        }
      },
  ]
  }

  updateDateTime(): void {
    const now = new Date();
    this.currentDateTime = this.datePipe.transform(now, 'MMMM d, y, h:mm:ss a');
  }

}
