package src;

import cda.Reponse;
import cda.Sportif;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class WindowAjoutReponsesQuestionaireSp extends JDialog implements ActionListener {
  
  // Attributs à ajouter :
  private JTable tableauQn;
  //private ModelTableauQa modeleQa;
  private JButton bannulerQn;
  private JButton bmodifierQna;
  private JLabel lintro; 
  private JLabel tricheQna;
  private JLabel tricheQnb;
  private JPanel pglobBtn;
  private JPanel panelQnN;
  private JPanel panelQnN1;
  private JPanel panelQnN2;
  private JPanel pfinalQn;
  private ModelTableauQaSp modeleQaSp;
  private ModelTableauAjoutRpSp modeleAjRpSp;
  private Sportif sportif;
  private ArrayList<Boolean> reponse;
  @SuppressWarnings("rawtypes")
  private JComboBox jquest;
  private String[] jelem;
  private int jcomboSize;
  
  
  /** Constructeur.
  * Les paramètres correspondent aux informations de la classe appelante : OngletSportif.
  */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public WindowAjoutReponsesQuestionaireSp(Component compo, ModelTableauQaSp modeleQs) {
  
    super((Frame) compo, "Ajout de réponses", true);
    
    // Initilisation :
    modeleQaSp = modeleQs;
    modeleAjRpSp = new ModelTableauAjoutRpSp(modeleQaSp.getSportif(), 0);
    sportif = modeleQs.getSportif();
    tableauQn = new JTable(modeleAjRpSp);
    bannulerQn = new JButton("Annuler");
    bannulerQn.addActionListener(this);
    bmodifierQna = new JButton("Ajouter");
    bmodifierQna.addActionListener(this);
    
    jelem = new String[modeleAjRpSp.getListeQuestionnaires().getListQ().size()];
    for (jcomboSize = 0; jcomboSize < modeleAjRpSp.getListeQuestionnaires()
        .getListQ().size(); jcomboSize++) {
      jelem[jcomboSize] = modeleAjRpSp.getListeQuestionnaires().getListQ()
          .get(jcomboSize).getTitre();
    }
    this.jquest = new JComboBox(this.jelem);
    this.jquest.setPreferredSize(new Dimension(250, 25));
    this.jquest.addActionListener(this);
    
    lintro = new JLabel("Ajout de nouvelles réponses au questionnaire : ");
    tricheQna = new JLabel("     ");
    tricheQnb = new JLabel("     ");
    
    panelQnN = new JPanel(new FlowLayout());
    panelQnN.add(lintro);
    panelQnN2 = new JPanel(new FlowLayout());
    panelQnN2.add(this.jquest);
    panelQnN1 = new JPanel();
    panelQnN1.setLayout(new BoxLayout(panelQnN1, BoxLayout.Y_AXIS));
    panelQnN1.add(panelQnN);
    panelQnN1.add(Box.createRigidArea(new Dimension(0,5)));
    panelQnN1.add(panelQnN2);
    panelQnN1.add(Box.createRigidArea(new Dimension(0,10)));
    
    
    // Tests sur les attributs :
   
    
    // Nouvelle fenêtre (questions) :
    pfinalQn = new JPanel(new BorderLayout());
    pfinalQn.setSize(670, 540);
    pfinalQn.setVisible(true);
    pfinalQn.setLayout(new BorderLayout());
    
    tableauQn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableauQn.setRowHeight(30);
    tableauQn.getTableHeader().setReorderingAllowed(false);
    
    
    pglobBtn = new JPanel();
    pglobBtn.add(tricheQna);
    pglobBtn.add(bmodifierQna);
    pglobBtn.add(tricheQnb);
    pglobBtn.add(bannulerQn);
    pfinalQn.add(panelQnN1, BorderLayout.NORTH);
    pfinalQn.add(new JScrollPane(tableauQn), BorderLayout.CENTER); 
    pfinalQn.add(pglobBtn, BorderLayout.SOUTH);
    
    ImageIcon img = new ImageIcon("logo-sportif.jpg");
    this.setIconImage(img.getImage());
    
    
    this.getContentPane().add(pfinalQn);
    this.pack();
    this.setLocationRelativeTo(this);
    this.setMinimumSize(new Dimension(630, 500));
    this.setVisible(true);
    
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    if (source == bannulerQn) {
      
      /**************************** ANNULER ********************************/
      
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bmodifierQna) {
      
      /****************** AJOUTER REPONSES DU QUESTIONNAIRE ****************/   
      
      this.reponse = new ArrayList<Boolean>();
      
      for (int i = 0; i < modeleAjRpSp.getRowCount(); i++) {
        reponse.add((Boolean)modeleAjRpSp.getValueAt(i, 1));
      }
      
      // Ajout du questionnaire :
      this.modeleQaSp.addReponse(new Reponse(new Date(), this.reponse, this.sportif, 
          modeleAjRpSp.getQuestionnaire()));
      
      this.setVisible(false);
      this.dispose();
      
    } else if (source == jquest) {
    
      /*********************** JComboBox *************************/
    
      modeleAjRpSp.setQuestionnaire(jquest.getSelectedIndex());
    }
    
    
  }
}
