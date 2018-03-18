package src;

import cda.ListeReponses;
import cda.Question;
import cda.Questionnaire;
import cda.Reponse;
import cda.Sportif;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;



public class OngletGeneral extends ApplicationFrame {
  
  
  
  @SuppressWarnings("serial")
  static class CustomRingPlot extends RingPlot {

    private Font centerTextFont; 
    private Color centerTextColor;

    public CustomRingPlot(PieDataset dataset) {
      super(dataset);
      this.centerTextFont = new Font(Font.SANS_SERIF, Font.BOLD, 24);
      this.centerTextColor = Color.LIGHT_GRAY;
    }

    @Override
    protected void drawItem(Graphics2D g2, int section, 
              Rectangle2D dataArea, PiePlotState state, int currentPass) {
      
      super.drawItem(g2, section, dataArea, state, currentPass);
      if (currentPass == 1 && section == 0) {
        Number n0 = this.getDataset().getValue(section);
        Number n1 = this.getDataset().getValue(section+1);
        String affich = ""+n0.intValue() +" \"oui\"" + " - "+ n1.intValue() +" \"non\"";
        g2.setFont(this.centerTextFont);
        g2.setPaint(this.centerTextColor);
        TextUtilities.drawAlignedString(affich, g2, 
                      (float) dataArea.getCenterX(), 
                      (float) dataArea.getCenterY(),  
                      TextAnchor.CENTER);
      }
    }

  }
  
  
  
  private static final long serialVersionUID = 1L;
  private JTabbedPane tabbedPane;
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 
 
  
  /** Constructeur.
  * Les paramètres correspondent aux informations de la classe appelante : IHM.
  */
  public OngletGeneral(JTabbedPane tabbedPane, JComponent panelQ) {
    super("TEST12");
    this.tabbedPane = tabbedPane;
    this.panelQ = panelQ;
    construire();
  }
  
  
  /** Construire.
   * Permet de construire la fenêtre
   */
  public void construire() { 
        
    this.panelQ = new JPanel();
    this.panelQ.setLayout(new BorderLayout());
          
    // Paramètres de l'onglet Général
    tabbedPane.addTab("Général", panelQ);
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);  
       
    // Ajout des attributs au contenu de l'onglet Général
    this.panelQ.add(createDemoPanel(), BorderLayout.CENTER);
     
     
  }
   
   
  
  
  /**
   * Creates a sample dataset.
   *
   * @return A sample dataset.
   */
  private static PieDataset createDataset() {    
   
    ArrayList<Boolean> l1 = new ArrayList<Boolean>();
    
    l1.add(true); 
    l1.add(true); 
    l1.add(false); 
    l1.add(true); 
    l1.add(false); 
    l1.add(false); 
    l1.add(false); 
    l1.add(true); 
    l1.add(true); 
    
    Sportif s1 = new Sportif();
    Sportif s2 = new Sportif();
    
    ArrayList<Question> q = new ArrayList<Question>();
    q.add(new Question("Bien ?", false));
    q.add(new Question("Reveillé ?", true));
    q.add(new Question("Debout ?", true));
    q.add(new Question("Good ?", false));
    q.add(new Question("Awake ?", true));
    q.add(new Question("Wakdsse up ?", false));
    q.add(new Question("Wakedffffffffffffffffffffffffffffffffffffds up ?", false));
    q.add(new Question("Waksdsde up ?", true));
    q.add(new Question("Wakdsdse up ?", false));
    
    Questionnaire quest = new Questionnaire("Bien-être", "Soin", new Date(), new Date(), 
        "Merci d'avoir répondu à ce questionnaire.", q);
    
    Reponse r1 = new Reponse(new Date(), l1, s1, quest);
    Reponse r2 = new Reponse(new Date(), l1, s2, quest);
    Reponse r3 = new Reponse(new Date(), l1, s1, quest);
    
    ListeReponses lr = new ListeReponses();
    lr.ajouterReponse(r1);
    lr.ajouterReponse(r2);
    lr.ajouterReponse(r3);
    
    int nbOui = 0;
    int nbNon = 0;
    
    for (int i = 0; i < lr.getSizeListR(); i++) {
      for (int j = 0; j < lr.getReponses().get(i).getReponses().size(); j++) {
        if (lr.getReponses().get(i).getReponses().get(j) == true) {
          nbOui++;
        } else {
          nbNon++;
        }
      }
    }
    
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("Oui", nbOui);
    dataset.setValue("Non", nbNon);
    return dataset;
  }

  /**
   * Creates a chart.
   *
   * @param dataset  the dataset.
   *
   * @return A chart.
   */
  private static JFreeChart createChart(PieDataset dataset) {
    CustomRingPlot plot = new CustomRingPlot(dataset);
    JFreeChart chart = new JFreeChart("Oui/Non statistiques - tout questionnaires compris", 
              JFreeChart.DEFAULT_TITLE_FONT, plot, false);
    chart.setBackgroundPaint(new GradientPaint(new Point(0, 0), 
              new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

    // customise the title position and font
    TextTitle t = chart.getTitle();
    t.setHorizontalAlignment(HorizontalAlignment.LEFT);
    t.setPaint(new Color(240, 240, 240));
    t.setFont(new Font("Arial", Font.BOLD, 26));

    plot.setBackgroundPaint(null);
    plot.setOutlineVisible(false);
    plot.setLabelGenerator(null);
    plot.setSectionPaint("Oui", Color.ORANGE);
    plot.setSectionPaint("Non", new Color(100, 100, 100));
    plot.setSectionDepth(0.05);
    plot.setSectionOutlinesVisible(false);
    plot.setShadowPaint(null);
    
    return chart;

  }

  /**
   * Creates a panel for the demo (used by SuperDemo.java).
   *
   * @return A panel.
   */
  public static JPanel createDemoPanel() {
    JFreeChart chart = createChart(createDataset());
    chart.setPadding(new RectangleInsets(4, 8, 2, 2));
    ChartPanel panel = new ChartPanel(chart);
    panel.setMouseWheelEnabled(true);
    panel.setPreferredSize(new Dimension(600, 300));
    return panel;
  }
       
}