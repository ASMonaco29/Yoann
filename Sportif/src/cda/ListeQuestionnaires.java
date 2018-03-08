package cda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ListeQuestionnaires {
  
  private ArrayList<Questionnaire> listQ;

  public ListeQuestionnaires() {
    super();
    listQ = new ArrayList<Questionnaire>();
  }

  public ArrayList<Questionnaire> getListQ() {
    return listQ;
  }

  public void setListQ(ArrayList<Questionnaire> listQ) {
    this.listQ = listQ;
  }
  
  public int getSizeListQ(){
    return this.listQ.size();
  }
  
  
  /**Ajoute/Crée un questionnaire.
   * 
   * @param titre : titre du question.
   * @param sstitre : sous titre du question.
   * @param dateD : date de début du questionnaire.
   * @param dateF : date de fin du questionnaire.
   * @return 
   */
  public int addQuestionnaire(String titre, String sstitre,
      Date dateD, Date dateF, String msgFin, ArrayList<Question> quliste) {
    Questionnaire quest = new Questionnaire(dateD, dateF);
    quest.setTitre(titre);
    quest.setSstitre(sstitre);
    quest.setMessageFin(msgFin);
    
    for (int i = 0; i < quliste.size(); i++) {
      quest.addQuestion(quliste.get(i));
    }
    listQ.add(quest);
    return 0;
  }
  
  public Object addQuestionnaire(String titre, String sstitre, Date dateD, Date dateF) {
    return addQuestionnaire(titre, sstitre, dateD, dateF, null, null);
  }
  
  
  /**Modifie un Questionnaire.
   * 
   * @param quest : questionnaire à modifier
   */
  @SuppressWarnings("resource")
  public void modifQuestionnaire(Questionnaire quest) {
    int statut = testModifQuestionnaire(quest);
    Scanner sc = new Scanner(System.in);
    int choix;
    
    switch (statut) {
      case -2:
        System.out.println("Le questionnaire peut être modifié");
        break;
      case -1:
        System.out.println("Le questionnaire ne peut être modifié, il est ouvert.");
        break;
      case 0:
        System.out.println("Le questionnaire est fermé, il peut être modifié.");
        System.out.println("Que voulez-vous modifier?");
        System.out.println("\t1. Les dates");
        choix = sc.nextInt();
        if (choix == 1) {
          modifDates(quest);
        }
        break;

      default:
        break;
    }
  }
  
  
  /** Test si on peu modifier un questionnaire par rapport a la date courante
   * et à ses dates de début et de fin.
   * 
   * @param quest : le questionnaire a modifier
   * @return : -2 questionnaire non commencé , -1 questionnaire commencé, 0 questionnaire est fermé.
   */
  public int testModifQuestionnaire(Questionnaire quest) {
    Date d = quest.getDateD();
    Date f = quest.getDateF();
    Date currD = new Date();
    if (d.after(currD)) {
      return -2;
    }
    if (d.after(currD) && f.before(currD)) {
      return -1;
    }
    return 0;
  }
  
  
  /** Modifie les dates du questionnaire.
   * 
   * @param quest : questionnaire dont les dates vont être modifiées
   */
  @SuppressWarnings({ "deprecation", "resource" })
  public void modifDates(Questionnaire quest) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Saisissez l'année de début du questionnaire :  ");
    int ad = sc.nextInt();
    System.out.println("Saisissez le mois de début du questionnaire :  ");
    int md = sc.nextInt();  
    System.out.println("Saisissez le jour de début du questionnaire :  ");
    int jd = sc.nextInt();  
    System.out.println("Saisissez l'année de fin du questionnaire :  ");
    int af = sc.nextInt();
    System.out.println("Saisissez le mois de fin du questionnaire :  ");
    int mf = sc.nextInt();
    System.out.println("Saisissez le jour de fin du questionnaire :  ");
    int jf = sc.nextInt();  
    Date d = new Date(ad - 1900, md, jd);
    Date f = new Date(af - 1900, mf, jf);
    
    if (!d.before(f)) {
      System.out.println("Erreur, la date de fin est inférieur à la date de début.");
      modifDates(quest);
      return;
    }
    
    quest.setDateD(d);
    quest.setDateF(f);
    return;
  }
  
  
  /** Supprime un questionnaire de la liste.
   * 
   * @param q : le questionnaire à supprimer.
   * @return -1 si l'argument n'est pas valide, le questionnaire n'est pas modifiable
   *         ou bien si la suppression ne s'est pas bien passée. Sinon renvoie 0.
   */
  public int supprQuestionnaire(Questionnaire q) {
    if (q == null || testModifQuestionnaire(q) == -1) {
      return -1;
    }
    if (!this.listQ.remove(q)) {
      return -1;
    }
    return 0;
  }
  
  

}