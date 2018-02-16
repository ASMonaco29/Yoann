package src;

import cda.*;

import java.sql.Date;

public class Interface {

  /* *******************************
   * SPORTIF : 
   * Creer 
   * Modifier
   * Supprimer
   */
  
  static ListeSportifs sportifs = new ListeSportifs();
  
  static void creerSportif(String nom, String prenom, String pseudo, Date naissance, Sport sport) {
    int creerStatut;
    
    creerStatut = sportifs.creerSportif(nom, prenom, pseudo, naissance, sport);
    
    if(creerStatut == 1) {
      System.out.println("Le sportif existe déjà \n");
      
    } else if(creerStatut == 2) {
      System.out.println("L'identifiant est déjà utilisé \n");
    
    } else {
      System.out.println("Le sportif est crée \n");
    }
  }
  
  static void modifierSportif(String nom, String prenom, String pseudo, Sport sport) {
    int creerStatut;
    
    creerStatut = sportifs.modifierSportif(nom, prenom, pseudo, sport);
    
    if(creerStatut == 0) {
      System.out.println("Le sportif n'existe pas \n");
      
    } else if(creerStatut == 1) {
      System.out.println("Sportif modifié \n");
    
    } 
  }
  
  static void supprimerSportif(String pseudo) {
    int creerStatut;
    
    creerStatut = sportifs.supprimerSportif(pseudo);
    
    if(creerStatut == 1) {
      System.out.println("Le sportif a été supprimé \n");
      
    } else if(creerStatut == 0) {
      System.out.println("Le sportif n'a pas été supprimé \n");
    
    } 
  }
  
  
  /* *******************************
   * QUESTIONAIRE  :
   * Créer
   * Modifier
   * Supprimer
   * Swapper 2 questions
   */
  
  static ListeQuestionnaires questionnaires = new ListeQuestionnaires();
  
  static void creerQuestionnaire(String titre, String sstitre, Date dateD, Date dateF) {
    questionnaires.addQuestionnaire(titre, sstitre, dateD, dateF);
  }
  
  static void modifierQuestionnaire() {
    
  }
  
  static void supprimerQuestionnaire() {
    
  }
  
  
  /* *******************************
   * REPONSE :
   * Créer 
   * Modifier
   * Supprimer
   */
  
  static void creerReponse() {
    
  }
  
  static void modifierReponse() {
    
  }
  
  static void supprimerReponse() {
    
  }
  
  
  
  /* *******************************
   * MAIN - SCENARIO PRINCIPAL
   */
  
  /** Fonction main.
   * Fonction de test
   * @param args paramètre obligatoire
   */
  @SuppressWarnings("deprecation") 
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
     * Comportement obtenu : 
     */
    creerSportif("Alleno", "Malou", "Malleno", new Date(03,05,1997), Sport.Basketball);
    
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
    modifierSportif("Alleno", "Malou", "Malleno", Sport.Basketball);
    
    // Je supprime s0
    supprimerSportif("Malleno");
    
    
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
     * => Comportement obtenu : Création du sportif : PROBLEMATIQUE mais pas trop
     */
    System.out.println("Nom :");
    creerSportif("56588", "Alix", "Alix56", new Date(11,07,2000), Sport.Ju_Jitsu);
    
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
     * => Comportement obtenu : Création du sportif : PROBLEMATIQUE mais pas trop
     */
    System.out.println("Prénom :");
    creerSportif("Fabien", "45412", "Fab45", new Date(23,11,1990), Sport.Billard);
    
    /* Je créé un sportif s3 :
     * 
     * Nom : Holdon
     * Prénom : Kate
     * Pseudo : J'espace'les"noms
     * Mot de passe : 1q2w3e4r5t
     * Naissance : 15/12/1978
     * Sport : Patinage_artistique
     * 
     * Problème supposé (mais fonctionnel) : le PSEUDO
     * => Comportement obtenu : Création du sportif
     */
    System.out.println("Pseudo :");
    creerSportif("Holdon", "Kate", "J'espace'les\"noms", new Date(15,12,1978), Sport.Patinage_artistique);
    
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
     * =>  PAS TESTABLE !
     */
    //System.out.println("Mot de passe : ");
    //CreerSportif("Daniel", "Hector", "HDaniel", new Date(01,9,2001), Sport.Billard);
    
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
     * => Comportement obtenu : Création du sportif : PROBLEMATIQUE 
     */
    System.out.println("Date de naissance :");
    creerSportif("Vaudou", "Marc", "MVaudou", new Date(05,8,2019), Sport.Kite_surf);
    
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
     * =>  PAS TESTABLE !
     */
    //System.out.println("Sport :");
    //CreerSportif("Kerinou", "Mathilde", "MKerinou", new Date(29,04,1993), Sport.Kite_surf);
    
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
    System.out.println("Nouvel ajout(s7)");
    creerSportif("Alleno", "Malou", "Malleno", new Date(03,05,1997), Sport.Basketball);
    
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
     * => Comportement obtenu : Création du sportif
     */
    System.out.println("Nouvel ajout (s8)");
    creerSportif("Mestre", "Quentin", "Qmestre", new Date(30,05,1996), Sport.Natation);
    
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
     * => Comportement obtenu : Identifiant est déjà utilisé
     */
    System.out.println("Déjà existant : ");
    creerSportif("Alleno", "Malou", "Malleno", new Date(03,05,1997), Sport.Basketball);
    
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
     * => Comportement obtenu : Création du sportif : PROBLEMATIQUE
     */
    System.out.println("Déjà existant : ");
    creerSportif("Mestre", "Quentin", "Quentvinght", new Date(30,05,1996), Sport.Golf);
    
    
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
    System.out.println("Nom :");
    modifierSportif("56588", "Malou", "Malleno", Sport.Basketball);
    
    /* Je MODIFIE le PRENOM de s7 :
     * 
     * Nom : Alleno
     * Prénom : 45412
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     */
    System.out.println("Prénom :");
    modifierSportif("Alleno", "45412", "Malleno", Sport.Basketball);
    
    /* Je MODIFIE le PSEUDO de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : J'espace'les"noms
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     */
    System.out.println("Pseudo :");
    modifierSportif("Alleno", "Malou", "J'espace'les\"noms", Sport.Basketball);
    
    /* Je MODIFIE le MOT DE PASSE de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : m@tD'passe
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     * => PAS TESTABLE
     */
    //System.out.println("Mot de passe :");
    //ModifierSportif("Alleno", "Malou", "Malleno", Sport.Basketball);
    
    /* Je MODIFIE la NAISSANCE de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 05/08/2019
     * Sport : Basketball
     * 
     * => PAS TESTABLE
     */
    //System.out.println("Date de naissance :");
    //ModifierSportif("Alleno", "Malou", "Malleno", Sport.Basketball);
    
    /* Je MODIFIE le SPORT de s7 :
     * 
     * Nom : Alleno
     * Prénom : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Patins à glace
     */
    System.out.println("Sport :");
    modifierSportif("Alleno", "Malou", "Malleno", Sport.Basketball);
    
    /* Je MODIFIE le NOM, PRENOM et DATE DE NAISSANCE de s7 :
     * 
     * Nom : Mestre
     * Prénom : Quentin
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 30/05/1996
     * Sport : Basketball
     */
    System.out.println("Nom + Prenom + Date de naissance :");
    modifierSportif("Mestre", "Quentin", "Malleno", Sport.Basketball);
    
    
    /******************************** SUPPRESSION SPORTIF *********************************/
    
    // Je supprime s7
    System.out.println("s7 (existant) :");
    supprimerSportif("Malleno");
    
    // Je supprime un sportif qui n'existe pas (s22)
    System.out.println("Inexistant :");
    supprimerSportif("test_faux_pseudo");
    
    
    
    
    
    
    
    
    /******************************** QUESTIONNAIRE *********************************/
    
    /******************************** TEST 1  *********************************/
    
    System.out.println("QUESTIONNAIRE :");
    
    /* Je créé un questionnaire q0 :
     * 
     * Titre : Alleno
     * Sous-titre : Malou
     * Pseudo : Malleno
     * Mot de passe : Private29
     * Naissance : 03/05/1997
     * Sport : Basketball
     * 
     * Problème supposé : AUCUN
     * Comportement obtenu : 
     */
    creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
    
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
    modifierQuestionnaire();
    
    // Je supprime s0
    supprimerQuestionnaire();
    
  }

}
