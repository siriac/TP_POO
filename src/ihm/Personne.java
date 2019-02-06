/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author roosvelt
 */
public class Personne extends JFrame{
    private JLabel nomP =new JLabel();
	private JLabel prenomP =new JLabel();
	private JLabel date_naissP =new JLabel();
	private JLabel sexeP=new JLabel();
	private Dimension de = new Dimension(150, 30);
        
        protected JTextField nomPT = new JTextField();
	protected JTextField prenomPT = new JTextField();
	protected JTextField date_naissPT = new JTextField();
	protected JTextField sexePT= new JTextField();
        
        protected JButton valider= new JButton();
	protected JButton annuler = new JButton();
        
        protected JPanel panC = new JPanel();
	private JPanel panp = new JPanel();
        
        private Font fenC = new Font("Garamond", 0, 16);
	private Font fenC1 = new Font("Garamond", 1, 16);
       

    public Personne() {
        setTitle("Fen-Ajout-Cours");
		setSize(450, 300);
		setVisible(true);
		setLocationRelativeTo(null);
                initLabel();
                initChamps();
                initButton();
                initPanel();
               
    }
        
        public void initLabel()
        {
            nomP.setText("Nom");
            nomP.setPreferredSize(de);
            nomP.setFont(fenC1);
            
            prenomP.setText("Drenom");
            prenomP.setPreferredSize(de);
            prenomP.setFont(fenC1);
            
            date_naissP.setText("Date Naissance");
            date_naissP.setPreferredSize(de);
            date_naissP.setFont(fenC1);
            
            sexeP.setText("Sexe");
            sexeP.setPreferredSize(de);
            sexeP.setFont(fenC1);
            }
        public void initChamps()
        {
            nomPT.setPreferredSize(de);
            nomPT.setFont(fenC);
            
            prenomPT.setPreferredSize(de);
            prenomPT.setFont(fenC1);
           
            date_naissPT.setPreferredSize(de);
            date_naissPT.setFont(fenC1);
            
            sexePT.setPreferredSize(de);
            sexePT.setFont(fenC1);
        }
        
        public void initButton()
        {
            valider.setText("Valider");
            valider.setBackground(Color.WHITE);
            valider.setPreferredSize(de);
            valider.setFont(fenC1);
            
            annuler.setText("Annuler");
            annuler.setPreferredSize(de);
            annuler.setFont(fenC1);
            annuler.setBackground(Color.WHITE);
        }
        public void initPanel()
        {
            panC.setBackground(Color.WHITE);
            panC.setPreferredSize(new Dimension(400, 200));
            
            panC.add(nomP);
            panC.add(nomPT);
            
            panC.add(prenomP);
            panC.add(prenomPT);
            
            panC.add(date_naissP);
            panC.add(date_naissPT);
            
            panC.add(sexeP);
            panC.add(sexePT);
            
            panC.add(valider);
            panC.add(annuler);
            setContentPane(panC);
        }
        
        
}
