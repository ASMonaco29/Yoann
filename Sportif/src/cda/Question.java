package cda;

/*
 * TODOLIST : 
 * Vérifier que chaque question possède au moins une réponse
 * Vérifier que chaque question ait une réponse par défaut
 *
 */

public class Question {

  private String question;
  // Tableau de réponses

  public Question(String question) {
    this.question = question;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

}
