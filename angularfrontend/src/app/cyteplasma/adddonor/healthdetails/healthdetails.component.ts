import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { DropdownChangeEvent } from 'primeng/dropdown';
import { DonorDetails } from '../../donordetails.model';
import { AdddonorService } from '../../services/adddonor.service';

interface NgModelChangeEvent {
  originalEvent: Event;
  value: string;
}

@Component({
  selector: 'app-healthdetails',
  templateUrl: './healthdetails.component.html',
  styleUrl: './healthdetails.component.scss'
})
export class HealthdetailsComponent {

  formGroup: FormGroup | undefined;

  options = [
    { label: 'Yes', value: 'Yes' },
    { label: 'No', value: 'No' }
  ];

  @Input()submitted: boolean = false;

  healthinformation: DonorDetails;

  constructor(private router:Router,private adddonarser: AdddonorService){
    
    this.healthinformation = this.adddonarser.getDonorDetails();
  }

  onChangeAnemia(event:DropdownChangeEvent){
    this.healthinformation.anemia = event.value;
  }

  onChangeAlcohol(event:DropdownChangeEvent){
    this.healthinformation.alcohol = event.value;
  }

  onChangeBP(event:DropdownChangeEvent){
    this.healthinformation.bp = event.value;
  }

  onChangeDiabetics(event:DropdownChangeEvent){
    this.healthinformation.diabetic = event.value;
  }

  onChangeHIV(event:DropdownChangeEvent){
    this.healthinformation.hiv = event.value;
  }

  onChangeMedicalTreatment(event:DropdownChangeEvent){
    this.healthinformation.medicaltreatment = event.value;
  }

  onChangePreviousDonation(event:DropdownChangeEvent){
    this.healthinformation.previousdonation = event.value;
  }

  isFormValid(): boolean {

    return !!(this.healthinformation.alcohol && this.healthinformation.anemia &&
              this.healthinformation.bp && this.healthinformation.diabetic &&
              this.healthinformation.hiv && this.healthinformation.medicaltreatment
    )
  }
  
  focusFirstInvalidField(): void {
    const invalidField = document.querySelector('.ng-invalid');
    if (invalidField) {
      (invalidField as HTMLElement).focus();
    }
  }
}
