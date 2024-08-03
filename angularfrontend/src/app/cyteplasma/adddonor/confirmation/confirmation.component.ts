import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DonorDetails } from '../../donordetails.model';
import { AdddonorService } from '../../services/adddonor.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrl: './confirmation.component.scss'
})
export class ConfirmationComponent {

  confirminformation: DonorDetails;

  constructor(private router:Router,private adddonor:AdddonorService){
    this.confirminformation = this.adddonor.getDonorDetails();
  }

  complete(){
  this.adddonor.saveDonorDetails(this.confirminformation).subscribe(
    (next) => {

    },
    (error) =>{

    }
  )
  }
}
