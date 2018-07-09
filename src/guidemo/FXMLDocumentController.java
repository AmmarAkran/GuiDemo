
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author AMMAR
 */
public class FXMLDocumentController implements Initializable {
    
    //These items are for CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox cheeseCheckBox;
    @FXML private CheckBox meatCheckBox;
    @FXML private CheckBox chickenCheckBox;
    
    //These items for ChoiceBox example
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;
    
    /**
     * This will update the label for the chicebox
     */
    public void choiceBoxButtonPushed()
    {
        choiceBoxLabel.setText("My favourite fruit is\n"+choiceBox.getValue().toString());
    }
    
    /**
     * This is for checkbox example
    */
    public void pizzaOrderButtonPushed(){
        String order = "Topping are:";
        if (cheeseCheckBox.isSelected())
            order += "\nCheese";
        if (meatCheckBox.isSelected())
            order += "\nMeat";
        if (chickenCheckBox.isSelected())
            order += "\nChicken";
        this.pizzaOrderLabel.setText(order);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pizzaOrderLabel.setText("");
        
        //This items are for configuring the choiceBox example
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Dates");
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().addAll("Oranges","peaches","Strawberries");
        choiceBox.setValue("Bananas");
            
        
    }    
    
}
