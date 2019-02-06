/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author roosvelt
 */
public class MaConnexion {
   // private static String url="jdbc:postgres://localhost:5342:etudiant_filiere;user=takam;password=azerty";
            private static Connection connect;
            
            public static Connection getInstance()
            {String url = "jdbc:postgresql://localhost:5432/etudiant_filiere";
            String user = "postgres";
            String passwd = "azerty";
                if(connect ==null)
                {
                    try {
                        connect=DriverManager.getConnection(url,user,passwd);
                    } catch (SQLException e) 
                    {
                        JOptionPane.showMessageDialog(null, "Erreur lors de létablissement de la connexion à la base de données\n Code erreur: "+e.getErrorCode(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                System.out.println("connexion effective");
                }
                return connect;
            }
                    
}
