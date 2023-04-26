package com.springboot.web.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class suerveyResource {

  private Surveyservice surveyservice;

  public suerveyResource(Surveyservice surveyservice) {
    this.surveyservice = surveyservice;
  }

  @RequestMapping("/surveys")
  public List<Surveys> retrieveAllSurveys() {
    return surveyservice.retrieveAllSurveys();
  }
  @RequestMapping("/surveys/{surveyId}")
  public Surveys retrieveSurveysById(@PathVariable  String surveyId){
    Surveys survey = surveyservice.retrieveSurveysById(surveyId);
     if(survey==null)
       throw new ResponseStatusException(HttpStatus.NOT_FOUND);
     return survey;

  }  
}
