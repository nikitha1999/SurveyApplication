/*
  Authors:
	Nikitha Ranga
	Niharika
	Sridevi Movva
	Shubhakar Kodunu
*/

package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller Class
@Controller
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping(path = "/")
public class SurveyController {
	
	private SurveyRepository surveyRepository;
	
	@Autowired
	public SurveyController(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> addSurveyInformation(@RequestBody Survey surveyInfo)
	{
		Survey survey = new Survey();
		survey.setFirstName(surveyInfo.firstName);
		survey.setLastName(surveyInfo.lastName);
		survey.setStreet(surveyInfo.street);
		survey.setCity(surveyInfo.city);
		survey.setState(surveyInfo.state);
		survey.setZip(surveyInfo.zip);
		survey.setPhone(surveyInfo.phone);
		survey.setEmail(surveyInfo.email);
		survey.setSurveyDate(surveyInfo.surveyDate);
		survey.setStudents(surveyInfo.students);
		survey.setLocation(surveyInfo.location);
		survey.setCampus(surveyInfo.campus);
		survey.setAtmosphere(surveyInfo.atmosphere);
		survey.setDormRooms(surveyInfo.dormRooms);
		survey.setSports(surveyInfo.sports);
		survey.setSourceOfInterest(surveyInfo.sourceOfInterest);
		survey.setLikelihood(surveyInfo.likelihood);
		survey.setAdditionalComments(surveyInfo.additionalComments);
		surveyRepository.save(survey);
		
		return ResponseEntity.ok("Survey Completed Successfully");
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Survey> getSurveysCompleted() {
		return surveyRepository.findAll();
	}
	
	@PutMapping(path = "/update/{surveyid}") 
    public ResponseEntity<String> updateSurveyData(@RequestBody Survey surveyInfo, @PathVariable Long surveyid) {

        Optional<Survey> currentSurveyOptional = surveyRepository.findById(surveyid);

        if (currentSurveyOptional.isPresent()) {
            Survey currentSurvey = currentSurveyOptional.get();

            currentSurvey.setFirstName(surveyInfo.firstName);
    		currentSurvey.setLastName(surveyInfo.lastName);
    		currentSurvey.setStreet(surveyInfo.street);
    		currentSurvey.setCity(surveyInfo.city);
    		currentSurvey.setState(surveyInfo.state);
    		currentSurvey.setZip(surveyInfo.zip);
    		currentSurvey.setPhone(surveyInfo.phone);
    		currentSurvey.setEmail(surveyInfo.email);
    		currentSurvey.setSurveyDate(surveyInfo.surveyDate);
    		currentSurvey.setStudents(surveyInfo.students);
    		currentSurvey.setLocation(surveyInfo.location);
    		currentSurvey.setCampus(surveyInfo.campus);
    		currentSurvey.setAtmosphere(surveyInfo.atmosphere);
    		currentSurvey.setDormRooms(surveyInfo.dormRooms);
    		currentSurvey.setSports(surveyInfo.sports);
    		currentSurvey.setSourceOfInterest(surveyInfo.sourceOfInterest);
    		currentSurvey.setLikelihood(surveyInfo.likelihood);
    		currentSurvey.setAdditionalComments(surveyInfo.additionalComments);
        
            surveyRepository.save(currentSurvey);

            return ResponseEntity.ok("Information is now updated");
        } 
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/delete/{surveyid}") 
    public ResponseEntity<String> deleteSurveyById(@PathVariable Long surveyid) {

        Optional<Survey> currentSurveyOptional = surveyRepository.findById(surveyid);

        if (currentSurveyOptional.isPresent()) {
            surveyRepository.deleteById(surveyid);
            return ResponseEntity.ok("Survey with the id " + surveyid + " is now deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(method = RequestMethod.OPTIONS, value = "/update/{surveyid}")
    public ResponseEntity<?> options() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.OPTIONS, value = "/delete/{surveyid}")
    public ResponseEntity<?> optionsDelete() {
        return ResponseEntity.ok().build();
    }
}
