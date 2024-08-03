import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-adddonor',
  templateUrl: './adddonor.component.html',
  styleUrl: './adddonor.component.scss'
})
export class AdddonorComponent implements OnInit{

  items: MenuItem[] | undefined;

  active: number = 0;
  constructor(private route:Router){}
  ngOnInit(){

    this.items = [
      {
        label : 'Donor',
        routerLink : 'donate/donordetails'
      },
      {
        label:'Health',
        routerLink:'donate/healthdetails'
      },
      {
        label:'Confirmation',
        routerLink:'donate/confirmation'
      }
    ]
  }
}

