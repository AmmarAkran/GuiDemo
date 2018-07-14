
package guidemo;

import code.Settings;
import code.XMLReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AMMAR
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private MenuItem newItem;
    @FXML private MenuItem openItem;
    @FXML private MenuItem saveItem;
    @FXML private MenuItem saveAsItem;
    @FXML private MenuItem closeItem;
    @FXML private ListView listView;
    @FXML private TextField filePath;
    @FXML private RadioButton machineLearning;
    @FXML private RadioButton deepLearning;
    @FXML private ProgressBar progressBar;
    @FXML private Button btn_nex;
    @FXML private Button btn_pre;
    @FXML private TabPane tabPane;
    @FXML private Tab featureEx;
    @FXML private AnchorPane rootPane;
    
    
     public Settings settings;
    @FXML public void newClick(ActionEvent e) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("NewProject.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("New Project");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
   
    
    
    @FXML public void openClick(ActionEvent e) {
        
    }
    
    @FXML public void saveClick(ActionEvent e) {
        String filename = "settings.cfg";
        Settings.storeSettings(settings, filename);
    }
    
    @FXML public void saveAsClick(ActionEvent e) {
        
    }
    
    @FXML public void closeClick(ActionEvent e) {
        Platform.exit();
    }
    
    @FXML public void openFileClick(ActionEvent e) throws IOException{
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose the file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml"),
                new FileChooser.ExtensionFilter("All files..", "*.*"));
        String currentDir = "C:\\Users\\AMMAR\\Documents\\NetBeansProjects\\GuiDemo\\data";
        File file = new File(currentDir);
        fileChooser.setInitialDirectory(file);
        File selectedFile = fileChooser.showOpenDialog(stage);
//        FileReader FR = new FileReader(selectedFile.getAbsolutePath().toString());
        if (selectedFile != null) {
                String fileAsString = selectedFile.getPath();
                settings.setInputFilePath(fileAsString);
                filePath.setText(fileAsString);
                try {
                    listView.getItems().clear();
                    XMLReader reader = new XMLReader(fileAsString);
                    for(int i = 0;i < reader.sentences.size();i++) {
                        listView.getItems().add(reader.sentences.get(i).attr("id") + ":" + reader.sentences.get(i).select("text").first().text());
                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                    
                }
            } else {
                filePath.setText(null);
            }     
    }
    
    @FXML public void progressBarButtonClick(ActionEvent e) {
        IteratingTask task = new IteratingTask(100);
        progressBar.progressProperty().bind(
                task.progressProperty()
        );
        new Thread(task).start();
    }
    
    public class IteratingTask extends Task<Integer> {
         private final int totalIterations;

         public IteratingTask(int totalIterations) {
             this.totalIterations = totalIterations;
         }

         @Override 
         protected Integer call() throws Exception {
             int iterations = 0;
             for (iterations = 0; iterations < totalIterations; iterations++) {
                 if (isCancelled()) {
                     updateMessage("Cancelled");
                     break;
                 }
                 Thread.sleep(100);
                 updateMessage("Iteration " + iterations);
                 updateProgress(iterations, totalIterations);
             }
             return iterations;
         }
     }
    
    @FXML public void nextClick(ActionEvent e) {
        tabPane.getSelectionModel().select(featureEx);
    }
     
//    @FXML public void newClick(ActionEvent e) {
//        From f = new Form();
//        Dilogresult  = f.showDialog();
//        if(dialogresult == OK) {
//            f.projectName;
//            f.projectPath;
//            File file = new File(f.project + "\\" + f.path);
//            file.store();
//        }
        
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        this.settings = new Settings();
        final ToggleGroup group = new ToggleGroup();

        machineLearning.setToggleGroup(group);
        machineLearning.setSelected(true);

        deepLearning.setToggleGroup(group);
    }    
}
