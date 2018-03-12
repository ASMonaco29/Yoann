package cda;

import java.sql.Date;

public class Reponse {
  private Date date;
  private Boolean reponses;

  public Reponse(Date date, Boolean bln) {
    this.date = date;
    this.reponses = bln;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Boolean getReponses() {
    return reponses;
  }

  public void setReponses(Boolean reponses) {
    this.reponses = reponses;
  }
  /*
  public void affichage() {
    int i=1;
    for(boolean bool : reponses) {
      System.out.println("Reponse "+i+" = "+reponses.get(i));
    }
  }
  */
}
