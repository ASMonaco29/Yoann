package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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



public class OngletQuestionnaire extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  private ModelTableauQa modeleQ = new ModelTableauQa();
  private JTabbedPane tabbedPane;
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 
  private JComponent panelQl; 
  private JComponent panelQg;
  private Border borderL;
  private Border borderG;
  private JPanel ptitre;
  private JPanel pstitre;
  private JPanel pdateDebut;
  private JPanel pdateFin;
  private JPanel pmessageFin;
  private JPanel pboutons;
  private JTextField ttitre; 
  private JTextField tstitre;
  private JTextField tmessageFin;
  private JLabel ltitre;
  private JLabel lstitre;
  private JLabel ldateDebut;
  private JLabel ldateFin;
  private JLabel lmessageFin;
  private JLabel triche;
  private JButton bcreer;
  private JButton bmodifier;
  private JButton bsupprimer;
  private JTable tableauQ;
  private TableRowSorter<ModelTableauQa> sorter;
  private Properties pr;
  private UtilDateModel modelDebut;
  private UtilDateModel modelFin;
  private JDatePanelImpl datePanelDebut;
  private JDatePanelImpl datePanelFin;
  private JDatePickerImpl dateDebut;
  private JDatePickerImpl dateFin;
  private int selectedRowQa = -1;
 
  
  
  /** Constructeur.
  * Les paramètres correspondent aux informations de la classe appelante : IHM.
  */
  public OngletQuestionnaire(JTabbedPane tabbedPane, JComponent panelQ) {
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
    this.borderL = BorderFactory.createTitledBorder("Liste Questionnaires");
    this.borderG = BorderFactory.createTitledBorder("Gérer Questionnaires");
    
    this.bcreer = new JButton("Créer");
    this.bcreer.addActionListener(this);
    this.bmodifier = new JButton("Modifier");
    this.bmodifier.addActionListener(this);
    this.bmodifier.setEnabled(false);
    this.bsupprimer = new JButton("Supprimer");
    this.bsupprimer.addActionListener(this);
    this.bsupprimer.setEnabled(false);
            
    this.ttitre = new JTextField(); 
    this.ttitre.setPreferredSize(new Dimension(250, 25));
    
    this.tstitre = new JTextField();
    this.tstitre.setPreferredSize(new Dimension(250, 25));
       
    this.pr = new Properties();
    this.pr.put("text.today", "Today");
    this.pr.put("text.month", "Month");
    this.pr.put("text.year", "Year");
    
    this.modelDebut = new UtilDateModel();
    this.datePanelDebut = new JDatePanelImpl(modelDebut, pr);
    this.dateDebut = new JDatePickerImpl(datePanelDebut, new DateLabelFormatter());
    this.dateDebut.setPreferredSize(new Dimension(120, 25));
    
    this.modelFin = new UtilDateModel();
    this.datePanelFin = new JDatePanelImpl(modelFin, pr);
    this.dateFin = new JDatePickerImpl(datePanelFin, new DateLabelFormatter());
    this.dateFin.setPreferredSize(new Dimension(120, 25));
    
    this.tmessageFin = new JTextField();
    this.tmessageFin.setPreferredSize(new Dimension(250, 25));
    
    this.ltitre = new JLabel("Titre : ");
    this.lstitre = new JLabel("Sous-titre : ");
    this.ldateDebut = new JLabel("Date début : ");
    this.ldateFin = new JLabel("Date fin : ");
    this.lmessageFin = new JLabel("Message de Fin : ");
    this.triche = new JLabel("                                                               "
        + "                                                                                   "
        + "                                                                                   "
        + "                                                                                  ");
    
    this.ptitre = new JPanel();
    this.ptitre.setLayout(new BorderLayout());
    this.pstitre = new JPanel();
    this.pstitre.setLayout(new BorderLayout());
    this.pdateDebut = new JPanel();
    this.pdateFin = new JPanel();
    this.pmessageFin = new JPanel();
    this.pboutons = new JPanel();
    this.pboutons.setLayout(new BoxLayout(this.pboutons, BoxLayout.LINE_AXIS));
    
    this.ptitre.add(this.ltitre, BorderLayout.WEST);
    this.ptitre.add(this.ttitre, BorderLayout.EAST);
    this.pstitre.add(this.lstitre, BorderLayout.WEST);
    this.pstitre.add(this.tstitre, BorderLayout.EAST);
    this.pdateDebut.add(this.ldateDebut, BorderLayout.WEST);
    this.pdateDebut.add(this.dateDebut, BorderLayout.EAST);
    this.pdateFin.add(this.ldateFin, BorderLayout.WEST);
    this.pdateFin.add(this.dateFin, BorderLayout.EAST);
    this.pmessageFin.add(this.lmessageFin, BorderLayout.WEST);
    this.pmessageFin.add(this.tmessageFin, BorderLayout.EAST);
    this.triche.setPreferredSize(new Dimension(0, 50));
    
    this.pboutons.add(this.bcreer); 
    this.pboutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pboutons.add(this.bmodifier);
    this.pboutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pboutons.add(this.bsupprimer);
    
    this.tableauQ = new JTable(modeleQ);
    this.sorter = new TableRowSorter<ModelTableauQa>(modeleQ); 
    tableauQ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableauQ.getColumn("Question(s)").setCellRenderer(new JListRenderer());
    tableauQ.getColumn("Question(s)").setCellEditor(new JListEditor());
    tableauQ.setRowHeight(70);
    sorter.setSortable(5, false);
    sorter.setSortsOnUpdates(true);
    tableauQ.setRowSorter(sorter);
    tableauQ.getTableHeader().setReorderingAllowed(false);
    tableauQ.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        clicSourisSurJtable(evt);
      }
    });
       
    // Paramètres de l'onglet Questionnaires
    
    tabbedPane.addTab("Questionnaires", panelQ);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_1);  
    
    // Ajout des attributs au contenu de l'onglet Questionnaires    
    panelQl.setBorder(borderL);
    panelQl.add(new JScrollPane(tableauQ), BorderLayout.CENTER); 
    
    panelQg.setBorder(borderG);
    panelQg.add(ptitre);
    panelQg.add(pstitre);
    panelQg.add(pdateDebut);
    panelQg.add(pdateFin);
    panelQg.add(pmessageFin);
    panelQg.add(triche);
    panelQg.add(pboutons);
    
    panelQ.add(panelQl);
    panelQ.add(Box.createRigidArea(new Dimension(0,5)));
    panelQ.add(panelQg);   
    
    
  }
  
  
  
  
  /** Actions réalisées lors de clic sur les différents boutons : créer/modifier/supprimer.
   * 
   */
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    
    /**************************** CREER QUESTIONNAIRE ********************************/
    if (source == this.bcreer) {

      if (this.ttitre.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer un titre.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if (this.tstitre.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer un sous-titre.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if ((Date)dateDebut.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer une date de début.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if ((Date)dateFin.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer une date de fin.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      
      } else {
        new WindowCreerQuestionaire(this, modeleQ, this.ttitre.getText(), this.tstitre.getText(),
            this.tmessageFin.getText(), (Date)dateDebut.getModel().getValue(),
            (Date)dateFin.getModel().getValue());
      }
    }
    
    /**************************** MODIFIER QUESTIONNAIRE ********************************/
    if (source == this.bmodifier) {

      if (this.ttitre.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer un titre.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if (this.tstitre.getText().length() == 0) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer un sous-titre.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if ((Date)dateDebut.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer une date de début.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      } else if ((Date)dateFin.getModel().getValue() == null) {
        JOptionPane.showMessageDialog(this, "Certains champs sont obligatoires :\n"
            + "Vous devez rentrer une date de fin.", "Erreur",  JOptionPane.ERROR_MESSAGE);   
      
      } else {
        new WindowModifierQuestionaire(this, modeleQ, this.selectedRowQa, this.ttitre.getText(),
            this.tstitre.getText(), this.tmessageFin.getText(),
            (Date)dateDebut.getModel().getValue(), (Date)dateFin.getModel().getValue());
      }
      
    }
    
    /**************************** SUPPRIMER QUESTIONNAIRE ********************************/
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
      
      selections = tableauQ.getSelectedRows();
      selection = selections[0];
      
      messageSupQ = "Etes-vous sur de vouloir supprimer ce questionnaire définitivement ?";
      replyQa = JOptionPane.showConfirmDialog(null, messageSupQ, "Confirmation de la suppression",
          JOptionPane.YES_NO_OPTION);
      
      if (replyQa == JOptionPane.YES_OPTION) {
        modelRow = tableauQ.convertRowIndexToModel(selection);
        modeleQ.removeQuestionnaire(modelRow);
        
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
        
        this.ttitre.setText(null);
        this.tstitre.setText(null);
        this.tmessageFin.setText(null);
        this.dateDebut.getModel().setSelected(false);
        this.dateDebut.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
        this.dateFin.getModel().setSelected(false);
        this.dateFin.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
        this.bsupprimer.setEnabled(false);
        this.bmodifier.setEnabled(false);
        this.bcreer.setEnabled(true);
      } // Sinon, la fenêtre se ferme.
      
    }
    
    
    
  }
  
  private void clicSourisSurJtable(MouseEvent evt) {
    
    // get the model from the jtable
    ModelTableauQa model = (ModelTableauQa)tableauQ.getModel();
    int selectedRowIndex;
    Date dt1;
    Date dt2;
    Date today;
    Date todayWithZeroTime;
    DateFormat formatter;
    String reportDate;
    int jourDate1;
    int moisDate1;
    int anDate1;
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
    int modelRow = tableauQ.getSelectedRow();
    
    if (modelRow != -1) {
      selectedRowIndex = tableauQ.convertRowIndexToModel(modelRow);
      this.selectedRowQa = selectedRowIndex;
      
      dt1 = (Date)model.getValueAt(selectedRowIndex, 2);
      dt2 = (Date)model.getValueAt(selectedRowIndex, 3);
      
      reportDate = formatter.format(dt1);
      jourDate1 = Integer.parseInt(reportDate.substring(0, 2));
      moisDate1 = Integer.parseInt(reportDate.substring(3, 5));
      anDate1 = Integer.parseInt(reportDate.substring(6, 10));
      
      reportDate = formatter.format(dt2);
      jourDate2 = Integer.parseInt(reportDate.substring(0, 2));
      moisDate2 = Integer.parseInt(reportDate.substring(3, 5));
      anDate2 = Integer.parseInt(reportDate.substring(6, 10));
      
      // set the selected row data into jtextfields
      this.ttitre.setText(model.getValueAt(selectedRowIndex, 0).toString());
      this.tstitre.setText(model.getValueAt(selectedRowIndex, 1).toString());
      this.tmessageFin.setText(model.getValueAt(selectedRowIndex, 4).toString());
      this.dateDebut.getModel().setDate(anDate1, moisDate1 - 1, jourDate1);
      this.dateDebut.getModel().setSelected(true);
      this.dateFin.getModel().setDate(anDate2, moisDate2 - 1, jourDate2);
      this.dateFin.getModel().setSelected(true);
      this.bsupprimer.setEnabled(true);
      this.bmodifier.setEnabled(true);
      this.bcreer.setEnabled(false);
    } else {
      this.ttitre.setText(null);
      this.tstitre.setText(null);
      this.tmessageFin.setText(null);
      this.dateDebut.getModel().setSelected(false);
      this.dateDebut.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
      this.dateFin.getModel().setSelected(false);
      this.dateFin.getModel().setDate(anTdy, moisTdy - 1, jourTdy);
      this.bsupprimer.setEnabled(false);
      this.bmodifier.setEnabled(false);
      this.bcreer.setEnabled(true);
    }
  }               
  
}