import { Component, OnInit } from '@angular/core';
import { Message } from 'primeng/api';
import { DonorDetails } from '../../donordetails.model';
import { AdddonorService } from '../../services/adddonor.service';
import { CaptchaService } from '../../services/captcha.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrl: './confirmation.component.scss'
})
export class ConfirmationComponent implements OnInit{

  confirminformation: DonorDetails;

  isBloodDonationSuccess: Boolean = false;

  messages: Message[] = [];

  captchaText: string = '';

  captchaInput:string = '';

  submitted: Boolean = false;

  constructor(private adddonor:AdddonorService,private captchaService: CaptchaService){
    this.confirminformation = this.adddonor.getDonorDetails();
  }

  ngOnInit(): void {
    this.generateNewCaptcha();
  }

  complete(){
  this.submitted = true;
  if (this.captchaInput == this.captchaText) {
    this.generateNewCaptcha();
    this.adddonor.saveDonorDetails(this.confirminformation).subscribe(
      (next) => {
        this.isBloodDonationSuccess = true;
        this.adddonor.donorDetails = {
          donorname: '',
          bloodgroup: '',
          mobileno: '',
          countryname: '',
          statename: '',
          districtname: '',
          city: '',
          pincode: '',
          anemia: '',
          alcohol: '',
          bp: '',
          diabetic: '',
          hiv: '',
          medicaltreatment: '',
          previousdonation: ''
        }
      },
      (error) =>{
        this.messages = [{severity:'error',detail:'Donor Registration failed'}];
      }
    )
  }
  }

  generateNewCaptcha(): void {
    this.captchaText = this.captchaService.generateCaptcha();
  }
}
