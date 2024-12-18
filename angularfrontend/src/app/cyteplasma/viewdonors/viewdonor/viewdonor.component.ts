import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { catchError, of, tap } from 'rxjs';
import { DonorDetails } from '../../donordetails.model';
import { AdddonorService } from '../../services/adddonor.service';

@Component({
  selector: 'app-viewdonor',
  templateUrl: './viewdonor.component.html',
  styleUrl: './viewdonor.component.scss',
})
export class ViewdonorComponent implements OnInit {
  
  donordetails!: DonorDetails[];

  layout: string = "'list'";
  
  constructor(private productService: AdddonorService) {}

  ngOnInit() {
    this.productService.getAllDonorDetails().pipe(
      tap((data) => {
        this.donordetails = data;
        console.log("Donor details",data)
      }),
      catchError((error: HttpErrorResponse) => {
        console.error('Error occurred while getting donordetails:', error);
        return of([]);
      })
    ).subscribe();
  }
  
}
