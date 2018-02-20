/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.interfaces;

import Entite.User;
import Service.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utile.Status;
import utile.ConnectionBD;

/**
 * FXML Controller class
 *
 * @author said hmidi
 */
public class ManageUserController implements Initializable {

    Service.ServiceUser myuser ;
    
    
    @FXML
    private TextField id;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private TextField telephone;

    @FXML
    private PasswordField password;

    @FXML
    private TextArea address;

    @FXML
    private ComboBox<String> role;

    @FXML
    private ComboBox<String> status;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TableColumn<User, String> NomColumn;

    @FXML
    private TableColumn<User,String> PrenomColumn;

    @FXML
    private TableColumn statusColumn;
    
     private ObservableList<User> data = FXCollections.observableArrayList();

    FilteredList<User> filteredData = new FilteredList<>(data, p -> true);
    User us;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
     
        
   
}
}
