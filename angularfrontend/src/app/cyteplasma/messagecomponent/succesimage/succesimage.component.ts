import { Component } from '@angular/core';
import { BlooddataService } from '../../services/blooddata.service';

@Component({
  selector: 'app-succesimage',
  templateUrl: './succesimage.component.html',
  styleUrl: './succesimage.component.scss'
})
export class SuccesimageComponent {
  constructor(private bloodDataService: BlooddataService){}
  ngOnInit(){

    // this.bloodDataService.isBloodDonationSuccess = false;
  }
}
