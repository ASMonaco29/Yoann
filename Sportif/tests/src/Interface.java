package src;



public class Interface {

  /* *******************************
   * SPORTIF : 
   * Creer 
   * Modifier
   * Supprimer
   */
  
  static public void CreerSportif(){
    
  }
  
  static public void ModifierSportif(){
    
  }
  
  static public void SupprimerSportif(){
    
  }
  
  
  /* *******************************
   * QUESTIONAIRE  :
   * Créer
   * Modifier
   * Supprimer
   */
  
  static public void CreerQuestionnaire(){
    
  }
  
  static public void ModifierQuestionnaire(){
    
  }
  
  static public void SupprimerQuestionnaire(){
    
  }
  
  
  /* *******************************
   * REPONSE :
   * Créer 
   * Modifier
   * Supprimer
   */
  
  public void CreerReponse(){
    
  }
  
  public void ModifierReponse(){
    
  }
  
  public void SupprimerReponse(){
    
  }
  
  
  
  /* *******************************
   * MAIN - SCENARIO PRINCIPAL
   */
  public static void main(String[] args) {
    
    System.out.println("SPORTIF :");
    
    /*********************************** TEST 1 *********************************/
    
    /* Je créé un sportif s0 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     * Problème supposé : AUCUN
     */
    CreerSportif();
    
    /* Je MODIFIE s0 :
     * 
     * Nom : Mestre
     * Prénom : Quentin
     * Pseudo : Qmestre
     * Mot de passe : MotDePasse974
     * Naissance : 30/05/1996
     * Sport : Natation
     * 
     * Problème supposé : AUCUN
     */
    ModifierSportif();
    
    // Je supprime s0
    SupprimerSportif();
    
    
    /******************************** CREATION SPORTIF *********************************/
    
    
    /* Je créé un sportif s1 :
     * 
     * Nom : 56588
     * Prénom : Alix
     * Pseudo : Alix56
     * Mot de passe : Crypt520
     * Naissance : 11/07/2000
     * Sport : Ju_Jitsu
     * 
     * Problème supposé : le NOM
     */
    CreerSportif();
    
    /* Je créé un sportif s2 :
     * 
     * Nom : Fabien
     * Prénom : 45412
     * Pseudo : Fab45
     * Mot de passe : 18atcskd2w
     * Naissance : 23/11/1990
     * Sport : Billard
     * 
     * Problème supposé : le PRENOM
     */
    CreerSportif();
    
    /* Je créé un sportif s3 :
     * 
     * Nom : Holdon
     * Prénom : Kate
     * Pseudo : J'espace'les"noms
     * Mot de passe : 1q2w3e4r5t
     * Naissance : 15/12/1978
     * Sport : Patinage_artistique
     * 
     * Problème supposé : le PSEUDO
     */
    CreerSportif();
    
    /* Je créé un sportif s4 :
     * 
     * Nom : Daniel
     * Prénom : Hector
     * Pseudo : HDaniel
     * Mot de passe : m@tD'passe
     * Naissance : 01/09/2001
     * Sport : Billard
     * 
     * Problème supposé : le MOT DE PASSE
     */
    CreerSportif();
    
    /* Je créé un sportif s5 :
     * 
     * Nom : Vaudou
     * Prénom : Marc
     * Pseudo : MVaudou
     * Mot de passe : password
     * Naissance : 05/08/2019
     * Sport : Kite_surf
     * 
     * Problème supposé : la DATE DE NAISSANCE
     */
    CreerSportif();
    
    /* Je créé un sportif s6 :
     * 
     * Nom : Kerinou
     * Prénom : Mathilde
     * Pseudo : MKerinou
     * Mot de passe : 3rjs1la7qe
     * Naissance : 29/04/1993
     * Sport : Patins à glace
     * 
     * Problème supposé : le SPORT
     */
    CreerSportif();
    
    /* Je créé un sportif s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     * Problème supposé : AUCUN
     */
    CreerSportif();
    
    /* Je créé un sportif s8 :
     * 
     * Nom : Mestre
     * Prénom : Quentin
     * Pseudo : Qmestre
     * Mot de passe : MotDePasse974
     * Naissance : 30/05/1996
     * Sport : Natation
     * 
     * Problème supposé : AUCUN
     */
    CreerSportif();
    
    /* Je créé un sportif s9 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     * Problème supposé : sportif DEJA EXISTANT
     */
    CreerSportif();
    
    /* Je créé un sportif s10 :
     * 
     * Nom : Mestre
     * Prénom : Quentin
     * Pseudo : Quentvinght
     * Mot de passe : MotDepasse33
     * Naissance : 30/05/1996
     * Sport : Golf
     * 
     * Problème supposé : sportif DEJA EXISTANT
     */
    CreerSportif();
    
    
    /******************************** MODIFICATION SPORTIF *********************************/
    
    
    /* Je MODIFIE le NOM de s7 :
     * 
     * Nom : 56588
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     */
    ModifierSportif();
    
    /* Je MODIFIE le PRENOM de s7 :
     * 
     * Nom : Alleno
     * Prénom : 45412
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     */
    ModifierSportif();
    
    /* Je MODIFIE le PSEUDO de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : J'espace'les"noms
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     */
    ModifierSportif();
    
    /* Je MODIFIE le MOT DE PASSE de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : m@tD'passe
     * Naissance : 03/05/1997
     * Sport : Basketball
     */
    ModifierSportif();
    
    /* Je MODIFIE la NAISSANCE de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 05/08/2019
     * Sport : Basketball
     */
    ModifierSportif();
    
    /* Je MODIFIE le SPORT de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Patins à glace
     */
    ModifierSportif();
    
    /* Je MODIFIE le NOM et PRENOM de s7 :
     * 
     * Nom : Mestre
     * Prénom : Quentin
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 30/05/1996
     * Sport : Basketball
     */
    ModifierSportif();
    
    
    /******************************** SUPPRESSION SPORTIF *********************************/
    
    // Je supprime s7
    SupprimerSportif();
    
    // Je supprime un sportif qui n'existe pas (s22)
    SupprimerSportif();
    
    
    
    /******************************** QUESTIONNAIRE *********************************/
    
    /******************************** TEST 1  *********************************/
    
    System.out.println("QUESTIONNAIRE :");
    
    
  }

}
