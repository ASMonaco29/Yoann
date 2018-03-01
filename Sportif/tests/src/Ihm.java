package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Ihm extends JFrame {
  
  private static final long serialVersionUID = 1L;
 
  // ONGLET GENERAL
 
  // ONGLET QUESTIONNAIRES
  
  // ONGLET SPORTIFS
  
  // Bouton QUITTER
  private JButton quitter;
  private JPanel panelQuitter;
  private JPanel panelQuitter1;
 
  /** Constructeur.
  * @param nom Contient le nom de la fenêtre
  */
  public Ihm(String nom) {
               
    this.setSize(720, 480); // Taille de la fenêtre
    this.setTitle(nom); // Titre
    this.setLocationRelativeTo(null); // Position par rapport au centre de l'écran
    this.setResizable(false); // On ne peut pas toucher à la taille de la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Lorsqu'on ferme la fenêtre, 
                                                          le programme se ferme "proprement" */ 
    this.setLayout(new BorderLayout()); // On choisit un BorderLayout pour la fenêtre principale
    
    construire();
  }
      
  /** Construire.
  * Permet de construire la fenêtre
  */
  public void construire() {
   
    JTabbedPane tabbedPane = new JTabbedPane();  
   
    // ONGLET GENERAL
    JComponent panelG = new JPanel();
   
    // Attributs
   
    // Paramètres de l'onglet Général
    panelG.setLayout(null);
    tabbedPane.addTab("Général", panelG);
    panelG.setPreferredSize(new Dimension(720, 480));
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
   
    // Ajout des attributs au contenu de l'onglet Général 

       

    // ONGLET QUESTIONNAIRES
    JComponent panelQ = new JPanel();
   
    // Attributs
       
    // Paramètres de l'onglet Questionnaires
    panelQ.setLayout(null);
    tabbedPane.addTab("Questionnaires", panelQ);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);  
    
    // Ajout des attributs au contenu de l'onglet Questionnaires 
   
    
    
    // ONGLET SPORTIFS
    JComponent panelS = new JPanel();
   
    // Attributs
   
    // Paramètres de l'onglet Général
    panelS.setLayout(null);
    tabbedPane.addTab("Sportifs", panelS);
    panelS.setPreferredSize(new Dimension(720, 480));
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
   
    // Ajout des attributs au contenu de l'onglet Général
    
    
    // Ajoute les (panels) onglets au panel général -> permet l'affichage.
    this.add(tabbedPane, BorderLayout.CENTER); 
    
    // Le bouton pour QUITTER
    this.panelQuitter = new JPanel(new BorderLayout());
    this.panelQuitter1 = new JPanel();
    this.quitter = new JButton("Quitter");
    
    this.panelQuitter.add(this.panelQuitter1, BorderLayout.EAST); 
    this.panelQuitter1.add(this.quitter);
    this.add(panelQuitter, BorderLayout.SOUTH);
    
  }



  public static void main(String[] args) {
    Ihm ihm = new Ihm("Application Sportif");
    ihm.setVisible(true);
  }

}
