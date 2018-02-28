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
    
    /* Je CREE un sportif s0 :
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
    
    // Je SUPPRIME s0
    supprimerSportif("Malleno");
    
    
    /******************************** CREATION SPORTIF *********************************/
    
    
    /* Je CREE un sportif s1 :
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
    System.out.println("CREATION - Nom :");
    creerSportif("56588", "Alix", "Alix56", new Date(2000 - 1900,11,07), Sport.Ju_Jitsu);
    
    /* Je CREE un sportif s2 :
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
    System.out.println("CREATION - Prénom :");
    creerSportif("Fabien", "45412", "Fab45", new Date(1990 - 1900,23,11), Sport.Billard);
    
    /* Je CREE un sportif s3 :
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
    System.out.println("CREATION - Pseudo :");
    creerSportif("Holdon", "Kate", "J'espace'les\"noms", new Date(1978 - 1900,15,12), 
        Sport.Patinage_artistique);
    
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
    //System.out.println("CREATION - Mot de passe : ");
    //CreerSportif("Daniel", "Hector", "HDaniel", new Date(01,9,2001), Sport.Billard);
    
    /* Je CREE un sportif s5 :
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
    System.out.println("CREATION - Date de naissance :");
    creerSportif("Vaudou", "Marc", "MVaudou", new Date(2019 -1900,05,8), Sport.Kite_surf);
    
    /* Je CREE un sportif s6 :
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
    //System.out.println("CREATION - Sport :");
    //CreerSportif("Kerinou", "Mathilde", "MKerinou", new Date(1993 -1900,29,04), Sport.Kite_surf);
    
    /* Je CREE un sportif s7 :
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
    System.out.println("CREATION - Nouvel ajout(s7)");
    creerSportif("Alleno", "Malou", "Malleno", new Date(1997 - 1900,03,05), Sport.Basketball);
    
    /* Je CREE un sportif s8 :
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
    System.out.println("CREATION - Nouvel ajout (s8)");
    creerSportif("Mestre", "Quentin", "Qmestre", new Date(1996 - 1900,30,05), Sport.Natation);
    
    /* Je CREE un sportif s9 :
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
    System.out.println("CREATION - Déjà existant : ");
    creerSportif("Alleno", "Malou", "Malleno", new Date(1997 - 1900,03,05), Sport.Basketball);
    
    /* Je CREE un sportif s10 :
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
    System.out.println("CREATION - Déjà existant : ");
    creerSportif("Mestre", "Quentin", "Quentvinght", new Date(1996 - 1900, 30,05), Sport.Golf);
    
    
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
    System.out.println("MODIFICATION - Nom :");
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
    System.out.println("MODIFICATION - Prénom :");
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
    System.out.println("MODIFICATION - Pseudo :");
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
    //System.out.println("MODIFICATION - Mot de passe :");
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
    //System.out.println("MODIFICATION - Date de naissance :");
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
    System.out.println("MODIFICATION - Sport :");
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
    System.out.println("MODIFICATION - Nom + Prenom + Date de naissance :");
    modifierSportif("Mestre", "Quentin", "Malleno", Sport.Basketball);
    
    
    /******************************** SUPPRESSION SPORTIF *********************************/
    
    // Je SUPPRIME s7
    System.out.println("SUPPRESSION - s7 (existant) :");
    supprimerSportif("Malleno");
    
    // Je SUPPRIME un sportif qui n'existe pas (s22)
    System.out.println("SUPPRESSION - Inexistant :");
    supprimerSportif("test_faux_pseudo");
    
    
    
    
    
    
    
    
    /******************************** QUESTIONNAIRE *********************************/
    
    /******************************** TEST 1  *********************************/
    
    System.out.println("QUESTIONNAIRE :");
    
    /* Je CREE un questionnaire q0 :
     * 
     * Titre : Santé
     * Sous-titre : Bien-être
     * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
     * Date début : le jour courant (format : JJ/MM/AAAA)
     * Date fin : 7 jours après (format : JJ/MM/AAAA)
     * 
     * Liste de questions : 
     *  a - Vous êtes-vous entrainé aujourd'hui ? 
     *    choix par défaut : Oui
     *  b - Sentez-vous une progression dans votre entraînement ?
     *    choix par défaut : Non
     * 
     * Problème supposé : AUCUN
     * Comportement obtenu : 
     */
    creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
    
    /* Je MODIFIE un questionnaire q0 :
     * 
     * Titre : Le mal
     * Sous-titre : Portez-vous mieux
     * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous mieux.
     * Date début : le jour courant (format : JJ/MM/AAAA)
     * Date fin : 7 jours après (format : JJ/MM/AAAA)
     * 
     * Liste de questions : 
     *  a - Ne vous êtes vous pas entrainé aujourd'hui ? 
     *    choix par défaut : Non
     *  b - Sentez-vous une régression dans votre entraînement ?
     *    choix par défaut : Oui
     * 
     * Problème supposé : AUCUN
     * Comportement obtenu : 
     */
    modifierQuestionnaire();
    
    // Je SUPPRIME s0
    supprimerQuestionnaire();
    
    
  
  
  /******************************** CREATION QUESTIONNAIRE *******************************/
  
  /* Je CREE un questionnaire q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : AUCUN
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Nouvel ajout(q1) :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q2 :
   * 
   * Titre : Blessure
   * Sous-titre : Fragilité/Solidité
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous mieux.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous-êtes vous blessé récemment ? 
   *    choix par défaut : VIDE
   *  b - Etes-vous régulièrement malade ?
   *    choix par défaut : VIDE
   * 
   * Problème supposé : pas de CHOIX PAR DEFAULT aux questions
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Choix par défaut :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q3 :
   * 
   * Titre : Formation
   * Sous-titre : Goûts
   * Message fin : Merci d'avoir répondu à ce questionnaire. 
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : hier (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Aimez-vous la formation que vous suivez ? 
   *    choix par défaut : Oui
   *  b - Souhaiteriez-vous pouvoir essayer d'autres formations ?
   *    choix par défaut : Oui
   * 
   * Problème supposé : DATE
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Date fin :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q4 :
   * 
   * Titre : Formation
   * Sous-titre : Goûts
   * Message fin : Merci d'avoir répondu à ce questionnaire. 
   * Date début : hier (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Aimez-vous la formation que vous suivez ? 
   *    choix par défaut : Oui
   *  b - Souhaiteriez-vous pouvoir essayer d'autres formations ?
   *    choix par défaut : Oui
   * 
   * Problème supposé : DATE
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Date début :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q5 :
   * 
   * Titre : Pourquoi ?
   * Sous-titre : Vous ne saurez rien.
   * Message fin : Merci de ne pas avoir répondu à ce questionnaire. 
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  VIDE
   * 
   * Problème supposé : PAS DE QUESTIONS
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Pas de questions :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q6 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : DEJA EXISTANT (q1)
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Dejà existant (q1) :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je CREE un questionnaire q7 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Non
   *  c - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   * 
   * Problème supposé : 3 fois la MEME QUESTION
   * Comportement obtenu : 
   */
  System.out.println("CREATION - 3 fois la même question :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE un questionnaire q8 :
   * 
   * Titre : Blessure
   * Sous-titre : Fragilité/Solidité
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous mieux.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous-êtes vous blessé récemment ? 
   *    choix par défaut : Oui
   *  b - Etes-vous régulièrement malade ?
   *    choix par défaut : Non
   * 
   * Problème supposé : AUCUN
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Nouvel ajout (q8) :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  
  
  /***************************** MODIFICATION QUESTIONNAIRE *******************************/
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Non
   *  c - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   * 
   * Problème supposé : 3 fois la MEME QUESTION
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - 3 fois la meme question :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Blessure
   * Sous-titre : Fragilité/Solidité
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous mieux.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous-êtes vous blessé récemment ? 
   *    choix par défaut : Oui
   *  b - Etes-vous régulièrement malade ?
   *    choix par défaut : Non
   * 
   * Problème supposé : DEJA EXISTANT (q8)
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Déjà existant (q8) :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : hier (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : DATE
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Date fin :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 3 jours après la date fixée de base (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : AUCUN - changement de la DATE
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Date fin :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : 2 jours après le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : AUCUN - changement de la DATE
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Date début :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : hier (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : DATE
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Date début :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *    VIDE
   * 
   * Problème supposé : PAS DE QUESTION
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Pas de question :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : VIDE
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : VIDE
   * 
   * Problème supposé : pas de CHOIX PAR DEFAULT aux questions
   * Comportement obtenu : 
   */
  System.out.println("MODIFICATION - Pas de choix par défaut :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE q1 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions :   
   *  a - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   *  b - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   * 
   * Problème supposé : AUCUN - On swap les questions a et b
   * Comportement obtenu : 
   */
  System.out.println("CREATION - Nouvel ajout(q1) :");
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  
  /***************************** SUPPRESSION QUESTIONNAIRE *******************************/
  
  // Je SUPPRIME q1
  System.out.println("SUPPRESSION - q1 (existant) :");
  supprimerSportif("Malleno");
  
  // Je SUPPRIME un questionnaires qui n'existe pas (q22)
  System.out.println("SUPPRESSION - Inexistant :");
  supprimerSportif("test_faux_pseudo");
  
  
  
  
  
  
  
  
  
  /************************************** REPONSES ****************************************/
  
  /******************************** TEST 1  *********************************/
  
  System.out.println("REPONSES :");
  
  /* Je CREE un questionnaire r0 :
   * 
   * Titre : Santé
   * Sous-titre : Bien-être
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous bien.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Vous êtes-vous entrainé aujourd'hui ? 
   *    choix par défaut : Oui
   *  b - Sentez-vous une progression dans votre entraînement ?
   *    choix par défaut : Non
   * 
   * Problème supposé : AUCUN
   * Comportement obtenu : 
   */
  creerQuestionnaire("Titre", "Sous-titre", new Date(02,05,1997), new Date(03,05,1997));
  
  /* Je MODIFIE un questionnaire r0 :
   * 
   * Titre : Le mal
   * Sous-titre : Portez-vous mieux
   * Message fin : Merci d'avoir répondu à ce questionnaire. Portez-vous mieux.
   * Date début : le jour courant (format : JJ/MM/AAAA)
   * Date fin : 7 jours après (format : JJ/MM/AAAA)
   * 
   * Liste de questions : 
   *  a - Ne vous êtes vous pas entrainé aujourd'hui ? 
   *    choix par défaut : Non
   *  b - Sentez-vous une régression dans votre entraînement ?
   *    choix par défaut : Oui
   * 
   * Problème supposé : AUCUN
   * Comportement obtenu : 
   */
  modifierQuestionnaire();
  
  // Je SUPPRIME r0
  supprimerQuestionnaire();
  
  


/******************************** CREATION QUESTIONNAIRE *******************************/
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
}
