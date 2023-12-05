/*
  Authors:
	Nikitha Ranga
	Niharika
	Sridevi Movva
	Shubhakar Kodunu
*/

package com.example.demo;
import jakarta.persistence.*;

//Enitiy Class
@Entity
@Table(name = "survey")
public class Survey {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq")
    @SequenceGenerator(name = "entity_seq", sequenceName = "entity_seq", allocationSize = 1)
    public Long id;
	
	@Column(name="FIRSTNAME", nullable = false)
	public String firstName;
	
	@Column(name="LASTNAME", nullable = false)
	public String lastName;
	
	@Column(name="STREET", nullable = false)
	public String street;
	
	@Column(name="CITY", nullable = false)
	public String city;
	
	@Column(name="state", nullable = false)
	public String state;
	
	@Column(name="ZIP", nullable = false)
	public String zip;
	
	@Column(name="PHONE", nullable = false)
	public String phone;
	
	@Column(name="EMAIL", nullable = false)
	public String email;
	
	@Column(name="SURVEYDATE", nullable = false)
	public String surveyDate;
	
	@Column(name="STUDENTS", nullable = false)
	public int students; 
	
	@Column(name="location", nullable = false)
	public int location;
	
	@Column(name="CAMPUS", nullable = false)
	public int campus;
	
	@Column(name="ATMOSPHERE", nullable = false)
	public int atmosphere; 
	
	@Column(name="DORMROOMS", nullable = false)
	public int dormRooms;
	
	@Column(name="SPORTS", nullable = false)
	public int sports;
	
	@Column(name="SOURCEOFINTEREST", nullable = false)
	public String sourceOfInterest;
	
	@Column(name="LIKELIHOOD", nullable = false)
	public String likelihood;
	
	@Column(name="ADDITIONALCOMMENTS", nullable = false)
	public String additionalComments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}
	public int getStudents() {
		return students;
	}
	public void setStudents(int students) {
		this.students = students;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getCampus() {
		return campus;
	}
	public void setCampus(int campus) {
		this.campus = campus;
	}
	public int getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(int atmosphere) {
		this.atmosphere = atmosphere;
	}
	public int getDormRooms() {
		return dormRooms;
	}
	public void setDormRooms(int dormRooms) {
		this.dormRooms = dormRooms;
	}
	public int getSports() {
		return sports;
	}
	public void setSports(int sports) {
		this.sports = sports;
	}
	public String getSourceOfInterest() {
		return sourceOfInterest;
	}
	public void setSourceOfInterest(String sourceOfInterest) {
		this.sourceOfInterest = sourceOfInterest;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	public String getAdditionalComments() {
		return additionalComments;
	}
	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
}
