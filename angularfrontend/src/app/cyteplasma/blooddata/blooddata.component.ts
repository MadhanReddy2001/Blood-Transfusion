import { Component, OnInit } from '@angular/core';
import { BlooddataService } from '../services/blooddata.service';

interface ChartConfig {
    data: {
    labels: string[];
    datasets: {
        data: number[];
        backgroundColor: string[];
        hoverBackgroundColor: string[];
    }[];
    };
    options: {
    plugins: {
        legend: {
        labels: {
            usePointStyle: boolean;
            color: string;
        };
        };
    };
    };
}

@Component({
  selector: 'app-blooddata',
  templateUrl: './blooddata.component.html',
  styleUrl: './blooddata.component.scss'
})
export class BlooddataComponent implements OnInit {

    bloodDataAB: any;
    bloodDataA: any;
    bloodDataB: any;
    bloodDataO: any;
    charts: ChartConfig[] = [];
    groupedBloodGroupCounts: { [key: string]: number[] } = {};

    constructor(private blooddataservice: BlooddataService){}

    ngOnInit(): void {
        this.loadBloodGroupCounts();
    }

    loadBloodGroupCounts(): void {
        this.blooddataservice.getBloodGroupCounts().subscribe(
        (data: { [key: string]: number }) => {
            console.log(data)
            this.groupedBloodGroupCounts = this.blooddataservice.groupBloodGroups(data);
            console.log(this.groupedBloodGroupCounts)
            this.assignCategoryData();
            this.bloodDataChart();
        },
        error => {
            console.error('Error fetching blood group counts', error);
        }
        );
    }
    assignCategoryData() {
        this.bloodDataA = this.groupedBloodGroupCounts['A'] || [];
        this.bloodDataAB = this.groupedBloodGroupCounts['AB'] || [];
        this.bloodDataB = this.groupedBloodGroupCounts['B'] || [];
        this.bloodDataO = this.groupedBloodGroupCounts['O'] || [];
    }
    bloodDataChart() {
        const documentStyle = getComputedStyle(document.documentElement);
        const textColor = documentStyle.getPropertyValue('--text-color');
    
        const bloodDataAB = {
            labels: ['AB+', 'AB-'],
            datasets: [
            {
                data: this.bloodDataAB,
                backgroundColor: [
                documentStyle.getPropertyValue('--blue-500'),
                documentStyle.getPropertyValue('--yellow-500')
                ],
                hoverBackgroundColor: [
                documentStyle.getPropertyValue('--blue-400'),
                documentStyle.getPropertyValue('--yellow-400')
                ]
            }
            ]
        };
    
        const bloodDataA = {
            labels: ['A+', 'A-'],
            datasets: [
            {
                data: this.bloodDataA,
                backgroundColor: [
                documentStyle.getPropertyValue('--red-500'),
                documentStyle.getPropertyValue('--purple-500'),
                ],
                hoverBackgroundColor: [
                documentStyle.getPropertyValue('--red-400'),
                documentStyle.getPropertyValue('--purple-400')
                ]
            }
            ]
        };
    
        const bloodDataB = {
            labels: ['B+', 'B-'],
            datasets: [
            {
                data: this.bloodDataB,
                backgroundColor: [
                documentStyle.getPropertyValue('--cyan-500'),
                documentStyle.getPropertyValue('--pink-500')
                ],
                hoverBackgroundColor: [
                documentStyle.getPropertyValue('--cyan-400'),
                documentStyle.getPropertyValue('--pink-400')
                ]
            }
            ]
        };
    
        const bloodDataO = {
            labels: ['O+', 'O-'],
            datasets: [
            {
                data: this.bloodDataO,
                backgroundColor: [
                documentStyle.getPropertyValue('--pink-500'),
                documentStyle.getPropertyValue('--indigo-500'),
                ],
                hoverBackgroundColor: [
                documentStyle.getPropertyValue('--pink-400'),
                documentStyle.getPropertyValue('--indigo-400'),
                ]
            }
            ]
        };
    
        const chartOptions = {
            plugins: {
            legend: {
                labels: {
                usePointStyle: true,
                color: textColor
                }
            }
            }
        };
        
        this.charts = [
            { data: bloodDataAB, options: chartOptions },
            { data: bloodDataA, options: chartOptions },
            { data: bloodDataB, options: chartOptions },
            { data: bloodDataO, options: chartOptions }
        ];
    }

}
