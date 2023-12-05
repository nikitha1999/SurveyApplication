// Importing Basic and Required Modules
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Survey } from './models/survey'; 

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  // GET API Call - to aget all Survey's Data
  getData(): Observable<Survey[]> {
    const url = 'http://localhost:8080/all';
    return this.http.get<Survey[]>(url);
  }

  // POST API Call - to add a new Survey
  postData(data: Survey): Observable<String> { 
    const url = 'http://localhost:8080/add';
    return this.http.post(url, data, { responseType: 'text' });
  }

  // PUT API Call - to Update the existing Survey Data
  putData(id: number, data: Survey): Observable<String> { 
    const url = 'http://localhost:8080/update/' + id;
    return this.http.put(url, data, { responseType: 'text' });
  }

  // DELETE API Call - to delete the existing Survey
  deleteData(id: number): Observable<String> { 
    const url = 'http://localhost:8080/delete/' + id;
    return this.http.delete(url, { responseType: 'text' });
  }

  // Method to convert the UI object Values to Survey Object for easy API Communication
  formatUIDataToSurveyObject(data: any): Survey{
    return {
      id: 0, 
      firstName: data.firstname, 
      lastName: data.lastname, 
      street: data.address, 
      city: data.city,
      state: data.state,
      zip: data.zip, 
      phone: data.phone,
      email: data.email,
      surveyDate: data.surveydata, 
      students: data.campus.Students ? 1:0, 
      location: data.campus.Location ? 1:0, 
      campus: data.campus.Campus ? 1:0, 
      atmosphere: data.campus.Atmosphere ? 1:0,
      dormRooms: data.campus.DormRooms ? 1:0,
      sports: data.campus.Sports ? 1:0,
      sourceOfInterest: data.universityhear,
      likelihood: data.likelihoodOfRecommendation, 
      additionalComments: data.comments
    };
  }
}
