//Survey Data Interface
export interface Survey {
    id: number;
    firstName: string;
    lastName: string;
    street: string;
    city: string;
    state: string;
    zip: string;
    phone: string;
    email: string;
    surveyDate: string; 
    students: number;
    location: number;
    campus: number;
    atmosphere: number;
    dormRooms: number;
    sports: number;
    sourceOfInterest: string;
    likelihood: string; 
    additionalComments: string;
  }
  