import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms'; 
import { trigger, state, style, animate, transition } from '@angular/animations';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { DataService } from '../data.service';


@Component({
  selector: 'app-styled-form',
  templateUrl: './styled-form.component.html',
  styleUrls: ['./styled-form.component.css']
})
export class StyledFormComponent {
  @ViewChild('myForm') myForm!: NgForm; //binding form reference
  @ViewChild('resetButton') resetButton: any;

  constructor(private dataService: DataService) {

  }
  surveyData: any = {
    firstname: '',
    lastname:'',
    email:'',
    address:'',
    city:'',
    state:'',
    zip:'',
    phone:'',
    surveydata:'',
    likelihoodOfRecommendation:'',
    universityhear:'',
    mostcampus: [],
    campus:[],
    comments:''
  };
  howHeardOptions = ['Friends', 'Television', 'Internet', 'Other'];
  likedOptions = ['Students', 'Location', 'Campus', 'Atmosphere', 'DormRooms', 'Sports'];
  
  

  submitForm(form: any): void {
    if (form.valid) {
      var surveyData = this.dataService.formatUIDataToSurveyObject(this.surveyData);
      console.log(surveyData);
      this.dataService.postData(surveyData).subscribe({
        next: (response) => {
          console.log('Response from server:', response);
          alert("Submitted Survey Successfully");
          window.location.reload();
        },
        error: (error) => {
          console.error('Error:', error);
          alert("Error: " + error);
        }
      });
    } else {
      console.log('Form is invalid. Please check the fields.');
    }
  }
  
  onCheckboxChange(event: MatCheckboxChange, option: string): void {
    this.surveyData.campus[option] = event.checked;
  }
   
  
  resetForm() {
    this.myForm.resetForm();
    this.surveyData = {
        firstname: '',
        lastname:'',
        email:'',
        address:'',
        city:'',
        state:'',
        zip:'',
        phone:'',
        surveydata:'',
        likelihoodOfRecommendation:'',
        universityhear:'',
        mostcampus: [],
        campus:[],
        comments:''
    };
    this.resetCheckboxes();
  }
  
  resetCheckboxes() {
    this.surveyData.campus = {};
  }
}