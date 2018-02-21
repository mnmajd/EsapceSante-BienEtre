
package GUI.admin;


import com.jfoenix.controls.JFXTextField;

import entites.User;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import services.UserDAO;
import utile.Mail;
import utile.UserStatus;

/**
 * FXML Controller class
 *
 * @author oualha
 */
public class ManageUserController implements Initializable {

    UserDAO userDAO;

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TextField id;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextArea address;
    @FXML
    private TextField telephone;
    @FXML
    private ComboBox<String> role;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ImageView add;
    @FXML
    private ImageView edit;
    @FXML
    private ImageView delete;

    @FXML
    TableColumn statusColumn;
   
    @FXML
    private JFXTextField tfSearch;
        private ObservableList<User> data = FXCollections.observableArrayList();

    FilteredList<User> filteredData = new FilteredList<>(data, p -> true);
    User us;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usersTable.setEditable(true);
        
  userDAO = new UserDAO();
        role.setItems(FXCollections.observableArrayList(
                "Choisissez un role...",
                "Membre",
                "Medecin",
                "Coach",
                "Admin"
        ));
        
         status.setItems(FXCollections.observableArrayList(
                "Choisissez une status...",
                UserStatus.ACTIVE,
                UserStatus.BLOCKED,
                UserStatus.DELETED,
                UserStatus.PENDING,
                UserStatus.REFUSED
        ));
         
        usersTable.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, oldValue, newValue) -> { 
                    if (newValue != null) {
                        User selectedUser = (User) newValue;
                        if (selectedUser.getRole().toLowerCase().equals("admin")) {
                            clearFields();
                            return;
                        }
                        id.setText(String.valueOf(selectedUser.getId()));
                        firstname.setText(selectedUser.getFirstname());
                        lastname.setText(selectedUser.getLastname());
                        username.setText(selectedUser.getUsername());
                        password.setText(selectedUser.getPassword());
                        email.setText(selectedUser.getEmail());
                        address.setText(selectedUser.getAdress());
                        role.setValue(selectedUser.getRole());
                        status.setValue(selectedUser.getStatus());

                        edit.setDisable(false);
                        delete.setDisable(false);
                    } else {
                        clearFields();
                    }
                });
        statusColumn.setCellFactory(column -> {
            return new TableCell<User, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.toString());
                    }

                    TableRow<User> currentRow = getTableRow();

                    if (!isEmpty()) {
                        String style = "-fx-accent: derive(-fx-control-inner-background, -40%); "
                                + "-fx-cell-hover-color: derive(-fx-control-inner-background, -20%);";
                        switch (item) {
                            case UserStatus.PENDING:
                                style += "-fx-control-inner-background: lightyellow;";
                                break;
                            case UserStatus.ACTIVE:
                                style += "-fx-control-inner-background: palegreen;";
                                break;
                            case UserStatus.BLOCKED:
                                style += "-fx-control-inner-background: darkslategray;";
                                break;
                            case UserStatus.DELETED:
                            case UserStatus.REFUSED:
                                style += "-fx-control-inner-background: crimson;";
                                break;
                        }
                        currentRow.setStyle(style);
                    }
                }

                @Override
                public void updateSelected(boolean updated) {
                    super.updateSelected(updated);
                }

                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        //usersTable.getItems().addAll(userDAO.findAll());
        refreshTable();
    }    

    @FXML
    private void userAdd(MouseEvent event) {
         if (usersTable.getSelectionModel().getSelectedItem() != null) {
            usersTable.getSelectionModel().clearSelection();
            edit.setDisable(true);
            delete.setDisable(true);
            clearFields();
            return;
        }

        if (userDAO.checkUsername(username.getText())) {
            PseudoClass pseudoClass = PseudoClass.getPseudoClass("error");
            username.pseudoClassStateChanged(pseudoClass, true);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Utilisateur existe deja!");
            alert.setHeaderText(username.getText());
            alert.setContentText("Ce nom d'utilisateur existe deja");
            alert.showAndWait();
            return;
        } else {
            User user = new User();
            

            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setEmail(email.getText());
            user.setFirstname(firstname.getText());
            user.setLastname(lastname.getText());
            user.setAdress(address.getText());
            user.setTelephone(telephone.getText());
            user.setRole(role.getValue());
            user.setStatus(status.getValue());

            userDAO.add2(user);
            refreshTable();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setContentText("Utilisateur inserer avec success!");
            alert.showAndWait();
        }
    }

    @FXML
    private void userEdit(MouseEvent event) {
         if (usersTable.getSelectionModel().getSelectedItem() != null && !id.getText().isEmpty()) {
            if (userDAO.checkUsername(username.getText(), Integer.parseInt(id.getText()))) {
                PseudoClass pseudoClass = PseudoClass.getPseudoClass("error");
                username.pseudoClassStateChanged(pseudoClass, true);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Utilisateur existe deja!");
                alert.setHeaderText(username.getText());
                alert.setContentText("Ce nom d'utilisateur existe deja");
                alert.showAndWait();
                return;
            }
            User user = new User();
           

            user.setId(Integer.parseInt(id.getText()));
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setEmail(email.getText());
            user.setFirstname(firstname.getText());
            user.setLastname(lastname.getText());
            user.setAdress(address.getText());
            user.setTelephone(telephone.getText());
                        user.setRole(role.getValue());

            user.setStatus(status.getValue());
             System.out.println("aaaaaa"+user.getRole());
                          System.out.println("aaaaaa"+user.getTelephone());

            userDAO.update(user);
            if (!user.getStatus().equals(usersTable.getSelectionModel().getSelectedItem().getStatus())) {
                Mail.sendMail(user.getEmail(), "Compte Espace sante", "Votre compte chez Espace sante est: " + user.getStatus());
           }

            clearFields();
            refreshTable();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setContentText("Utilisateur modifier avec success!");
            alert.showAndWait();
        }
    }

    @FXML
    private void userDelete(MouseEvent event) {
        if (usersTable.getSelectionModel().getSelectedItem() != null && !id.getText().isEmpty()) {
           
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Success!");
//            alert.setContentText("Utilisateur supprimer avec success!");
//            alert.showAndWait();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmez votre choix");
        alert.setContentText("voulez vous vraiment supprimer cet utilisateur ?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Supression");
            alert1.setHeaderText(null);
            alert1.setContentText("Supression effectuée avec succes !");
            
            alert1.showAndWait();
            
            userDAO.delete(usersTable.getSelectionModel().getSelectedItem());
            clearFields();
            refreshTable();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

        }
    }
    
      public void clearFields() {
        id.clear();
        username.clear();
        password.clear();
        role.setValue("Choisissez un role...");
        firstname.clear();
        lastname.clear();
        email.clear();
        address.clear();
        telephone.clear();
        role.setValue("Choisissez un role..");
        status.setValue("Choisissez une status...");
    }

    public void refreshTable() {
        usersTable.getItems().clear();
        usersTable.getItems().addAll(userDAO.findAll());
        usersTable.refresh();
    }

    @FXML
    private void serachUser(KeyEvent event) {
        
        usersTable.getItems().clear();
        usersTable.refresh();
        usersTable.getItems().addAll(userDAO.findAll2(tfSearch.getText()));
           

    }
      
    
}

