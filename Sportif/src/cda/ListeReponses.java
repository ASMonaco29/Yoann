package cda;

import java.util.ArrayList;

public class ListeReponses {
  private Sportif sportif = new Sportif();
  private Questionnaire questionnaire = new Questionnaire(null, null);
  private ArrayList<Reponse> reponses;
  
  public ListeReponses() {
    super();
    this.reponses = new ArrayList<Reponse>();
  }

  public void addListeReponses(Reponse reponse) {
    this.reponses.add(reponse);
  }
  
  public void removeListeReponses(Reponse reponse) {
    this.reponses.remove(reponse);
  }
  
  public Sportif getSportif() {
    return sportif;
  }

  public void setSportif(Sportif sportif) {
    this.sportif = sportif;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public ArrayList<Reponse> getReponses() {
    return reponses;
  }

  public void setReponses(ArrayList<Reponse> reponses) {
    this.reponses = reponses;
  }
  
}
