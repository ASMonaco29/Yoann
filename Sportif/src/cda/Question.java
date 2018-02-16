package cda;

public class Question {

  private String question;
  private boolean choixDeflt;
  private boolean[] choixRep;

  /** Constructeur de l'objet question.
   * 
   * @param question : chaine de caractere constituant la question
   * @param cd : la réponse par defaut
   */
  public Question(String question, boolean cd) {
    this.question = question;
    this.choixDeflt = cd;
    this.choixRep[0] = true;
    this.choixRep[1] = false;
  }

  public boolean getChoixDeflt() {
    return choixDeflt;
  }

  public void setChoixDeflt(boolean choixDeflt) {
    this.choixDeflt = choixDeflt;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

}