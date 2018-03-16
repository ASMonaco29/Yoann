package src;

import cda.Question;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class WindowCreerQuestionaire extends JDialog implements ActionListener {
  
  // Attributs à ajouter :
  private String titre;
  private String stitre;
  private String msgfin;
  private Date dateD;
  private Date dateF;
  private JTable tableauQn;
  private ModelTableauQn modeleQn;
  private JButton bannulerQn;
  private JButton bcreerQna;
  private JButton bcreerQn;
  private JButton bsupprQn;
  private JLabel ltitreQn; 
  private JLabel lstitreQn; 
  private JLabel ldatedQn; 
  private JLabel ldatefQn; 
  private JLabel lmesgQn; 
  private JLabel ltitreQn1; 
  private JLabel lstitreQn1; 
  private JLabel ldatedQn1; 
  private JLabel ldatefQn1; 
  private JLabel lmesgQn1; 
  private JLabel lquestion;
  private JLabel tricheQna;
  private JLabel tricheQnb;
  private JLabel tricheQnc;
  private DateFormat dateFormat;
  private JPanel pwestQst;
  private JPanel peastQst;
  private JPanel pglobBtn;
  private JPanel panelQnN;
  private JPanel panelQnN1;
  private JPanel panelQnN2 = null;
  private JPanel panelQnN3;
  private JPanel pfinalQn;
  private ModelTableauQa modeleQa;
  private ArrayList<Question> questions;
  
  
  /** Constructeur.
  * @param compo informations de la classe appelante : OngletQuestionnaire.
  * 
    Les autres paramètres : récupèrent les informations inscrites dans le formulaire
  */
  public WindowCreerQuestionaire(Component compo, ModelTableauQa modeleQ, 
      String titre, String stitre, String msgfin, Date dateD, Date dateF) {
  
    super((Frame) compo, "Questions", true);
    
    // Initilisation : 
    dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
    this.titre = titre;
    this.stitre = stitre;
    this.msgfin = msgfin;
    this.dateD = dateD;
    this.dateF = dateF;
    this.modeleQa = modeleQ;
    modeleQn = new ModelTableauQn();
    tableauQn = new JTable(modeleQn);
    bannulerQn = new JButton("Annuler");
    bannulerQn.addActionListener(this);
    bcreerQna = new JButton("Créer questionnaire");
    bcreerQna.addActionListener(this);
    bcreerQn = new JButton("Créer une nouvelle question");
    bcreerQn.addActionListener(this);
    bsupprQn = new JButton("Supprimer question");
    bsupprQn.addActionListener(this);
    bsupprQn.setEnabled(false);
    ltitreQn = new JLabel("Titre : "); 
    lstitreQn = new JLabel("Sous-titre : "); 
    ldatedQn = new JLabel("Date début : "); 
    ldatefQn = new JLabel("Date fin : "); 
    lmesgQn = new JLabel("Message de fin : "); 
    lquestion = new JLabel("Veuillez sélectionner vos questions pour ce questionnaire : "); 
    tricheQna = new JLabel("     ");
    tricheQnb = new JLabel("     ");
    tricheQnc = new JLabel("     ");
    ltitreQn1 = new JLabel(this.titre); 
    lstitreQn1 = new JLabel(this.stitre); 
  
    lmesgQn1 = new JLabel(this.msgfin); 
    panelQnN = new JPanel(new FlowLayout());
    panelQnN.add(ltitreQn);
    panelQnN.add(ltitreQn1);
    panelQnN.add(lstitreQn);
    panelQnN.add(lstitreQn1);
    if (this.dateD != null && this.dateD != null) {
      ldatedQn1 = new JLabel(dateFormat.format(this.dateD)); 
      ldatefQn1 = new JLabel(dateFormat.format(this.dateF)); 
    
      panelQnN2 = new JPanel(new FlowLayout());
      panelQnN2.add(ldatedQn);
      panelQnN2.add(ldatedQn1);
      panelQnN2.add(ldatefQn);
      panelQnN2.add(ldatefQn1);
    }
    panelQnN.add(lmesgQn);
    panelQnN.add(lmesgQn1);
    
    panelQnN1 = new JPanel();
    panelQnN1.setLayout(new BoxLayout(panelQnN1, BoxLayout.Y_AXIS));
    panelQnN1.add(panelQnN);
    panelQnN1.add(Box.createRigidArea(new Dimension(0,5)));
    if (this.dateD != null && this.dateD != null) {
      panelQnN1.add(panelQnN2);
      panelQnN1.add(Box.createRigidArea(new Dimension(0,5)));
    }
    panelQnN3 = new JPanel();
    panelQnN3.add(lquestion);
    panelQnN1.add(panelQnN3);
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
    tableauQn.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        clicSourisSurJtable(evt);
      }
    });  
    
    
    
    pwestQst = new JPanel();
    pwestQst.setLayout(new BorderLayout());
    pwestQst.add(bcreerQn, BorderLayout.WEST);
    pwestQst.add(tricheQna, BorderLayout.CENTER);
    pwestQst.add(bsupprQn, BorderLayout.EAST);
    peastQst = new JPanel();
    peastQst.setLayout(new BorderLayout());
    peastQst.add(bcreerQna, BorderLayout.WEST);
    peastQst.add(tricheQnb, BorderLayout.CENTER);
    peastQst.add(bannulerQn, BorderLayout.EAST);
    pglobBtn = new JPanel();
    pglobBtn.setLayout(new BorderLayout());
    pglobBtn.add(pwestQst, BorderLayout.WEST);
    pglobBtn.add(tricheQnc, BorderLayout.CENTER);
    pglobBtn.add(peastQst, BorderLayout.EAST);
    
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


  protected void clicSourisSurJtable(MouseEvent evt) {
    // get the selected row index
    int modelRow = tableauQn.getSelectedRow();
    if (modelRow != -1) {          
      this.bsupprQn.setEnabled(true);
    } else {
      this.bsupprQn.setEnabled(false);
    }    
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    
    if (source == bannulerQn) {
      
      /**************************** QUITTER ********************************/
      
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bcreerQna) {
    
      /**************************** CREER QUESTIONNAIRE ********************************/
    
      this.questions = new ArrayList<Question>();
      
      for (int i = 0; i < modeleQn.getRowCount(); i++) {
        if ((Boolean)modeleQn.getValueAt(i, 0) == true) {
          questions.add(new Question((String)modeleQn.getValueAt(i, 1), 
              (Boolean)modeleQn.getValueAt(i, 2)));
        }
      }
      
      // Ajout du questionnaire :
      this.modeleQa.addQuestionnaire(new cda.Questionnaire(titre, stitre, dateD, 
          dateF, msgfin, this.questions));
    
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bsupprQn) {
    
      /**************************** SUPPRIMER QUESTION ********************************/
    
      int[] selection = tableauQn.getSelectedRows();
      
      String messageSupQn = "Etes-vous sur de vouloir supprimer cette question définitivement ?";
      int replyQn = JOptionPane.showConfirmDialog(null, messageSupQn, 
          "Confirmation de la suppression", JOptionPane.YES_NO_OPTION);
      
      if (replyQn == JOptionPane.YES_OPTION) {
        for (int i = selection.length - 1; i >= 0; i--) {
          modeleQn.removeQuestion(selection[i]);
        }
      }
        
    } else if (source == bcreerQn) {
    
      /*-************************** CREER QUESTION ********************************/
   
      String titreDialogQn = "Ajout d'une question";
      String messageDialogQn = "Veuillez taper l'intitulé de la question :     ";
      String newQn = "";
      
      
      newQn = JOptionPane.showInputDialog(
          this, 
          messageDialogQn, 
          titreDialogQn, 
          JOptionPane.INFORMATION_MESSAGE
      );

      if ((newQn != null) && (newQn.length() > 0)) {
        modeleQn.addQuestion(new Question(newQn, true));
        
      } 

    }
    
  }
}
