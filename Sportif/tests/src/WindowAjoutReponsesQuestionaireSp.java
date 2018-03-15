package src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
  private JButton bAnnulerQn;
  private JButton bModifierQna;
  private JLabel lIntro; 
  private JLabel tricheQna;
  private JLabel tricheQnb;
  private JPanel pGlobBtn;
  private JPanel panelQnN;
  private JPanel panelQnN1;
  private JPanel pFinalQn;
  private ModelTableauRpSp modeleRpSp;
  private ModelTableauQaSp modeleQaSp;
  private int selectedRowQa;
  
  // CONSTRUCTEUR :
  public WindowAjoutReponsesQuestionaireSp(Component compo, ModelTableauQaSp modeleQs){
  
    super((Frame) compo, "Ajout de réponses", true);
    
    // Initilisation :
    modeleRpSp = new ModelTableauRpSp(modeleQs.getListR(), selectedRowQa);
    modeleQaSp = modeleQs;
    tableauQn = new JTable(modeleRpSp);
    bAnnulerQn = new JButton("Annuler");
    bAnnulerQn.addActionListener(this);
    bModifierQna = new JButton("Ajouter");
    bModifierQna.addActionListener(this);
    
    lIntro = new JLabel("Ajout de nouvelles réponses au questionnaire : ");
    tricheQna = new JLabel("     ");
    tricheQnb = new JLabel("     ");
    
    panelQnN = new JPanel(new FlowLayout());
    panelQnN.add(lIntro);
    panelQnN1 = new JPanel();
    panelQnN1.setLayout(new BoxLayout(panelQnN1, BoxLayout.Y_AXIS));
    panelQnN1.add(panelQnN);
    panelQnN1.add(Box.createRigidArea(new Dimension(0,10)));
   
    
    
    // Tests sur les attributs :
   
    
    // Nouvelle fenêtre (questions) :
    pFinalQn = new JPanel(new BorderLayout());
    pFinalQn.setSize(670, 540);
    pFinalQn.setVisible(true);
    pFinalQn.setLayout(new BorderLayout());
    
    tableauQn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableauQn.setRowHeight(30);
    tableauQn.getTableHeader().setReorderingAllowed(false);
    
    
    pGlobBtn = new JPanel();
    pGlobBtn.add(tricheQna);
    pGlobBtn.add(bModifierQna);
    pGlobBtn.add(tricheQnb);
    pGlobBtn.add(bAnnulerQn);
    pFinalQn.add(panelQnN1, BorderLayout.NORTH);
    pFinalQn.add(new JScrollPane(tableauQn), BorderLayout.CENTER); 
    pFinalQn.add(pGlobBtn, BorderLayout.SOUTH);
    
    ImageIcon img = new ImageIcon("logo-sportif.jpg");
    this.setIconImage(img.getImage());
    
    
    this.getContentPane().add(pFinalQn);
    this.pack();
    this.setLocationRelativeTo(this);
    this.setMinimumSize(new Dimension(630, 500));
    this.setVisible(true);
    
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    /**************************** ANNULER ********************************/
    
    if(source == bAnnulerQn){
      this.setVisible(false);
      this.dispose();
    }
    
    /**************************** MODIFIER REPONSES DU QUESTIONNAIRE ********************************/
    
    else if(source == bModifierQna){
      modeleQaSp.modifReponses(this.selectedRowQa);
      this.setVisible(false);
      this.dispose();
    }
    
    
  }
}
