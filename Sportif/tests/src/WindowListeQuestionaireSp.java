package src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.table.TableRowSorter;

import cda.Questionnaire;


@SuppressWarnings("serial")
public class WindowListeQuestionaireSp extends JDialog implements ActionListener {
  
  // Attributs à ajouter :
  private String sportif;
  private JTable tableauQn;
  private TableRowSorter<ModelTableauQaSp> sorter;
  private JButton bannulerQn;
  private JButton bdetailQna;
  private JButton bcreerQn;
  private JButton bsupprQn;
  private JLabel lintro; 
  private JLabel lsportif; 
  private JLabel tricheQna;
  private JLabel tricheQnb;
  private JLabel tricheQnc;
  private JPanel pwestQst;
  private JPanel peastQst;
  private JPanel pglobBtn;
  private JPanel panelQnN;
  private JPanel panelQnN1;
  private JPanel panelQnN3;
  private JPanel pfinalQn;
  private Component wind;
  private ModelTableauQaSp modeleQaSp;
  private ModelTableauSp modeleSp;
  private int selectedRowQa;
  
  
  /** Constructeur.
  * @param compo informations de la classe appelante : OngletSportif.
  * 
    Les autres paramètres : récupèrent les informations pour un sportif
  */
  public WindowListeQuestionaireSp(Component compo, ModelTableauQaSp modeleQs, String pseudoSp, 
      ModelTableauSp mtsp, int selectedRowQa) {
  
    super((Frame) compo, "Questionnaires attribués", true);
    
    // Initilisation : 
    this.sportif = pseudoSp;
    this.modeleQaSp = modeleQs;
    this.modeleSp = mtsp;
    this.selectedRowQa = selectedRowQa;
    this.wind = compo;
    tableauQn = new JTable(modeleQaSp);
    bannulerQn = new JButton("Retour");
    bannulerQn.addActionListener(this);
    bdetailQna = new JButton("Détail des réponses");
    bdetailQna.addActionListener(this);
    bdetailQna.setEnabled(false);
    bcreerQn = new JButton("Ajouter réponses");
    bcreerQn.addActionListener(this);
    bsupprQn = new JButton("Supprimer réponses");
    bsupprQn.addActionListener(this);
    bsupprQn.setEnabled(false);
    lintro = new JLabel("Liste des questionnaires pour le sportif : "); 
    lsportif = new JLabel(this.sportif); 
    tricheQna = new JLabel("     ");
    tricheQnb = new JLabel("     ");
    tricheQnc = new JLabel("     ");
    
    panelQnN = new JPanel(new FlowLayout());
    panelQnN.add(lintro);
    panelQnN1 = new JPanel();
    panelQnN1.setLayout(new BoxLayout(panelQnN1, BoxLayout.Y_AXIS));
    panelQnN1.add(panelQnN);
    panelQnN1.add(Box.createRigidArea(new Dimension(0,5)));
    panelQnN3 = new JPanel();
    panelQnN3.add(lsportif);
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
    this.sorter = new TableRowSorter<ModelTableauQaSp>(modeleQaSp); 
    sorter.setSortsOnUpdates(true);
    tableauQn.setRowSorter(sorter);
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
    peastQst.add(bdetailQna, BorderLayout.WEST);
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
      this.bdetailQna.setEnabled(true);
    } else {
      this.bsupprQn.setEnabled(false);
      this.bdetailQna.setEnabled(false);
    }  
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    
    
    if (source == bannulerQn) {
      
      /******************* QUITTER ***********************/
      
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bdetailQna) {
    
      /************* DETAIL REPONSES DU QUESTIONNAIRE ********************/
    
      int[] selections;
      int selection;
      ArrayList<Questionnaire> quest2;
      
      quest2 = new ArrayList<Questionnaire>();
      
      selections = tableauQn.getSelectedRows();
      selection = tableauQn.convertRowIndexToModel(selections[0]);
      
      new WindowReponsesQuestionaireSp(this.wind, this.modeleQaSp, selection);
      this.bsupprQn.setEnabled(false);
      this.bdetailQna.setEnabled(false);
      
      for (int i = 0; i < modeleQaSp.getListR().getSizeListR(); i++) {
        quest2.add(modeleQaSp.getListR().getReponses().get(i).getQuestionnaire());
      }
      modeleSp.modifQuestSportif(this.sportif, quest2, selectedRowQa);
      
    } else if (source == bsupprQn) {
    
      /***************** SUPPRIMER REPONSES AU QUESTIONNAIRE *********************/
   
      int[] selections;
      int selection;
      final int replyR;
      String messageSupR;
      ArrayList<Questionnaire> quest;
      
      quest = new ArrayList<Questionnaire>();
      
      selections = tableauQn.getSelectedRows();
      selection = tableauQn.convertRowIndexToModel(selections[0]);
      
      messageSupR = "Etes-vous sur de vouloir supprimer les réponses de ce questionnaire pour cette"
          + "date, définitivement ?";
      replyR = JOptionPane.showConfirmDialog(null, messageSupR, "Confirmation de la suppression",
          JOptionPane.YES_NO_OPTION);
      
      if (replyR == JOptionPane.YES_OPTION) {
        modeleQaSp.removeReponses(selection);
        
        for (int i = 0; i < modeleQaSp.getListR().getSizeListR(); i++) {
          quest.add(modeleQaSp.getListR().getReponses().get(i).getQuestionnaire());
        }
        
        modeleSp.modifQuestSportif(this.sportif, quest, selectedRowQa);
      }
      
      this.bsupprQn.setEnabled(false);
      this.bdetailQna.setEnabled(false);
      
    } else if (source == bcreerQn) {
    
      /****************** AJOUTER REPONSES AU QUESTIONNAIRE ***********************/
    
      ArrayList<Questionnaire> quest1;
      
      quest1 = new ArrayList<Questionnaire>();
      new WindowAjoutReponsesQuestionaireSp(this.wind, this.modeleQaSp);
      for (int i = 0; i < modeleQaSp.getListR().getSizeListR(); i++) {
        quest1.add(modeleQaSp.getListR().getReponses().get(i).getQuestionnaire());
      }
      
      modeleSp.modifQuestSportif(this.sportif, quest1, selectedRowQa);
    }
    
  }
}
