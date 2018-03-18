package src;

import cda.Sport;
import cda.Sportif;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.TableRowSorter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



public class OngletSportif extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  private ModelTableauSp modeleS = new ModelTableauSp();
  private JTabbedPane tabbedPane;
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 
  private JComponent panelQl; 
  private JComponent panelQg;
  private Border borderL;
  private Border borderG;
  private JPanel ppseudo;
  private JPanel pnom;
  private JPanel pprenom;
  private JPanel pdateNaissance;
  private JPanel psport;
  private JPanel pboutons;
  private JPanel pquestionnaire;
  private JTextField tpseudo; 
  private JTextField tnom;
  private JTextField tprenom;
  private JComboBox<Object> jsport;
  private DefaultComboBoxModel<Object> model;
  private JLabel lpseudo;
  private JLabel lnom;
  private JLabel lprenom;
  private JLabel ldateNaissance;
  private JLabel lsport;
  private JLabel triche;
  private JButton bquestionnaire;
  private JButton bcreer;
  private JButton bmodifier;
  private JButton bsupprimer;
  private JButton bsport;
  private JTable tableauS;
  private TableRowSorter<ModelTableauSp> sorter;
  private Properties pr;
  private UtilDateModel modelDate;
  private JDatePanelImpl datePanel;
  private JDatePickerImpl dateNaissance;
  private int selectedRowQa = -1;
 
  
  
  /** Constructeur.
  * Les paramètres correspondent aux informations de la classe appelante : IHM.
  */
  public OngletSportif(JTabbedPane tabbedPane, JComponent panelQ) {
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
    
    this.bquestionnaire = new JButton("Détails questionnaires");
    this.bquestionnaire.addActionListener(this);
    this.bquestionnaire.setEnabled(false);
    this.bcreer = new JButton("Créer");
    this.bcreer.addActionListener(this);
    this.bmodifier = new JButton("Modifier");
    this.bmodifier.addActionListener(this);
    this.bmodifier.setEnabled(false);
    this.bsupprimer = new JButton("Supprimer");
    this.bsupprimer.addActionListener(this);
    this.bsupprimer.setEnabled(false);
    this.bsport = new JButton("Gérer sports");
    this.bsport.addActionListener(this);
            
    this.tpseudo = new JTextField(); 
    this.tpseudo.setPreferredSize(new Dimension(250, 25));
    
    this.tnom = new JTextField();
    this.tnom.setPreferredSize(new Dimension(250, 25));
    
    this.tprenom = new JTextField();
    this.tprenom.setPreferredSize(new Dimension(250, 25));
       
    this.pr = new Properties();
    this.pr.put("text.today", "Today");
    this.pr.put("text.month", "Month");
    this.pr.put("text.year", "Year");
    
    this.modelDate = new UtilDateModel();
    this.datePanel = new JDatePanelImpl(modelDate, pr);
    this.dateNaissance = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    this.dateNaissance.setPreferredSize(new Dimension(120, 25));
    
    model = new DefaultComboBoxModel<>(modeleS
        .getListeSports().getListSports().toArray());
    this.jsport = new JComboBox<>(model);
    this.jsport.setPreferredSize(new Dimension(250, 25));
    this.jsport.setSelectedIndex(-1);
    
    this.lpseudo = new JLabel("Pseudo : ");
    this.lnom = new JLabel("Nom : ");
    this.lprenom = new JLabel("Prénom : ");
    this.ldateNaissance = new JLabel("Date de naissance : ");
    this.lsport = new JLabel("  Sport : ");
    this.triche = new JLabel("                                                               "
        + "                                                                                   "
        + "                                                                                   "
        + "                                                                                  ");
    
    this.ppseudo = new JPanel();
    this.ppseudo.setLayout(new BorderLayout());
    this.pnom = new JPanel();
    this.pnom.setLayout(new BorderLayout());
    this.pprenom = new JPanel();
    this.pprenom.setLayout(new BorderLayout());
    this.pdateNaissance = new JPanel();
    this.psport = new JPanel();
    this.pquestionnaire = new JPanel();
    this.pboutons = new JPanel();
    this.pboutons.setLayout(new BoxLayout(this.pboutons, BoxLayout.LINE_AXIS));
    
    this.ppseudo.add(this.lpseudo, BorderLayout.WEST);
    this.ppseudo.add(this.tpseudo, BorderLayout.EAST);
    this.pnom.add(this.lnom, BorderLayout.WEST);
    this.pnom.add(this.tnom, BorderLayout.EAST);
    this.pprenom.add(this.lprenom, BorderLayout.WEST);
    this.pprenom.add(this.tprenom, BorderLayout.EAST);
    this.pdateNaissance.add(this.ldateNaissance, BorderLayout.WEST);
    this.pdateNaissance.add(this.dateNaissance, BorderLayout.EAST);
    this.psport.add(this.bsport, BorderLayout.WEST);
    this.psport.add(this.lsport, BorderLayout.CENTER);
    this.psport.add(this.jsport, BorderLayout.EAST);
    this.pquestionnaire.add(this.bquestionnaire);
    this.triche.setPreferredSize(new Dimension(0, 50));
    
    this.pboutons.add(this.bcreer); 
    this.pboutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pboutons.add(this.bmodifier);
    this.pboutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pboutons.add(this.bsupprimer);
    
    this.tableauS = new JTable(modeleS);
    this.sorter = new TableRowSorter<ModelTableauSp>(modeleS); 
    tableauS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableauS.getColumn("Questionnaire(s) attribué(s)").setCellRenderer(new JListRenderer());
    tableauS.getColumn("Questionnaire(s) attribué(s)").setCellEditor(new JListEditor());
    tableauS.setRowHeight(70);
    sorter.setSortable(5, false);
    sorter.setSortsOnUpdates(true);
    tableauS.setRowSorter(sorter);
    tableauS.getTableHeader().setReorderingAllowed(false);
    tableauS.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        clicSourisSurJtable(evt);
      }
    });
       
    // Paramètres de l'onglet Questionnaires
    
    tabbedPane.addTab("Sportifs", panelQ);
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_1);  
    
    // Ajout des attributs au contenu de l'onglet Questionnaires    
    panelQl.setBorder(borderL);
    panelQl.add(new JScrollPane(tableauS), BorderLayout.CENTER); 
    
    panelQg.setBorder(borderG);
    panelQg.add(ppseudo);
    panelQg.add(pnom);
    panelQg.add(pprenom);
    panelQg.add(pdateNaissance);
    panelQg.add(psport);
    panelQg.add(pquestionnaire);
    panelQg.add(triche);
    panelQg.add(pboutons);
    
    panelQ.add(panelQl);
    panelQ.add(Box.createRigidArea(new Dimension(0,5)));
    panelQ.add(panelQg);   
    
    
  }
  
  
  
  
  /** Actions réalisées lors de clic sur les différents boutons : gérer/créer/modifier/supprimer.
   * 
   */
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    /**************************** GERER QUESTIONNAIRE ********************************/
    if (source == this.bquestionnaire) {
      int[] selections;
      int selection;
      selections = tableauS.getSelectedRows();
      selection = tableauS.convertRowIndexToModel(selections[0]);
      
      Sportif s = null;
      for (int i = 0; i < this.modeleS.getListeSportifs().getSizeListS(); i++) {
        if ((String)modeleS.getValueAt(selection, 0) 
            == this.modeleS.getListeSportifs().getListeS().get(i).getPseudo()) {
          s = this.modeleS.getListeSportifs().getListeS().get(i);
        }
      }
      
      new WindowListeQuestionaireSp(this, new ModelTableauQaSp(s), 
      (String)modeleS.getValueAt(selection, 0), this.modeleS, selection);
      
    }
    
    /**************************** GERER SPORTS ********************************/
    if (source == this.bsport) {
      new WindowGererSports(modeleS, this.model);
    }
    
    /**************************** CREER SPORTIF ********************************/
    if (source == this.bcreer) {
      
      if (this.tpseudo.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un pseudo.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if (this.tnom.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un nom.", "Erreur",  JOptionPane.ERROR_MESSAGE);
      } else if (this.tprenom.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un prénom.", "Erreur",  JOptionPane.ERROR_MESSAGE);      
      } else if ((Date)dateNaissance.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer une date de naissance.", "Erreur",
            JOptionPane.ERROR_MESSAGE);      
      } else if ((Sport)this.jsport.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un sport.", "Erreur",
            JOptionPane.ERROR_MESSAGE);      
      
      } else {
        modeleS.creerSportif(this.tnom.getText(), this.tprenom.getText(), this.tpseudo.getText(),
            (Date)dateNaissance.getModel().getValue(), (String)this.jsport.getSelectedItem());
      }
    }
    
    /**************************** MODIFIER SPORTIF ********************************/
    if (source == this.bmodifier) {
      
      if (this.tpseudo.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un pseudo.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if (this.tnom.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un nom.", "Erreur",  JOptionPane.ERROR_MESSAGE);
      } else if (this.tprenom.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un prénom.", "Erreur",  JOptionPane.ERROR_MESSAGE);      
      } else if ((Date)dateNaissance.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer une date de naissance.", "Erreur",
            JOptionPane.ERROR_MESSAGE);      
      } else if ((Sport)this.jsport.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires :\n"
            + "Vous devez rentrer un sport.", "Erreur",
            JOptionPane.ERROR_MESSAGE);      
      
      } else {
        modeleS.modifSportif(this.tnom.getText(), this.tprenom.getText(), 
            this.tpseudo.getText(), (Date)dateNaissance.getModel().getValue(), 
            (String)this.jsport.getSelectedItem(), this.selectedRowQa);
      }
    }
    
    /**************************** SUPPRIMER SPORTIF ********************************/
    if (source == this.bsupprimer) {
      
      int[] selections;
      int selection;
      int modelRow;
      final int replyQa;
      String messageSupQ; 
      Date today;
      Date todayWithZeroTime;
      DateFormat formatter;
      String reportDate;
      int jourTdy = 0;
      int moisTdy = 0;
      int anTdy = 0;
      
      selections = tableauS.getSelectedRows();
      selection = selections[0];
      
      messageSupQ = "Etes-vous sur de vouloir supprimer ce sportif définitivement ?";
      replyQa = JOptionPane.showConfirmDialog(null, messageSupQ, "Confirmation de la suppression",
          JOptionPane.YES_NO_OPTION);
      
      if (replyQa == JOptionPane.YES_OPTION) {
        modelRow = tableauS.convertRowIndexToModel(selection);
        modeleS.supprimerSportif(modelRow);
        
        
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = new Date();
        try {
          todayWithZeroTime = formatter.parse(formatter.format(today));
          reportDate = formatter.format(todayWithZeroTime);
          jourTdy = Integer.parseInt(reportDate.substring(0, 2));
          moisTdy = Integer.parseInt(reportDate.substring(3, 5));
          anTdy = Integer.parseInt(reportDate.substring(6, 10));
        
        } catch (ParseException e2) {
          e2.printStackTrace();
        }  
        
        this.tpseudo.setText(null);
        this.tnom.setText(null);
        this.tprenom.setText(null);
        this.jsport.setSelectedIndex(-1);
        this.dateNaissance.getModel().setSelected(false);
        this.dateNaissance.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
        this.bsupprimer.setEnabled(false);
        this.bmodifier.setEnabled(false);
        this.bquestionnaire.setEnabled(false);
        this.bcreer.setEnabled(true);
      } // Sinon, la fenêtre se ferme.
      
    }
    
    
    
  }
  
  private void clicSourisSurJtable(MouseEvent evt) {
    
    // get the model from the jtable
    ModelTableauSp model = (ModelTableauSp)tableauS.getModel();
    int selectedRowIndex;
    Date dt;
    Date today;
    Date todayWithZeroTime;
    DateFormat formatter;
    String reportDate;
    String combo;
    int jourDate2;
    int moisDate2;
    int anDate2;
    int jourTdy = 0;
    int moisTdy = 0;
    int anTdy = 0;
    
    // Gestion des dates
    formatter = new SimpleDateFormat("dd/MM/yyyy");
    today = new Date();
    try {
      todayWithZeroTime = formatter.parse(formatter.format(today));
      reportDate = formatter.format(todayWithZeroTime);
      jourTdy = Integer.parseInt(reportDate.substring(0, 2));
      moisTdy = Integer.parseInt(reportDate.substring(3, 5));
      anTdy = Integer.parseInt(reportDate.substring(6, 10));
      
    } catch (ParseException e) {
      e.printStackTrace();
    }  
   
    // get the selected row index
    int modelRow = tableauS.getSelectedRow();
   
    if (modelRow != -1) {
      selectedRowIndex = tableauS.convertRowIndexToModel(modelRow);
      this.selectedRowQa = selectedRowIndex;
     
      dt = (Date)model.getValueAt(selectedRowIndex, 3);
     
      reportDate = formatter.format(dt);
      jourDate2 = Integer.parseInt(reportDate.substring(0, 2));
      moisDate2 = Integer.parseInt(reportDate.substring(3, 5));
      anDate2 = Integer.parseInt(reportDate.substring(6, 10));
     
      combo = model.getValueAt(selectedRowIndex, 4).toString();
      int i = 0;
      for (Sport sp : Sport.values()) {
        if (combo.equalsIgnoreCase(sp.name())) {
          break;
        }
        i++;
      }
     
      // set the selected row data into jtextfields
      this.tpseudo.setText(model.getValueAt(selectedRowIndex, 0).toString());
      this.tpseudo.setEditable(false);
      this.tnom.setText(model.getValueAt(selectedRowIndex, 1).toString());
      this.tprenom.setText(model.getValueAt(selectedRowIndex, 2).toString());
      this.jsport.setSelectedIndex(i);
      this.dateNaissance.getModel().setDate(anDate2, moisDate2 - 1, jourDate2);
      this.dateNaissance.getModel().setSelected(true);
      this.bsupprimer.setEnabled(true);
      this.bmodifier.setEnabled(true);
      this.bquestionnaire.setEnabled(true);
      this.bcreer.setEnabled(false);
    } else {
      this.tpseudo.setText(null);
      this.tpseudo.setEditable(true);
      this.tnom.setText(null);
      this.tprenom.setText(null);
      this.jsport.setSelectedIndex(-1);
      this.dateNaissance.getModel().setSelected(false);
      this.dateNaissance.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
      this.bsupprimer.setEnabled(false);
      this.bmodifier.setEnabled(false);
      this.bquestionnaire.setEnabled(false);
      this.bcreer.setEnabled(true);
    }
  }              
  
}