/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Service.QuestionService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class VerifyQuestionAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField sujetTxt;

    @FXML
    private TextArea ContenuQuestion;
    @FXML
    private ListView<Question> listQuestion;
     static int  id_question ;
     static int id_user ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
// TODO
   

    ObservableList<Question> data = FXCollections.observableArrayList(
             QuestionService.getInstance().ReadQuestion()
                  
            
          );
          listQuestion.getItems().addAll(data);
          listQuestion.setCellFactory(new Callback<ListView<Question>, ListCell<Question>>()
                  {
              @Override
              public ListCell<Question> call(ListView<Question> param) {
                  return new ListCell<Question>()
                  {
                      @Override
                      protected void updateItem(Question item, boolean empty) {
                          super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                       if ( item != null)
                       { 
                           Text text = new Text(item.getNom()+" "+item.getPrenom()+" a envoyé une question");
                           setGraphic(text);
                       
                       }
                      }
                     
                  };
              }
                    
                  }
          );
          
          
          listQuestion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Question> () {
                  @Override
                  public void changed(ObservableValue<? extends Question> observable, Question oldValue, Question newValue) {
                       try {
                           id_question = newValue.getId_question();
                         sujetTxt.setText( newValue.getSujet_question()); 
                           ContenuQuestion.setText(newValue.getContenu_question());

                      } catch (Exception e) {
                           System.out.println(e);
                      }
                  }
              });
          
          


    }
     public void ApproveQuestion()
          {
              try {
                QuestionService.getInstance().ApproveQuestion(id_question);

              } catch (Exception e) {
                  System.out.println(e);
              }
              try {
			// Construct data
			String apiKey = "apikey=" + "vB/jqlLaluw-fsiqKzQ8F6WW5CNMWYdFMlZsvmrdIO";
			String message = "&message=" + "Votre Message dans notre espace santé est approuve";
			String sender = "&sender=" + "Espace Santé";
			String numbers = "&numbers=" + "0021655215220";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
//			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
//			return "Error "+e;
		}
              
              
              
          }    
    
}
