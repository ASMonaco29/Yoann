package src;

import cda.Question;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ModelTableauQn extends AbstractTableModel {

  private final String[] entetes = {"Ajouter au questionnaire ?", "Intitulé de la question", 
      "Réponse par défaut (vrai/faux)"};
  
  @SuppressWarnings("rawtypes")
  Class[] types = new Class[] { 
      Boolean.class, String.class, Boolean.class 
  }; 
  
  private ArrayList<Question> questions;
  private ArrayList<Boolean> ajout;

  /** Modèle pour le tableau de questions.
  * 
  */
  public ModelTableauQn() {
    super();
      
    this.questions = new ArrayList<Question>();
    this.ajout = new ArrayList<Boolean>();
    
    questions.add(new Question("Bien ?", false));
    questions.add(new Question("Reveillé ?", true));
    questions.add(new Question("Debout ?", true));
    questions.add(new Question("Good ?", false));
    questions.add(new Question("Awake ?", true));
    questions.add(new Question("Wake up ?", true));          
    
    for (int i = 0; i < getRowCount(); i++) {
      ajout.add(false);
    }

  }

  public int getRowCount() {
    return this.questions.size();
  }

  public int getColumnCount() {
    return this.entetes.length;
  }

  public String getColumnName(int columnIndex) {
    return this.entetes[columnIndex];
  }

  /** Permet la construction du tableau de questions.
  * Les paramètres correspondent à la colonne / ligne sélectionnées dans le tableau.
  */
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return this.ajout.get(rowIndex);
      case 1:
        return this.questions.get(rowIndex).getQuestion();
      case 2:
        return this.questions.get(rowIndex).getChoixDeflt();
      default:
        return null; // Ne devrait jamais arriver
    }
  }
  

  /** Permet d'ajouter une question dans la liste.
  * @param quest question ajoutée dans la liste
  */
  public void addQuestion(Question quest) {
    this.questions.add(quest);
    this.ajout.add(false);
    
    fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
  }
  
  /** Permet de supprimer une question dans la liste.
  * @param rowIndex index de la question à supprimer dans la liste
  */
  public void removeQuestion(int rowIndex) {
    this.questions.remove(rowIndex);

    fireTableRowsDeleted(rowIndex, rowIndex);
  }
  
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    if (columnIndex == 1) {
      return false;
    } else {
      return true;
    }
  }
  
  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    if (value != null) {
      switch (columnIndex) {
        case 0:
          this.ajout.set(rowIndex, (Boolean)value);
          break;
        case 2:
          questions.get(rowIndex).setChoixDeflt((Boolean)value);
          break;
        default:
          break;
      }
    }
  }
  

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Class getColumnClass(int columnIndex) { 
    return types[columnIndex]; 
  } 
  
  
}
