import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../locationdetails.model';

@Injectable({
  providedIn: 'root'
})
export class LocationdetailsService {
  private baseURL = 'api/countries';

  constructor(private http:HttpClient) { }

  getLocationDetails():Observable<Country[]>{
    const url = `${this.baseURL}/getlocation`;
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      })
    };
    return this.http.get<Country[]>(url, httpOptions);
  }
}
