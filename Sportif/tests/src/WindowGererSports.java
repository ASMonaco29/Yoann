package src;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public class WindowGererSports extends JFrame implements ListSelectionListener, ActionListener {
 
  private JList<String> lsports;
  private JButton bajouter;
  private JButton bmodifier;
  private JButton bsupprimer;
  private JButton bquitter;
  private JPanel pfinalSp;
  private JPanel pboutons;
  private JScrollPane jscroll;
  private DefaultListModel<String> listModel;
  private ModelTableauSp modeleS;
  private DefaultComboBoxModel<Object> model;
 
  /** Constructeur.
   * 
   */
  public WindowGererSports(ModelTableauSp modeleS, DefaultComboBoxModel<Object> md) {
    
    this.modeleS = modeleS;
    this.model = md;
    listModel = new DefaultListModel<>();
    
    for(int i = 0; i < modeleS.getListeSports().getListSports().size(); i++){
      listModel.addElement(modeleS.getListeSports().getListSports().get(i));
    }
        
    // Create the list
    lsports = new JList<>(listModel);
    lsports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lsports.addListSelectionListener(this);
    lsports.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        clicSourisSurJtable(evt);
      }
    });
 
    bajouter = new JButton("Ajouter");
    bajouter.addActionListener(this);
    bmodifier = new JButton("Modifier");
    bmodifier.setEnabled(false);
    bmodifier.addActionListener(this);
    bsupprimer = new JButton("Supprimer");
    bsupprimer.setEnabled(false);
    bsupprimer.addActionListener(this);
    bquitter = new JButton("Fermer");
    bquitter.addActionListener(this);
    
    pboutons = new JPanel();
    pboutons.setLayout(new BoxLayout(pboutons, BoxLayout.Y_AXIS));
    
    pboutons.add(Box.createRigidArea(new Dimension(0, 40)));
    pboutons.add(bajouter);
    pboutons.add(Box.createRigidArea(new Dimension(0, 20)));
    pboutons.add(bmodifier);
    pboutons.add(Box.createRigidArea(new Dimension(0, 20)));
    pboutons.add(bsupprimer);
    pboutons.add(Box.createRigidArea(new Dimension(0, 20)));
    pboutons.add(bquitter);
    pboutons.add(Box.createRigidArea(new Dimension(0, 40)));
    
    jscroll = new JScrollPane(lsports);
    jscroll.setPreferredSize(new Dimension(150,300));
    
    pfinalSp = new JPanel();
    pfinalSp.setLayout(new BoxLayout(pfinalSp, BoxLayout.X_AXIS));
    pfinalSp.add(jscroll);
    pfinalSp.add(Box.createRigidArea(new Dimension(60, 0)));
    pfinalSp.add(pboutons);
    pfinalSp.add(Box.createRigidArea(new Dimension(60, 0)));
    
    ImageIcon img = new ImageIcon("logo-sportif.jpg");
    this.setIconImage(img.getImage());
    
    this.setTitle("Gestion des sports");
    this.getContentPane().add(pfinalSp);
    this.pack();
    this.setLocationRelativeTo(this);
    this.setMinimumSize(new Dimension(450, 350));
    this.setResizable(false);
    this.setVisible(true);
  }
    
    
  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    if (source == bquitter) {
      
      /**************************** QUITTER ********************************/
      
      this.setVisible(false);
      this.dispose();
    
    
    } else if (source == bajouter) {
    
      /*-*********************** AJOUTER SPORT *****************************/
      
      String titreDialogQn = "Ajout d'un sport";
      String messageDialogQn = "Veuillez taper le nom du sport :     ";
      String newSp = "";
      
      
      newSp = JOptionPane.showInputDialog(
          this, 
          messageDialogQn, 
          titreDialogQn, 
          JOptionPane.INFORMATION_MESSAGE
      );

      if ((newSp != null) && (newSp.length() > 0)) {
        modeleS.ajouterSport(newSp);
        this.listModel.addElement(newSp);
        this.model.addElement(newSp);
      } 
    
      
      
    } else if (source == bsupprimer) {
      
      /*-*********************** SUPPRIMER SPORT ***************************/
      
      int selection = this.lsports.getSelectedIndex();
      
      String messageSupQn = "Etes-vous sur de vouloir supprimer ce sport définitivement ?";
      int replyQn = JOptionPane.showConfirmDialog(null, messageSupQn, 
          "Confirmation de la suppression", JOptionPane.YES_NO_OPTION);
      
      if (replyQn == JOptionPane.YES_OPTION) {
        modeleS.supprimerSport(selection);
        this.listModel.remove(selection);
        this.model.removeElementAt(selection);
      }
      
    } else if (source == bmodifier) {
      
      /*-*********************** MODIFIER SPORT ***************************/
      
      int selection = this.lsports.getSelectedIndex();
      
      String titreDialogQn = "Modification d'un sport";
      String messageDialogQn = "Veuillez taper le nouveau nom du sport :     ";
      String newSp = "";
      
      
      newSp = JOptionPane.showInputDialog(
          this, 
          messageDialogQn, 
          titreDialogQn, 
          JOptionPane.INFORMATION_MESSAGE
      );

      if ((newSp != null) && (newSp.length() > 0)) {
        modeleS.modifierSport(newSp, selection);
        this.listModel.set(selection, newSp);
        this.model.removeElementAt(selection);
        this.model.insertElementAt(newSp, selection);
      } 
      
    }
  }
  
  /** Retourne la valeur selectionnée dans la liste.
   * 
   */
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      final List<String> selectedValuesList = this.lsports.getSelectedValuesList();
      System.out.println(selectedValuesList);
    }
  }

  
  private void clicSourisSurJtable(MouseEvent evt) { 
   
    // get the selected row index
    int modelRow = this.lsports.getSelectedIndex();
   
    if (modelRow != -1) {
      this.bsupprimer.setEnabled(true);
      this.bmodifier.setEnabled(true);
    } else {
      this.bsupprimer.setEnabled(false);
      this.bmodifier.setEnabled(false);
    }
  }      
 
}