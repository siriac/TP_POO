/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import Connexion.MaConnexion;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author roosvelt
 */
public class Etudiant extends Personne{
    
    public JLabel matricule=new JLabel();
    public JLabel filiere=new JLabel();
    
    public JTextField matriculeT=new JTextField();
    public JTextField filiereT=new JTextField();
    public JPanel panF=new JPanel();
    
    public Etudiant()
    {
        super();
        initLabelP();
        initChampP();
        initBouton();
       initPanelP();
    }
    public void initLabelP()
    {
        super.initLabel();
        matricule.setText("Matricule");
        matricule.setPreferredSize(new Dimension(150,30));
        matricule.setFont(new Font("Garamond", 1, 16));
        
        filiere.setText("Filiere");
        filiere.setPreferredSize(new Dimension(150,30));
        filiere.setFont(new Font("Garamond", 1, 16));
    }
    
    public void initChampP()
    {   super.initChamps();
        matriculeT.setPreferredSize(new Dimension(150,30));
        matriculeT.setFont(new Font("Garamond", 0, 16));
        
        filiereT.setPreferredSize(new Dimension(150, 30));
        filiereT.setFont(new Font("Garamond", 0, 16));
        
    }
    
    public void initBouton()
    {
      super.valider.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              String no=nomPT.getText();
              String pnom=prenomPT.getText();
              String sex=sexePT.getText();
              String mat=matriculeT.getText();
              String fi=filiereT.getText();
              String dn=date_naissPT.getText();
              String requete="INSERT INTO etudiant VALUES('"+mat+"','"+no+"','"+fi+"','"+pnom+"','"+sex+"','"+dn+"')";
              Statement state;
              if(mat.matches("([0-9]{2}[A-Z]{1}[0-9]{4})"))
              {
              try {
                  state= MaConnexion.getInstance().createStatement();
                  int res=state.executeUpdate(requete);
                  if(res!=0)
                  {
                      setVisible( false) ;
		   JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
                  }
                 setVisible( false) ;
					state.close();
              } catch (SQLException er) {
                  JOptionPane.showMessageDialog(null, er.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
				er.printStackTrace();
              }
              }else JOptionPane.showMessageDialog(null, "Matricule Invalid", "Fatal Error", JOptionPane.INFORMATION_MESSAGE);

          }
      });
      super.annuler.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
          }
      });
    }
    public void initPanelP()
    {
        
        panC.add(matricule);
        panC.add(matriculeT);
        panC.add(filiere);
        panC.add(filiereT);
        super.initPanel();
        setContentPane(panC);
        
    }
}
