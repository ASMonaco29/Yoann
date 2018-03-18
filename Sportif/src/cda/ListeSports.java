package cda;

import java.util.ArrayList;

public class ListeSports {
  
  private ArrayList<String> sports;
  
  public ListeSports() {
    super();
    sports = new ArrayList<String>();
  }

  public ArrayList<String> getListSports() {
    return this.sports;
  }

  public void setListSports(ArrayList<String> sports) {
    this.sports = sports;
  }
  
  /** Méthode qui permet d'ajouter un sport dans la liste de sports.
   * 
   * @param sp Le sportif qui sera ajouter en fin de liste.
   */
  public void addSport(String sp) {
    boolean tst = false;
    
    for (int i = 0; i < this.sports.size(); i++) {
      if (this.sports.get(i) == sp) {
        tst = true;
      }
    }
    if (tst == false) {
      this.sports.add(sp);
    } else {
      System.out.println("sport déjà existant !!");
    }
  }
  
  /** Méthode qui permet de supprimer un sport dans la liste de sports.
   * 
   * @param indx Le sport à cet index sera supprimé
   */
  public void removeSport(int indx) {
    if (indx <= this.sports.size()) {
      this.sports.remove(indx);
    } else {
      System.out.println("indx au dela de la taille de la liste !");
    }
  }
  
  /** Méthode qui permet de modifier un sport dans la liste de sports.
   * 
   * @param sp Le nouveau sport 
   * @param indx L'index du sport à modifier
   */
  public void updateSport(String sp, int indx) {
    if (indx <= this.sports.size()) {
      this.sports.set(indx, sp);
    } else {
      System.out.println("indx au dela de la taille de la liste !");
    }
  }

}
