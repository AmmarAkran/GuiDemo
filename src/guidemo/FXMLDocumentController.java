
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

/**
 *
 * @author AMMAR
 */
public class FXMLDocumentController implements Initializable {
    
    //These items are for CheckBox example
    @FXML private MenuItem newItem;
    @FXML private MenuItem openItem;
    @FXML private MenuItem saveItem;
    @FXML private MenuItem saveAsItem;
    @FXML private MenuItem closeItem;
    
    @FXML public void newClick(ActionEvent e) {
        
    }
    
    @FXML public void openClick(ActionEvent e) {
        
    }
    
    @FXML public void saveClick(ActionEvent e) {
        
    }
    
    @FXML public void saveAsClick(ActionEvent e) {
        
    }
    
    @FXML public void closeClick(ActionEvent e) {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }    
}
