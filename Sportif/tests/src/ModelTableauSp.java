package src;

import cda.ListeQuestionnaires;
import cda.ListeSportifs;
import cda.Question;
import cda.Sport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ModelTableauSp extends AbstractTableModel {
  
  private final ListeSportifs sportifs;
  private ListeQuestionnaires questionnaires;

  private final String[] entetes = {"Pseudo", "Nom", "Prénom", "Date de naissance", 
      "Sport", "Questionnaire(s) répondu(s)"};
  
  @SuppressWarnings("rawtypes")
  private ArrayList<DefaultListModel> modl;
  private ArrayList<Question> questions;
  private ArrayList<Question> questions1;

  private Calendar cal;
  private Date date1;
  private Date date2;  
  private Date date3;
  private Date date4;
  
  @SuppressWarnings("rawtypes")
  public ModelTableauSp() {
      super();
      
      this.sportifs = new ListeSportifs();
      this.questionnaires = new ListeQuestionnaires();
      this.modl = new ArrayList<DefaultListModel>();
      
      this.questions = new ArrayList<Question>();
      this.questions1 = new ArrayList<Question>();
      
      questions.add(new Question("Bien ?", false));
      questions.add(new Question("Reveillé ?", true));
      questions.add(new Question("Debout ?", true));
      questions1.add(new Question("Good ?", false));
      questions1.add(new Question("Awake ?", true));
      questions1.add(new Question("Wake up ?", true));
      
      this.cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, 1996);
      cal.set(Calendar.MONTH, 4);
      cal.set(Calendar.DAY_OF_MONTH, 06);
      date1 = cal.getTime();
      
      cal.set(Calendar.YEAR, 1997);
      cal.set(Calendar.MONTH, 3);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      date2 = cal.getTime();
      
      cal.set(Calendar.YEAR, 1998);
      cal.set(Calendar.MONTH, 3);
      cal.set(Calendar.DAY_OF_MONTH, 28);
      date3 = cal.getTime();
      
      cal.set(Calendar.YEAR, 1995);
      cal.set(Calendar.MONTH, 4);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      date4 = cal.getTime();
      
      questionnaires.addQuestionnaire("Bien-être", "Soin", date1, date2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions1);
          
      sportifs.creerSportif("Alleno", "Malou", "Malou22", date2, Sport.Basketball);
      sportifs.creerSportif("LeMestre", "Quentin", "QuentinIle", date4, Sport.Billard);
      sportifs.creerSportif("LePape", "Rémi", "Rems56", date3, Sport.Golf);
      sportifs.creerSportif("Amicel", "Yoann", "Yoyo22", date1, Sport.Football);
      
      sportifs.getListeS().get(0).ajouterListQ(questionnaires.getListQ());
      sportifs.getListeS().get(1).ajouterListQ(questionnaires.getListQ());
      sportifs.getListeS().get(2).ajouterListQ(questionnaires.getListQ());
      sportifs.getListeS().get(3).ajouterListQ(questionnaires.getListQ());
      
      
      // Présentation sous forme de liste des questions de chaque questionnaire
      actualiserListeQuestionnaires();
  }

  public int getRowCount() {
      return this.sportifs.getSizeListS();
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
            return this.sportifs.getListeS().get(rowIndex).getPseudo();
        case 1:
            return this.sportifs.getListeS().get(rowIndex).getNom();
        case 2:
            return this.sportifs.getListeS().get(rowIndex).getPrenom();
        case 3:
            return this.sportifs.getListeS().get(rowIndex).getNaissance();
        case 4:
            return this.sportifs.getListeS().get(rowIndex).getSport();
        case 5:
            return this.modl.get(rowIndex);
        default:
            return null; // Ne devrait jamais arriver
    }
  }
    
  public void creerSportif(String nom, String prenom, String pseudo, Date date, Sport sport) {
    this.sportifs.creerSportif(nom, prenom, pseudo, date, sport);
    actualiserListeQuestionnaires();
    
    
    fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
  }
  
  public void supprimerSportif(int rowIndex) {
    this.sportifs.supprimerSportif(this.sportifs.getListeS().get(rowIndex).getPseudo());
    this.modl.remove(rowIndex);
    
    fireTableRowsDeleted(rowIndex, rowIndex);
  }
  
  public void modifQuestionnaire(String nom, String prenom, String pseudo, Date date, Sport sport, int indx){
    this.sportifs.modifierSportif(nom, prenom, pseudo, date, sport);
    
    fireTableRowsUpdated(indx, indx);
  }
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public Class getColumnClass(int columnIndex){
    switch(columnIndex){
        case 3:
            return Date.class;
        case 4:
          return Sport.class;
        default:
            return Object.class;
    }
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void actualiserListeQuestionnaires(){
    this.modl.clear();
    for(int i = 0; i < getRowCount(); i++){
      if(sportifs.getListeS().get(i).getquListe() != null){
        DefaultListModel dlm = new DefaultListModel();
        for(int j = 0; j < sportifs.getListeS().get(i).getquListe().size(); j++){
          dlm.addElement(sportifs.getListeS().get(i).getquListe().get(j));
        }
        this.modl.add(dlm);
      } else {
        DefaultListModel dlm = new DefaultListModel();
        this.modl.add(dlm);
      }
    }
  }
  
  
}
  