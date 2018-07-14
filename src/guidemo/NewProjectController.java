/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AMMAR
 */
public class NewProjectController implements Initializable {

    @FXML private Button btn_Finish;
    @FXML private Button btn_Cancel;
    
    
    
    
    public boolean finished = false;
    
    
    @FXML public void finishClick(ActionEvent e) {
        finished = true;
        Stage stage = (Stage) btn_Finish.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    @FXML public void cancelClick(ActionEvent e) {
    // get a handle to the stage
    Stage stage = (Stage) btn_Cancel.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
