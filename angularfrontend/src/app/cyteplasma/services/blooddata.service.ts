import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlooddataService {

  private jsonUrl = 'assets/bloodgroups.json'; // Path to the JSON file

  private baseURL = 'api/donordetails';

  private static bloodGroupCategories: { [key: string]: string[] } = {
    'A': ['A+', 'A-'],
    'AB': ['AB+', 'AB-'],
    'O': ['O+', 'O-'],
    'B': ['B+', 'B-']
  };

  constructor(private http: HttpClient) { }

  getBloodGroups(): Observable<any[]> {
    return this.http.get<any[]>(this.jsonUrl);
  }

  getBloodGroupCounts(): Observable<{ [key: string]: number }> {
    const url = `${this.baseURL}/counts`;
    return this.http.get<{ [key: string]: number }>(url);
  }

  groupBloodGroups(counts: { [key: string]: number }): { [key: string]: number[] } {
    const groupedCounts: { [key: string]: number[] } = {};
    for (const [category, groups] of Object.entries(BlooddataService.bloodGroupCategories)) {
      const categoryCounts: number[] = [];
      for (const group of groups) {
        categoryCounts.push(counts[group] || 0);
      }
      groupedCounts[category] = categoryCounts;
    }

    return groupedCounts;
  }
}
