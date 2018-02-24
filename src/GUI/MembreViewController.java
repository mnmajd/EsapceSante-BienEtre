
package GUI;
import Utils.Upload;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

import Service.UserDAO;

public class MembreViewController implements Initializable {

    @FXML
    private ImageView photo;
    @FXML
    private Pane chnager;
    @FXML
    private AnchorPane content;
    File file;
    @FXML
    private Label currentUser;
    @FXML
    private ImageView newslater;
    Upload up =new Upload();
    UserDAO userDAO=new UserDAO();
    @FXML
    private ImageView mark;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //mark.setVisible(false);
        
        currentUser.setText(EspaceSanteBienEtre.currentUser.getFirstname()+"  "+EspaceSanteBienEtre.currentUser.getLastname());
        chnager.setOnMouseEntered((MouseEvent event)->
                {
                    chnager.setVisible(true);
                });
         chnager.setOnMouseExited((MouseEvent event)->
                {
                    chnager.setVisible(false);
                });
         photo.setOnMouseEntered((MouseEvent event)->
                {
                    chnager.setVisible(true);
                });
         photo.setOnMouseExited((MouseEvent event)->
                {
                    chnager.setVisible(false);
                });
       
    File file = new File("C:\\Users\\said hmidi\\Desktop\\Piedev\\EspaceSante&BienEtre\\image\\"+EspaceSanteBienEtre.currentUser.getAvatar());
    Image image = new Image(file.toURI().toString());
    photo.setImage(image);
    
    }    


    @FXML
    private void apropo(MouseEvent event) throws IOException {
         Parent parent = FXMLLoader.load(getClass().getResource("modifier.fxml"));
        parent.setStyle("-fx-box-border: transparent;");
        content.getChildren().clear();
        content.getChildren().add(parent);
        AnchorPane.setTopAnchor(parent, 0d);
        AnchorPane.setRightAnchor(parent, 0d);
        AnchorPane.setBottomAnchor(parent, 0d);
        AnchorPane.setLeftAnchor(parent, 0d);
    }

    @FXML
    private void photochange(MouseEvent event) 
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.jpg", "*.JPG", "*.png");
        fileChooser.getExtensionFilters().addAll(extFilter);
        file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);

            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            photo.setImage(image);
            up.upload(file);
            userDAO.update_photo(file.getName(), EspaceSanteBienEtre.currentUser.getId());
        } catch (IOException ex) {
           
        } 
    }

    
/*
    @FXML
    private void newslater(MouseEvent event) {
        newslater.setDisable(true);
        mark.setVisible(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Newsletter!");
        alert.setContentText("Votre inscription a notre newsletter et terminé avec success!");
        alert.showAndWait();
    }
*/
   
    
    
    
    @FXML
    private void logout(MouseEvent event) {
         EspaceSanteBienEtre.logout(); 
    }
    
}
