/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import Connexion.MaConnexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author roosvelt
 */
public class My_Window extends JFrame {
    private JOptionPane jop_searchE=new JOptionPane();
    private JOptionPane jop_searchF=new JOptionPane();
    
    String searchFiliere=new String();
    String searchstudent=new String();
    //ma barre de menu
    private  JMenuBar barMenu=new JMenuBar();
    private JMenu etudiant=new JMenu();//menu Etudiant
    private JMenu filiere=new JMenu();//menu filiere
    private JMenu aide=new JMenu();//menu aide
    private JMenu apropos=new JMenu();//menu apropos
    private JMenu viewE=new JMenu();//menu consulter etudiant
    private JMenu viewF=new JMenu();//menu consulter filiere
    //------------------sous menu etudiant---------------------
    private JMenuItem saveE=new JMenuItem();//sous menu enregistrer etudiant
    private JMenuItem delE=new JMenuItem();//sous menu supprimer etudiant
    private JMenuItem changE=new JMenuItem();//sous menu modifier etudiant
    //private JMenuItem viewE=new JMenuItem();//sous menu consulter etudiant
    private JMenuItem searchEtu=new JMenuItem();//sous menu rechercher un etudiant
    private JMenuItem viewAllET=new JMenuItem();//sous menu liste tous les etudiants etudiant
    //------------------sous menu filiere---------------------
    private JMenuItem saveF=new JMenuItem();//sous menu enregistrer filiere
    private JMenuItem delF=new JMenuItem();//sous menu supprimer filiere
    private JMenuItem changF=new JMenuItem();//sous menu modifier filiere
    private JMenuItem searchFi=new JMenuItem();//sous menu rechercher une filiere
    private JMenuItem viewAllFi=new JMenuItem();//sous menu liste tous les filieres
    //private JMenuItem viewF=new JMenuItem();//sous menu consulter filiere
    //--------------------sous menu aide---------------------------
    private JMenuItem pdf=new JMenuItem();
    private JMenuItem html=new JMenuItem();
    private JMenuItem quit=new JMenuItem();
    //--------------------sous apropos---------------------------
    private JMenuItem builder=new JMenuItem();
    private JMenuItem interro=new JMenuItem();
    //---------------panneau------------------
    JPanel print_result=new JPanel();
    /**
     * requete par defaut pour la fenetre
     */
    private String requetViewallStudent="SELECT * FROM etudiant";
    private String viewAllFiliere="SELECT * FROM Filiere";
    public My_Window() {
        setSize(900, 700);
	    setTitle("MPS");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
             initbarMenu();
             initcontent();
             setJMenuBar(barMenu);
             this.getContentPane().add(print_result);
             setVisible(true);
    }
    public void initcontent()
    {
        print_result.setLayout(new BorderLayout());
    }
    public void initbarMenu()
    {
        saveE.setText("Enregistrer");
        /**
         action enregistrer un etudiant
         */
        saveE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Etudiant et=new Etudiant();
                
            }
        });
        delE.setText("Supprimer");
         /**
         action supprimer un etudiant
         */
        delE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //supprimer supp=new supprimer(); supprimer un etudiant
                delete_Etu(searchstudent);
            }
        });
        changE.setText("Modifier");
        changE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // Modifier change=new Modifier();//modifier les information d un etudiant
            }
        });
        viewE.setText("Consulter");
        viewE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Consulter consulE=new Consulter();
            }
        });
        etudiant.setText("Etudiant");
        etudiant.add(saveE);
        etudiant.addSeparator();
        etudiant.add(delE);
        etudiant.addSeparator();
        etudiant.add(changE);
        etudiant.addSeparator();
        etudiant.add(viewE);
        viewE.add(searchEtu);
        viewE.addSeparator();
        viewE.add(viewAllET);
        //----------Action filiere------------------------
        saveF.setText("Enregistrer");
        saveF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Filiere sauverF=new Filiere();//enregistrer filiere
            }
        });
        delF.setText("Supprimer");
        delF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //SupprimerF suppF=new SupprimerF();//supprimer une filiere
                delete_Fil(searchFiliere);
                
            }
        });
        changF.setText("Modifier");
        changF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //ModifierF modifF=new ModifierF();//modifier une filiere
            }
        });
        viewF.setText("Consulter");
        viewF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //ConsulterF consulF=new ConsulterF();//consulter une filiere
            }
        });
        aide.setText("Aide");
        quit.setText("quitter");
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                            }
        });
        aide.add(pdf);
        aide.addSeparator();
        aide.add(html);
        aide.addSeparator();
        aide.add(quit);
        viewAllET.setText("LISTE DES ETUDIANT");
        viewAllET.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                process_query(requetViewallStudent);//voir tous les etudiants
            }
        });
        searchEtu.setText("rechercher un etudiant");
        searchEtu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            search_Etudiant(searchstudent);//rechercher un etudiant
            }
        });
        viewAllFi.setText("LISTES DES FILIERES");
        viewAllFi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         process_query(viewAllFiliere);//afficher tous les filieres
            }
        });
        searchFi.setText("RECHERCHER UNE FILIERE");
        searchFi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         search_Filiere(searchFiliere);//rechercher une filiere
            }
        });
        filiere.setText("FILIERE");
        filiere.add(saveF);
        filiere.addSeparator();
        filiere.add(delF);
        filiere.addSeparator();
        filiere.add(changF);
        filiere.addSeparator();
        filiere.add(viewF);
        viewF.add(searchFi);
        viewF.addSeparator();
        viewF.add(viewAllFi);
        barMenu.add(etudiant);
        barMenu.add(filiere);
        barMenu.add(aide);
        barMenu.add(apropos);
        
    }
    public void search_Filiere(String id_fi)
    {
        String id=jop_searchF.showInputDialog(null,"Veuillez Saisir l'identifiant de la filiere","Recherche d'une filiere",JOptionPane.QUESTION_MESSAGE);
    }
    public void search_Etudiant(String id_et)
    {
        String id=jop_searchE.showInputDialog(null,"Veuillez Saisir l'identifiant de l'etudiant","Recherche d'un etudiant",JOptionPane.QUESTION_MESSAGE);
    }
    public void delete_Etu(String id)
    {
        String id_et=jop_searchE.showInputDialog(null,"Veuillez Saisir l'identifiant de l'etudiant","Suppression d'un etudiant",JOptionPane.QUESTION_MESSAGE);
        
    }
    public void delete_Fil(String searString)
    {
        String id=jop_searchF.showInputDialog(null,"Veuillez Saisir l'identifiant de la filiere","Suppression d'une filiere",JOptionPane.QUESTION_MESSAGE);
    }
    public void process_query(String queri)
    {
        try {
             Statement state=MaConnexion.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             //On exécute la requête
             ResultSet rst=state.executeQuery(queri);
             //On initialise un tableau d'Object pour les en-têtes du tableau
             ResultSetMetaData meta=rst.getMetaData();
             //On initialise un tableau d'Object pour les en-têtes du tableau
             Object[] colone=new Object[meta.getColumnCount()];
             System.out.println(meta.getColumnCount());
             for(int i=1;i<=meta.getColumnCount();i++)
             {
                 colone[i-1]=meta.getColumnName(i);
                 System.out.println(colone[i-1]);
             }
             
             //Petite manipulation pour obtenir le nombre de lignes
           rst.last();//deplace le curseur a la derniere ligne 
             int nbre_ligne=rst.getRow();//retourne le nombre de ligne parcourut jusqu a la position du curseur
             Object[][] data=new Object[rst.getRow()][meta.getColumnCount()];
             //On revient au départ
             rst.beforeFirst();
	      int j = 1;//la premiere ligne est a la position 1
              //On remplit le tableau d'Object[][]
              while(rst.next())
              {
                  for(int i=1;i<=meta.getColumnCount();i++)
                  {
                      data[j-1][i-1]=rst.getObject(i);//on fixe la ligne on parcourt les colones;
                      //resultset ressamble a un tableau de tableau tab[tab1[]] donc un element tab1 est accessible
                      //par la methode getObject(i)
                      System.out.println(data[j-1][i-1]);
                     }
                  j++;//on passe a la lignes suivante
                  
              }
              //On ferme le tout 
              rst.close();
              state.close();
              print_result.add(new JScrollPane(new JTable(data,colone)));
              print_result.add(new JLabel("la requete contient "+nbre_ligne+"enregistrement(s)"),BorderLayout.SOUTH);
              //On force la mise à jour de l'affichage
              print_result.revalidate();
              
              

              
        } catch (SQLException e) {
            //Dans le cas d'une exception, on affiche une pop-up et on efface le contenu
            if(e.getSQLState()==null)
            {
                JLabel ne=new JLabel("Operation terminer avec succès");
                print_result.removeAll();
                print_result.add(ne);
                print_result.revalidate();
            }else
            {
                JLabel ne=new JLabel(e.getMessage());
                ne.setForeground(Color.red);
                print_result.removeAll();
                print_result.add(ne);
                print_result.revalidate();
            }
        }
    }
}   

