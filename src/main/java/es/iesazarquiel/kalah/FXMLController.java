package es.iesazarquiel.kalah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {
    private Match currentMatch;
    
    @FXML private VBox root;
    @FXML private ToggleGroup cpuVS;
    @FXML private RadioMenuItem cpuVScpu;
    @FXML private RadioMenuItem cpuVShuman;
    
    private Scene scene = root.getScene();
    
    @FXML
    private void createNewMatch(ActionEvent event) {
        currentMatch = new Match();
        // RadioMenuItem selectedItem = (RadioMenuItem) cpuVS.getSelectedToggle();
        // currentMatch.setVsHuman(selectedItem.equals(cpuVShuman));
        new MatchHandler(this).createTask();
    }
    
    @FXML
    private void closeApp(ActionEvent event) {
        Platform.exit();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    protected void setSeedLabel(Integer id, String value) {
        try {
            Label label = (Label) scene.lookup("#seed" + id);
            label.setText(value);
        } catch (Exception e) {
            System.out.println("Whoops!!! " + e.getLocalizedMessage());
        }
    }
    
    protected void setHouseLabel(Integer id, Integer value) {
        try {
            if (id >= 1 && id <= 12) {
                Label label = (Label) scene.lookup("#seed" + id);
                label.setText(Integer.toString(value));
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("Whoops!!! " + e.getLocalizedMessage());
        }
    }
    
    protected Match getCurrentMatch() {
        return currentMatch;
    }
}
