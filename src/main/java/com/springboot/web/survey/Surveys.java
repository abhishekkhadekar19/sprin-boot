package com.springboot.web.survey;

import java.util.List;

public class Surveys {
  
  private String id;
  private String title;
  private String description;
  private List<Questions> questions;
  
  public Surveys() {
    super();
  }
  public Surveys(String id, String title, String description, List<Questions> questions) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.questions = questions;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public List<Questions> getQuestions() {
    return questions;
  }
  public void setQuestions(List<Questions> questions) {
    this.questions = questions;
  }
  @Override
  public String toString() {
    return "Surveys [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions + "]";
  }
}
