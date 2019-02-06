/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import Connexion.MaConnexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author roosvelt
 */
public class Filiere extends JFrame{
    private JLabel cde_fil=new JLabel();
    private JLabel libel=new JLabel();
    
    private JTextField cde_filT=new JTextField();
    private JTextField libelF=new JTextField();
    
    private JButton valid=new JButton();
    private JButton annul=new JButton();
    
    private JPanel panFilier=new JPanel();
    
    private Font fC = new Font("Garamond", 0, 16);
	private Font fC1 = new Font("Garamond", 1, 16);
        
      private Dimension de = new Dimension(150, 30);
    public Filiere() throws HeadlessException {
        
        setTitle("Fen-Ajout-Cours");
		setSize(450, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		initLabel();
		initChamps();
		initButton();
		initPanel();
    }
    
    public void initLabel()
    {
        cde_fil.setText("Code Filiere");
        cde_fil.setPreferredSize(de);
        cde_fil.setFont(fC1);
        
        libel.setText("Libele");
        libel.setPreferredSize(de);
        libel.setFont(fC1);
    }
    public void initChamps()
    {
        cde_filT.setPreferredSize(de);
        cde_filT.setFont(fC);
        
        libelF.setPreferredSize(de);
        libelF.setFont(fC);
    }
    
    public void initButton()
    {
        valid.setText("Valider");
        valid.setPreferredSize(de);
        valid.setBackground(Color.WHITE);
        valid.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cd=cde_filT.getText();
                 String lib=libelF.getText();
                 if(cd.matches("([a-zA-Z]{3,4})"))
                 {
                 String req="INSERT INTO Filiere VALUES('"+cd+"','"+lib+"')";
                 Statement stete;
                 try {
                    stete=MaConnexion.getInstance().createStatement();
                    int res=stete.executeUpdate(req);
                    if(res!=0){
				 //state.execute(requete);
					setVisible( false) ;
					JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
					}
				 //state.execute(requete);
					setVisible( false) ;
					//res.close();
					stete.close();
                } catch (SQLException et) {
                                      JOptionPane.showMessageDialog(null, et.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
				et.printStackTrace();

                }
                 }
                 else JOptionPane.showMessageDialog(null, "Code filiere invalide", "erreur", JOptionPane.INFORMATION_MESSAGE);

               
            }
        });
        annul.setText("annuler");
        annul.setPreferredSize(de);
        annul.setFont(fC);
        annul.setBackground(Color.WHITE);
        annul.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public void initPanel()
    {
        panFilier.setBackground(Color.white);
        panFilier.setPreferredSize(new Dimension(400, 200));
        panFilier.setBorder(BorderFactory.createTitledBorder("Enregistrer Une Nouvelle Filiere"));
        panFilier.add(cde_fil);
        panFilier.add(cde_filT);
        panFilier.add(libel);
        panFilier.add(libelF);
        panFilier.add(valid);
        panFilier.add(annul);
        setContentPane(panFilier);
    }
}
