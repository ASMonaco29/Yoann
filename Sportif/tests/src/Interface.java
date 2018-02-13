package src;

import java.util.Scanner;

import cda.Question;
import cda.Questionnaire;

public class Interface {

  public static void main(String[] args) {
    
    int choix;
    int rep;
    String rep1;
    
    Questionnaire questionnaire1 = new Questionnaire(null, null);
    Questionnaire questionnaire2 = new Questionnaire(null, null);
    Questionnaire questionnaire3 = new Questionnaire(null, null);
    Questionnaire questionnaire4 = new Questionnaire(null, null);
    
    
    
    System.out.println("Etes-vous un :");
    System.out.println("1 - Sportif");
    System.out.println("2 - Administrateur");
    
    Scanner sc = new Scanner(System.in);
    choix = sc.nextInt();
    sc.close();
    
    
    switch(choix) { 
    case 1: 
      System.out.println("1 - Retour");
      System.out.println("2 - Questionnaire " + questionnaire1.getTitre());
      System.out.println("3 - Questionnaire " + questionnaire2.getTitre());
      System.out.println("4 - Questionnaire " + questionnaire3.getTitre());
      System.out.println("5 - Questionnaire " + questionnaire4.getTitre());
      
      Scanner sc1 = new Scanner(System.in);
      choix = sc1.nextInt();
      sc1.close();
      
      switch(choix){
      
      case 1: 
        break;
      /* A REPRENDRE AVEC LA CLASSE REPONSE !!! */
      case 2: 
        for(Question q : questionnaire1.getquListe()){
          System.out.println(q.getQuestion());
          
          Scanner sc2 = new Scanner(System.in);
          rep1 = sc2.next();
          sc2.close();
          
          if(!rep1.equals("") || !rep1.equals("")){
            
          }
        }
        

        
        
        
        break;
      }
      
    break; 
    
    case 2: 
      System.out.println("1 - ");
      System.out.println("5 - ");
      break;  
    
    }

  }

}
