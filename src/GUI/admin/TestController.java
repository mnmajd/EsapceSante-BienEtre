
package GUI.admin;

import entites.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.UserDAO;


public class TestController implements Initializable {

    @FXML
    private TableView<User> usersTable;
    UserDAO userDAO = new UserDAO();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      refreshTable();
    }   
    
    public void refreshTable() {
        usersTable.getItems().clear();
        usersTable.getItems().addAll(userDAO.findAll());
        usersTable.refresh();
    }
}
