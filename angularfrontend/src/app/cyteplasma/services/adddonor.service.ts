import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonorDetails } from '../donordetails.model';

@Injectable({
  providedIn: 'root'
})
export class AdddonorService {

  private donorDetails: DonorDetails = {
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
};

  httpOptions:any = {
    headers: new HttpHeaders({
      'Accept' : 'application/json',
      'Content-Type':'application/json'
    })
  }
  private baseURL = 'api/donordetails';
  private baseURL2 = 'api/countries';
  constructor(private http:HttpClient) { }

  getDonorDetails(): DonorDetails {
    return this.donorDetails;
  }

  setDonorDetails(details: DonorDetails): void {
    this.donorDetails = details;
  }

  pincodes():Observable<any>{
    const url = `${this.baseURL2}`;
    return this.http.get(url,this.httpOptions);
  }

  saveDonorDetails(donorDetails: any): Observable<any> {
    const url = `${this.baseURL}/adddonor`;
    return this.http.post(url,donorDetails,this.httpOptions);
  }

}
