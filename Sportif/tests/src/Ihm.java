package src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.table.TableCellRenderer;



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






/* *********************** CLASSE POUR LE CALENDRIER *************************/
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


/* *********************************** CLASSE POUR JCHECKBOX ***************** */
@SuppressWarnings("serial")
class BoolCellEditor extends DefaultCellEditor {
  public BoolCellEditor() {
      super(new JCheckBox());
  }
}


/* ************************************* CLASSE POUR JLIST  ******************** */
@SuppressWarnings("serial")
class JListRenderer extends JScrollPane implements TableCellRenderer {
  
  @SuppressWarnings("rawtypes")
  private JList list;
  
  @SuppressWarnings("rawtypes")
  public JListRenderer() {
    list = new JList();
    getViewport().add(list);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellRendererComponent(JTable table, Object value,
       boolean isSelected, boolean hasFocus, int row, int column) {
      
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
      list.setForeground(table.getSelectionForeground());
      list.setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
      list.setForeground(table.getForeground());
      list.setBackground(table.getBackground());
    }
  
    list.setModel((DefaultListModel )value) ;
 
    return this;
  }
}
 

/* ************************************* CLASSE POUR JLIST  ******************** */
@SuppressWarnings("serial")
class JListEditor extends DefaultCellEditor {
   
  @SuppressWarnings("rawtypes")
  private JList list;
  private JScrollPane scrollpane;

  
   @SuppressWarnings({ "rawtypes" })
  public JListEditor() {
    super(new JCheckBox());
    
    scrollpane = new JScrollPane();
    list = new JList(); 
    scrollpane.getViewport().add(list);
   }
  
   @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellEditorComponent(JTable table, Object value,
                                   boolean isSelected, int row, int column) {
    list.setModel((DefaultListModel )value);
    
 
    return scrollpane;
  }
  
}