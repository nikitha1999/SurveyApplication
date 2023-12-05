//List All Surveys TS file
//Importing required Packages
import { Component, OnInit, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatSort } from "@angular/material/sort";
import { DataService } from "../data.service";
import { Survey } from "../models/survey";
import { MatDialog } from "@angular/material/dialog";
import { DialogBoxComponent } from "../dialog-box/dialog-box.component";

interface SurveyWithAction extends Survey {
  action: string;
}

@Component({
  selector: "app-list-all-surveys",
  templateUrl: "./list-all-surveys.component.html",
  styleUrls: ["./list-all-surveys.component.css"],
})
export class ListAllSurveysComponent implements OnInit {
  displayedColumns: string[] = [
    "id",
    "firstName",
    "lastName",
    "street",
    "city",
    "state",
    "zip",
    "phone",
    "email",
    "surveyDate",
    "students",
    "location",
    "campus",
    "atmosphere",
    "dormRooms",
    "sports",
    "sourceOfInterest",
    "likelihood",
    "additionalComments",
    "action",
  ];
  columnHeaders: { [key: string]: string } = {
    id: "Survey ID",
    firstName: "First Name",
    lastName: "Last Name",
    street: "Street",
    city: "City",
    state: "State",
    zip: "Zip",
    phone: "Phone",
    email: "Email",
    surveyDate: "Survey Date",
    students: "Students",
    location: "Location",
    campus: "Campus",
    atmosphere: "Atmosphere",
    dormRooms: "Dorm Rooms",
    sports: "Sports",
    sourceOfInterest: "Source of Interest",
    likelihood: "Likelihood",
    additionalComments: "Additional Comments",
    action: "Action",
  };
  data: MatTableDataSource<SurveyWithAction>; // Use the new type
  actionColumn: string = "action"; // Added 'action' column

  @ViewChild(MatSort, { static: true }) sort!: MatSort;

  constructor(private dataService: DataService, public dialog: MatDialog) {
    this.data = new MatTableDataSource<SurveyWithAction>([]);
  }

  ngOnInit() {
    this.dataService.getData().subscribe(
      (receivedData) => {
        const dataWithAction: SurveyWithAction[] = receivedData.map(
          (survey) => ({
            ...survey,
            action: this.actionColumn,
          })
        );
        this.data = new MatTableDataSource<SurveyWithAction>(dataWithAction);
        this.data.sort = this.sort; // Apply sorting
      },
      (error) => {
        console.error("Error fetching data: ", error);
      }
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.toLowerCase();
    this.data.filter = filterValue;
  }

  openDialog(action: any, obj: any) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: "250px",
      data: obj,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result.event == "Update") {
        this.updateRowData(result.data);
      } else if (result.event == "Delete") {
        this.deleteRowData(result.data);
      }
    });
  }

  updateRowData(row_obj: SurveyWithAction) {
    const { action: _, ...updatedDataWithoutAction } = row_obj;
    this.data.data = this.data.data.map((value) => {
      if (value.id === row_obj.id) {
        // Update the properties accordingly excluding 'action'
        Object.assign(value, updatedDataWithoutAction);
        console.log(value);
        this.dataService.putData(row_obj.id, value).subscribe({
          next: (response) => {
            console.log("Response from server:", response);
            alert("Data Updated Successfully");
            window.location.reload();
          },
          error: (error) => {
            console.error("Error:", error);
            alert("Error: " + error);
          },
        });
      }
      return value;
    });
  }

  deleteRowData(row_obj: SurveyWithAction) {
    const { action: _, ...deletedDataWithoutAction } = row_obj;
    this.data.data = this.data.data.filter((value) => {
      this.dataService.deleteData(row_obj.id).subscribe({
        next: (response) => {
          console.log("Response from server:", response);
          alert("Data Deleted Successfully");
          window.location.reload();
        },
        error: (error) => {
          console.error("Error:", error);
          //alert("Error: " + error);
        },
      });
      return value.id !== row_obj.id;
    });
  }
}
