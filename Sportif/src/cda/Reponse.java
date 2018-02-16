package cda;


import java.sql.Date;
import java.util.ArrayList;

public class Reponse {
  private Date date;
  private ArrayList<Boolean> reponses;

  public Reponse(Date date) {
    this.date = date;
    this.reponses = new ArrayList<Boolean>();
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
  
}
