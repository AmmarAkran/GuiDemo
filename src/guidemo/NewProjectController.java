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

/**
 * FXML Controller class
 *
 * @author AMMAR
 */
public class NewProjectController implements Initializable {

    @FXML private Button btn_Finish;
    @FXML private Button btn_Cancel;
    
    
    @FXML public void finishClick(ActionEvent e) {
        
    }
    
    @FXML public void cancelClick(ActionEvent e) {
       Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
