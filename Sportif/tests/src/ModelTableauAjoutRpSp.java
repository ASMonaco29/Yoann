package src;

import cda.ListeQuestionnaires;
import cda.ListeReponses;
import cda.Reponse;
import cda.Sportif;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ModelTableauAjoutRpSp extends AbstractTableModel {
  
  private Reponse reponse;
  private ArrayList<Boolean> listeRep;
  
  @SuppressWarnings("rawtypes")
  Class[] types = new Class[] { 
      String.class, Boolean.class 
  }; 
  
  private final String[] entetes = {"Question", "Réponse"};
  
  public ModelTableauAjoutRpSp(Sportif sp, ListeReponses lp, ListeQuestionnaires lq, int indxLq) {
      super();
      
      listeRep = new ArrayList<Boolean>();
      reponse = new Reponse(new Date() , listeRep, sp, lq.getListQ().get(indxLq));
      
  }

  public int getRowCount() {
      return this.reponse.getQuestionnaire().getquListe().size();
  }

  public int getColumnCount() {
      return this.entetes.length;
  }

  public String getColumnName(int columnIndex) {
      return this.entetes[columnIndex];
  }
  
  public Reponse getListR(){
    return this.reponse;
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return this.reponse.getQuestionnaire().getquListe().get(rowIndex).getQuestion();
        case 1:
            return this.reponse.getQuestionnaire().getquListe().get(rowIndex).getChoixDeflt();
        default:
            return null; // Ne devrait jamais arriver
    }
  }
  
  
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue != null){
        switch(columnIndex){
            case 1:
              this.reponse.getQuestionnaire().getquListe().get(rowIndex).setChoixDeflt((Boolean)aValue);
                break;
        }
      }
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    if(columnIndex == 0){
      return false;
    } else {
      return true;
    }
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Class getColumnClass(int columnIndex) { 
      return types[columnIndex]; 
  } 
  
}
  