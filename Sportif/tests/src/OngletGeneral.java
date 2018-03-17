package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;



public class OngletGeneral extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JTabbedPane tabbedPane;
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 
  private JComponent panelQl; 
  private JComponent panelQg;
  private Border borderL;
  private Border borderG;
 
  
  
  /** Constructeur.
  * Les paramètres correspondent aux informations de la classe appelante : IHM.
  */
  public OngletGeneral(JTabbedPane tabbedPane, JComponent panelQ) {
    this.tabbedPane = tabbedPane;
    this.panelQ = panelQ;
    construire();
  }
      
  
  
  /** Construire.
  * Permet de construire la fenêtre
  */
  public void construire() { 
       
    this.panelQ = new JPanel();
    this.panelQ.setLayout(new BoxLayout(this.panelQ, BoxLayout.PAGE_AXIS));
    this.panelQl = new JPanel();
    this.panelQl.setLayout(new BorderLayout());
    this.panelQl.setMaximumSize(new Dimension(1700, 250));
    this.panelQl.setPreferredSize(new Dimension(this.getWidth(), 250));
    this.panelQg = new JPanel();
   
    // Attributs
    this.borderL = BorderFactory.createTitledBorder("Liste Sportifs");
    this.borderG = BorderFactory.createTitledBorder("Gérer Sportifs");
       
    // Paramètres de l'onglet Questionnaires
    
    tabbedPane.addTab("Général", panelQ);
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);  
    
    // Ajout des attributs au contenu de l'onglet Questionnaires    
    panelQl.setBorder(borderL);
    panelQl.add(new JScrollPane(), BorderLayout.CENTER); 
    
    panelQg.setBorder(borderG);
    
    panelQ.add(panelQl);
    panelQ.add(Box.createRigidArea(new Dimension(0,5)));
    panelQ.add(panelQg);   
    
    
  }
            
  
}