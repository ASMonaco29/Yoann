package src;

import cda.Reponse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
public class WindowReponsesQuestionaireSp extends JDialog implements ActionListener {
  
  // Attributs à ajouter :
  private JTable tableauQn;
  private JButton bannulerQn;
  private JButton bmodifierQna;
  private JButton bsupprQn;
  private JLabel lintro; 
  private JLabel tricheQna;
  private JLabel tricheQnb;
  private JPanel pglobBtn;
  private JPanel panelQnN;
  private JPanel panelQnN1;
  private JPanel pfinalQn;
  private ModelTableauRpSp modeleRpSp;
  private ModelTableauQaSp modeleQaSp;
  private Reponse rep;
  private SimpleDateFormat format;
  private Date date;
  private int selectedRowQa;
  
  /** Constructeur.
  * @param compo informations de la classe appelante : WindowListeQuestionaireSp.
  * 
    Les autres paramètres : récupèrent les informations pour un sportif
  */
  public WindowReponsesQuestionaireSp(Component compo, ModelTableauQaSp modeleQs, 
      int selectedRowQa) {
  
    super((Frame) compo, "Liste de réponses", true);
    
    // Initilisation : 
    this.rep = modeleQs.getListR().getReponses().get(selectedRowQa);
    modeleRpSp = new ModelTableauRpSp(modeleQs.getListR(), selectedRowQa);
    modeleQaSp = modeleQs;
    tableauQn = new JTable(modeleRpSp);
    this.selectedRowQa = selectedRowQa;
    bannulerQn = new JButton("Retour");
    bannulerQn.addActionListener(this);
    bmodifierQna = new JButton("Modifier");
    bmodifierQna.addActionListener(this);
    bsupprQn = new JButton("Supprimer réponses");
    bsupprQn.addActionListener(this);
    
    format = new SimpleDateFormat("dd/MM/yyyy");
    date = this.rep.getDate();
    lintro = new JLabel("Liste des réponses au questionnaire \"" 
    + this.rep.getQuestionnaire().getTitre() + "\" à la date : " + format.format(this.date)); 
    tricheQna = new JLabel("     ");
    tricheQnb = new JLabel("     ");
    
    panelQnN = new JPanel(new FlowLayout());
    panelQnN.add(lintro);
    panelQnN1 = new JPanel();
    panelQnN1.setLayout(new BoxLayout(panelQnN1, BoxLayout.Y_AXIS));
    panelQnN1.add(panelQnN);
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
    pglobBtn.add(bsupprQn);
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
    
      /********************** QUITTER ***********************/
      
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bmodifierQna) {
    
      /****************** MODIFIER REPONSES DU QUESTIONNAIRE **********************/
    
      modeleQaSp.modifReponses(this.selectedRowQa);
      this.setVisible(false);
      this.dispose();
      
    } else if (source == bsupprQn) {
    
      /*-************** SUPPRIMER REPONSES AU QUESTIONNAIRE *************************/

      int replyR;
      String messageSupR;

      messageSupR = "Etes-vous sur de vouloir supprimer les réponses de ce questionnaire pour cette"
          + "date, définitivement ?";
      replyR = JOptionPane.showConfirmDialog(null, messageSupR, "Confirmation de la suppression",
          JOptionPane.YES_NO_OPTION);
      
      if (replyR == JOptionPane.YES_OPTION) {
        modeleQaSp.removeReponses(this.selectedRowQa);
        this.setVisible(false);
        this.dispose();
      }
    }
    
    
  }
}
