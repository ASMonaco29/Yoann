package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField.AbstractFormatter;



public class Ihm extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  
  private JTabbedPane tabbedPane;
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 

  
  // ONGLET SPORTIFS
  private JComponent panelS; 
  
  
  // Bouton QUITTER
  private JButton quitter;
  private JPanel panelQuitter;
  private JPanel panelQuitter1;
 
  
  
  /** Constructeur.
  * @param nom Contient le nom de la fenêtre
  */
  public Ihm(String nom) {
    ImageIcon img = new ImageIcon("logo-sportif.jpg");
    this.setIconImage(img.getImage());
    this.setSize(670, 540); // Taille de la fenêtre
    this.setTitle(nom); // Titre
    this.setLocationRelativeTo(null); // Position par rapport au centre de l'écran
    this.setResizable(true); // On ne peut pas toucher à la taille de la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Lorsqu'on ferme la fenêtre, 
                                                          le programme se ferme "proprement" */ 
    this.setLayout(new BorderLayout()); // On choisit un BorderLayout pour la fenêtre principale
    this.setMinimumSize(new Dimension(670, 540));
    
    construire();
  }
      
  
  
  /** Construire.
  * Permet de construire la fenêtre
  */
  public void construire() {
   
    tabbedPane = new JTabbedPane();
    
    // Création de l'onglet Questionnaires
    new OngletQuestionnaire(tabbedPane, panelQ);
    
    // Création de l'onglet Sportif
    new OngletSportif(tabbedPane, panelS);    
    
    // Ajoute les (panels) onglets à la fenêtre principale
    this.add(tabbedPane, BorderLayout.CENTER); 
    
    
    // Le bouton pour QUITTER
    this.panelQuitter = new JPanel(new BorderLayout());
    this.panelQuitter1 = new JPanel();
    this.quitter = new JButton("Quitter");
    this.quitter.addActionListener(this);
    
    this.panelQuitter.add(this.panelQuitter1, BorderLayout.EAST); 
    this.panelQuitter1.add(this.quitter);
    this.add(panelQuitter, BorderLayout.SOUTH);
    
  }
  
  
  
  
  /*
   * Action réalisé sur clic : quitter
   */
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    /**************************** QUITTER ********************************/
    if(source == this.quitter){
      this.setVisible(false);
      this.dispose();
    }
        
  }
  

  
  public static void main(String[] args) {
    Ihm ihm = new Ihm("Application Sportif");
    ihm.setVisible(true);
    
  }
  
}


/************************ FONCTIONS POUR LE CALENDRIER *************************/
@SuppressWarnings("serial")
class DateLabelFormatter extends AbstractFormatter {

  private String datePattern = "yyyy-MM-dd";
  private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

  public Object stringToValue(String text) throws ParseException {
    return dateFormatter.parseObject(text);
  }

  public String valueToString(Object value) throws ParseException {
    if (value != null) {
        Calendar cal = (Calendar) value;
        return dateFormatter.format(cal.getTime());
    }

    return "";
  }

}

