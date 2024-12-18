import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { BlooddataService } from '../services/blooddata.service';

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
  panelSizes: number[] = [6, 94];
  panelMinSizes: number[] = [6, 0];
  constructor(private datePipe: DatePipe,public bloodDataService: BlooddataService) { 
    this.setPanelSizesBasedOnScreenWidth();
  }

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
        icon: 'assets/images/add-donor.png',
        name: 'Donate Blood',
        command: () => {
          this.showDonateBlood = true;
          this.viewDonorDetails = false;
          this.checkEligibilty = false;
          this.isBloodRequested = false;
          this.scrollToPanel('donateBloodPanel');
      }
      },
      {
        label: 'View Donors',
        icon: 'assets/images/viewdonors.png',
        name: 'View Donors',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = true;
          this.checkEligibilty = false;
          this.isBloodRequested = false;
          this.scrollToPanel('viewDonorsPanel');
        }
      },
      {
        label: 'Check Eligibility',
        icon: 'assets/images/checkeligibility.png',
        name: 'Check Eligibility',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = false;
          this.checkEligibilty = true;
          this.isBloodRequested = false;
          this.scrollToPanel('checkEligibilityPanel');
        }
      },
      {
        label: 'Request Blood',
        icon: 'assets/images/requestblood.png',
        name: 'Request Blood',
        command: () => {
          this.showDonateBlood = false;
          this.viewDonorDetails = false;
          this.checkEligibilty = false;
          this.isBloodRequested = true;
          this.scrollToPanel('requestBloodPanel');
        }
      },
  ]
  }

  updateDateTime(): void {
    const now = new Date();
    this.currentDateTime = this.datePipe.transform(now, 'MMMM d, y, h:mm:ss a');
  }

  scrollToPanel(panelId: string) {
    setTimeout(() => {
      const element = document.getElementById(panelId);
      if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    }, 100);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.setPanelSizesBasedOnScreenWidth();
  }

  setPanelSizesBasedOnScreenWidth() {
    const screenWidth = window.innerWidth;
    if (screenWidth <= 768) {
      this.panelSizes = [20, 80];
      this.panelMinSizes = [20, 0];
    } else if (screenWidth <= 1024) {
      this.panelSizes = [10, 90];
    } else {
      this.panelSizes = [8, 92];
      this.panelMinSizes = [8, 0];
    }
  }
}
