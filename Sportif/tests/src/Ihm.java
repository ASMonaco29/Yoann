package src;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.*;

public class Ihm extends JFrame implements ActionListener{
  
//ONGLET 1
 private JLabel annonce, nomSourceL, nomNewL1, nomNewL2, nbElemL ;
 private JTextField nomSourceT, nomNewT;
 @SuppressWarnings("rawtypes")
 private JComboBox nbElem;
 private JButton annuler, crypter;
 
 // ONGLET 2
 private JLabel annonce1, nomSourceDecryptL;
 private JTextField nomSourceDecryptT;
 private JButton annuler1, decrypter ;
 
 
 public Ihm(String nom) {
               
       this.setSize(720, 480); // Taille de la fenêtre
   this.setTitle(nom); // Titre
   this.setLocationRelativeTo(null); // Position par rapport au centre de l'écran
   this.setResizable(false); // On ne peut pas toucher à la taille de la fenêtre
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lorsqu'on ferme la fenêtre, le programme
                             // se ferme "proprement"  
   construire();
 }
      
 
 @SuppressWarnings({ "unchecked", "rawtypes" })
 public void construire() {
   
   JTabbedPane tabbedPane = new JTabbedPane();  
   
   // ONGLET CRYPTER
   JComponent panelC = new JPanel();
   
   // Attributs
   this.annonce = new JLabel("Ce logiciel prend en compte uniquement les images au format JPG.");
   annonce.setBounds(100, 60, 400, 20);
     
   this.nomSourceL = new JLabel("Nom du fichier source (.JPG) : ");
   nomSourceL.setBounds(100, 120, 200, 20);
   
   this.nomSourceT = new JTextField();
   nomSourceT.setBounds(280, 120, 200, 20);
   
   this.nomNewL1 = new JLabel("Nom des fichiers de sortie :");
   nomNewL1.setBounds(100, 180, 200, 20);
   
   this.nomNewL2 = new JLabel("(.JPG inclus)");
   nomNewL2.setBounds(490, 180, 200, 20);
   
   this.nomNewT = new JTextField();
   nomNewT.setBounds(280, 180, 200, 20);
   
   this.nbElemL = new JLabel("Nombre de fichiers en sortie : ");
   nbElemL.setBounds(100, 240, 175, 20);
 
   Object[] valeurs = new Object[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
   this.nbElem = new JComboBox(valeurs);
   nbElem.setBounds(280, 240, 50, 20);
   
   this.annuler = new JButton("Annuler");
   annuler.setBounds(430, 320, 120, 40);
   annuler.addActionListener(this);
   
   this.crypter = new JButton("Crypter");
   crypter.setBounds(150, 320, 120, 40);
   crypter.addActionListener(this);
   
       // Paramètres de l'onglet1 
       panelC.setLayout(null);
       tabbedPane.addTab("Crypter", panelC);
       panelC.setPreferredSize(new Dimension(720, 480));
       tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
       
       // Ajout des attributs au contenu de l'onglet 1 
       panelC.add(annonce);
       panelC.add(nomSourceL);
       panelC.add(nomSourceT);
       panelC.add(nomNewL1);
       panelC.add(nomNewL2);
       panelC.add(nomNewT);
       panelC.add(nbElemL);
       panelC.add(nbElem);
       panelC.add(annuler);
       panelC.add(crypter);

       

       // ONGLET DECRYPTER
       JComponent panelD = new JPanel();
       
       // Attributs
       this.annonce1 = new JLabel("Ce logiciel prend en compte uniquement les images au format JPG.");
   annonce1.setBounds(100, 60, 400, 20);
     
   this.nomSourceDecryptL = new JLabel("Nom du (premier) fichier source (\".JPG_Part0\") : ");
   nomSourceDecryptL.setBounds(100, 120, 290, 20);
   
   this.nomSourceDecryptT = new JTextField();
   nomSourceDecryptT.setBounds(390, 120, 200, 20);
   
   this.annuler1 = new JButton("Annuler");
   annuler1.setBounds(430, 200, 120, 40);
   annuler1.addActionListener(this);
   
   this.decrypter = new JButton("Décrypter");
   decrypter.setBounds(150, 200, 120, 40);
   decrypter.addActionListener(this);
       
   // Paramètres de l'onglet 2
   panelD.setLayout(null);
       tabbedPane.addTab("Décrypter", panelD);
       tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
       
       panelD.add(annonce1);
       panelD.add(nomSourceDecryptL);
       panelD.add(nomSourceDecryptT);
       panelD.add(annuler1);
       panelD.add(decrypter);
       
       
       // Ajoute les (panels) onglets au panel général -> permet l'affichage.
       add(tabbedPane);
 }


 @Override
 public void actionPerformed(ActionEvent e) {
   Object source = e.getSource();
   
   // PARTIE 1 : CRYPTER
   if(source == annuler){
     this.setVisible(false);
       this.dispose();
       
   } else if(source == crypter){ 
     
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   // PARTIE 2 : DECRYPTER
   } else if(source == annuler1){
     this.setVisible(false);
       this.dispose(); 
       
   } else if(source == decrypter){
    
   }
 }

  public static void main(String[] args) {
    Ihm c1 = new Ihm("Protection d'image");
    c1.setVisible(true);
  }

}
