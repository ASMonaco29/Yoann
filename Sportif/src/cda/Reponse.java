package cda;

import java.sql.Date;
import java.util.ArrayList;

public class Reponse {
  private Date date;
  private ArrayList<Boolean> reponses;
  private Questionnaire questionnaire;
  private Sportif sportif;

  public Reponse(Date date) {
    this.date = date;
    reponses = new ArrayList<Boolean>();
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public ArrayList<Boolean> getReponses() {
    return reponses;
  }

  public void setReponses(ArrayList<Boolean> reponses) {
    this.reponses = reponses;
  }
  
  public void affichage() {
    int i=1;
    for(boolean bool : reponses) {
      System.out.println("Reponse "+i+" = "+reponses.get(i));
    }
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public Sportif getSportif() {
    return sportif;
  }

  public void setSportif(Sportif sportif) {
    this.sportif = sportif;
  }
  
  
}
