import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DonorDetails } from '../../donordetails.model';
import { City, Country, Pincodes } from '../../locationdetails.model';
import { FilterPincodePipePipe } from '../../pipes/filter-pincode-pipe.pipe';
import { AdddonorService } from '../../services/adddonor.service';
import { BlooddataService } from '../../services/blooddata.service';
import { LocationdetailsService } from '../../services/locationdetails.service';

interface AutoCompleteCompleteEvent {
  originalEvent: Event;
  query: string;
}

interface AutoCompleteSelectEvent {
  originalEvent: Event;
  value: any;
}

interface NgModelChangeEvent {
  originalEvent: Event;
  pincode: string;
  value: string;
}

@Component({
  selector: 'app-donordetails',
  templateUrl: './donordetails.component.html',
  styleUrl: './donordetails.component.scss'
})
export class DonordetailsComponent implements OnInit{
  donorinformation: DonorDetails;
  
  submitted: boolean = false;

  pincode: string[] = [];

  cities: string[] = [];

  filteredpincode : any[] = [];

  filteredcities: any[] = [];

  data: Country[] = [];

  filteredBloodGroups: any[] = [];
 
  bloodgroup: any[] = [];

  locationDetails={
    countryname: '',
    statename: '',
    districtname: '',
    cities: [],
    pincode: ''
  };
  
constructor(private router:Router,private adddonorser:AdddonorService,private locationdetails:LocationdetailsService,
            private filterpincodepipe:FilterPincodePipePipe,private bloodgroupService: BlooddataService){
  this.donorinformation = this.adddonorser.getDonorDetails();
}

ngOnInit(): void {
  this.locationdetails.getLocationDetails().subscribe((data)=> this.data = data);
  this.bloodgroupService.getBloodGroups().subscribe(data => {
    this.bloodgroup = data;
  });
}

filterPincodes() {
  this.pincode = this.data
      .map(country => country.states
        .map(state => state.districts
          .map(district => district.pincodes
            .map(pincode => pincode.pincode)
          )
        )
      )
      .reduce((acc, val) => acc.concat(val), [])
      .reduce((acc, val) => acc.concat(val), [])
      .reduce((acc, val) => acc.concat(val), [])
      .filter((value, index, self) => self.indexOf(value) === index);
      console.log('pincode',this.pincode)
}

getPincodes(event: AutoCompleteCompleteEvent) {
  this.filterPincodes();
  let query = event.query.toLowerCase();
  let filtered: Pincodes[] = (this.pincode as any[])
  .filter((pincode: string) => pincode.toLowerCase().includes(query))
  .map((pincode: string) => ({ pincode: pincode }));
  this.filteredpincode = filtered;
}

ngModelChangePincodes(event:NgModelChangeEvent) {
  if(event.pincode != undefined){
    this.locationDetails = this.filterpincodepipe.transform(this.data,event.pincode);
  }
  else{
    this.locationDetails = this.filterpincodepipe.transform(this.data,this.donorinformation.pincode);
  }
    if(this.locationDetails !=null){
      this.donorinformation.countryname = this.locationDetails.countryname;
      this.donorinformation.statename = this.locationDetails.statename;
      this.donorinformation.districtname = this.locationDetails.districtname;
      this.cities = this.locationDetails.cities;
  }
  }

getCities(event:AutoCompleteCompleteEvent){
  let query = event.query.toLowerCase();
  let filtered: City[] = (this.cities as any[])
                          .filter((cities: string) => cities.toLowerCase().includes(query))
                          .map((cities:string) => ({cities:cities}))
  this.filteredcities = filtered
                          
}

onSelectPincode(event:AutoCompleteSelectEvent){
this.donorinformation.pincode = event.value.pincode;
}

onSelectCity(event:AutoCompleteSelectEvent){
  this.donorinformation.city = event.value.cities;
}

completeMethodBloodGroup(event:AutoCompleteCompleteEvent){
  let query = event.query.toLowerCase();
  let filtered = this.bloodgroup
        .filter((group) => group.bloodgroup.toLowerCase().includes(query))
        .map((group) => ({ bloodgroup: group.bloodgroup }));
    this.filteredBloodGroups = filtered;
}

onSelectBloodGroup(event:AutoCompleteSelectEvent){
  this.donorinformation.bloodgroup = event.value.bloodgroup;
}

}
