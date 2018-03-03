package src;

import cda.ListeQuestionnaires;
import cda.Question;
import cda.Questionnaire;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.swing.table.AbstractTableModel;

/* 
 * A FAIRE : AJOUTER LA CASE "QUESTION(S)" AU TABLEAU !!
 */

@SuppressWarnings("serial")
public class ModelTableauQ extends AbstractTableModel {
  
  //private final List<Questionnaire> questionnaire = new ArrayList<Questionnaire>();
  private final ListeQuestionnaires questionnaires = new ListeQuestionnaires();

  private final String[] entetes = {"Titre", "Sous-titre", "Date debut", "Date fin", 
      "Message fin", "Question(s)"};
  
  private ArrayList<Question> questions = new ArrayList<Question>();

  private Calendar cal;
  private Date dated1;
  private Date dated2;  
  private Date datef1;
  private Date datef2;
  
  public ModelTableauQ() {
      super();
      
      this.cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 02);
      cal.set(Calendar.DAY_OF_MONTH, 28);
      dated1 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 03);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      dated2 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 03);
      cal.set(Calendar.DAY_OF_MONTH, 28);
      datef1 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 04);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      datef2 = cal.getTime();
          
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
            "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répond à ce questionnaire.", questions);
          
      
  }

  public int getRowCount() {
      return this.questionnaires.getSizeListQ();
  }

  public int getColumnCount() {
      return this.entetes.length;
  }

  public String getColumnName(int columnIndex) {
      return this.entetes[columnIndex];
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return this.questionnaires.getListQ().get(rowIndex).getTitre();
        case 1:
            return this.questionnaires.getListQ().get(rowIndex).getSstitre();
        case 2:
            return this.questionnaires.getListQ().get(rowIndex).getDateD();
        case 3:
            return this.questionnaires.getListQ().get(rowIndex).getDateF();
        case 4:
            return this.questionnaires.getListQ().get(rowIndex).getMessageFin();
        default:
            return null; // Ne devrait jamais arriver
    }
  }
    
  public void addQuestionnaire(Questionnaire quest) {
    this.questionnaires.addQuestionnaire(quest.getTitre(), quest.getSstitre(), quest.getDateD(), 
        quest.getDateF(), quest.getMessageFin(), quest.getquListe());

    fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
  }
  
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true; //Toutes les cellules éditables
  }
  
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue != null){
          Questionnaire quest = this.questionnaires.getListQ().get(rowIndex);
   
          switch(columnIndex){
              case 0:
                quest.setTitre((String)aValue);
                  break;
              case 1:
                quest.setSstitre((String)aValue);
                  break;
              case 2:
                quest.setDateD((Date)aValue);
                  break;
              case 3:
                quest.setDateF((Date)aValue);
                  break;
              case 4:
                quest.setMessageFin((String)aValue);
                  break;
          }
      }
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public Class getColumnClass(int columnIndex){
      switch(columnIndex){
          case 2:
              return Date.class;
          case 3:
              return Date.class;
          default:
              return Object.class;
      }
  }


}
