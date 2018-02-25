/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionUtil;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class ConnexionDB {
    private String url = "jdbc:mysql://localhost:3306/espace_sante";
    private String login = "root";
    private String password = "";
    private Connection connection;
    private static ConnexionDB dataSource;

    private ConnexionDB() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnexionDB getInstance() {
        if (dataSource == null) {
            dataSource = new ConnexionDB();
        }
        return dataSource;
    }
    
}