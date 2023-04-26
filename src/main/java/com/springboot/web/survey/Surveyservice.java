package com.springboot.web.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class Surveyservice {
  private static List<Surveys> surveys = new ArrayList<>();

  static {
    Questions question1 = new Questions("Question1",
        "Most Popular Cloud Platform Today", Arrays.asList(
            "AWS", "Azure", "Google Cloud", "Oracle Cloud"),
        "AWS");
    Questions question2 = new Questions("Question2",
        "Fastest Growing Cloud Platform", Arrays.asList(
            "AWS", "Azure", "Google Cloud", "Oracle Cloud"),
        "Google Cloud");
    Questions question3 = new Questions("Question3",
        "Most Popular DevOps Tool", Arrays.asList(
            "Kubernetes", "Docker", "Terraform", "Azure DevOps"),
        "Kubernetes");

    List<Questions> questions = new ArrayList<>(Arrays.asList(question1,
        question2, question3));

    Surveys survey = new Surveys("Survey1", "My Favorite Survey",
        "Description of the Survey", questions);

    surveys.add(survey);

  }

  public List<Surveys> retrieveAllSurveys() {
    return surveys;
  }

public Surveys retrieveSurveysById(String surveyId) {
    Predicate<? super Surveys> predicate = survey -> survey.getId().equals(surveyId);
    Optional<Surveys> OptionalSurvey = surveys.stream().filter(predicate).findFirst();
    if (OptionalSurvey.isEmpty())
        return null;
    return OptionalSurvey.get();
}
}