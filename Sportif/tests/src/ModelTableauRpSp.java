package src;

import cda.ListeReponses;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ModelTableauRpSp extends AbstractTableModel {
  
  private final int indx;
  private ListeReponses reponses;
  
  @SuppressWarnings("rawtypes")
  Class[] types = new Class[] { 
      String.class, Boolean.class 
  }; 
  
  private final String[] entetes = {"Question", "Réponse"};
  
  /** Modèle pour le tableau de réponses attribués à 1 sportif.
  * @param lr la liste de réponse
  * @param indx numéro du questionnaire sélectionné par l'utilisateur
  */
  public ModelTableauRpSp(ListeReponses lr, int indx) {
    super();
      
    this.reponses = lr;
    this.indx = indx;
      
  }

  public int getRowCount() {
    return this.reponses.getReponses().get(this.indx).getReponses().size();
  }

  public int getColumnCount() {
    return this.entetes.length;
  }

  public String getColumnName(int columnIndex) {
    return this.entetes[columnIndex];
  }
  
  public ListeReponses getListR() {
    return this.reponses;
  }

  /** Permet la construction du tableau de réponses.
  * Les paramètres correspondent à la colonne / ligne sélectionnées dans le tableau.
  */
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return this.reponses.getReponses().get(this.indx).getQuestionnaire()
            .getquListe().get(rowIndex);
      case 1:
        return this.reponses.getReponses().get(this.indx).getReponses().get(rowIndex);
      default:
        return null; // Ne devrait jamais arriver
    }
  }
  
  
  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    if (value != null) {
      switch (columnIndex) {
        case 1:
          this.reponses.getReponses().get(this.indx).getReponses().set(rowIndex, (Boolean)value);
          break;
        default:
          break;
      }
    }
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    if (columnIndex == 0) {
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
  