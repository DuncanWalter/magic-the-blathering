package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Button testButton1; //Become initialized during runtime through injection after the initialize method is called
    @FXML
    Button testButton2;
    @FXML
    TextArea textArea;

    /**
     * Called before the view loads. This method is used to setup any logic or changes to FX Components.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testButton1.setOnAction(event -> testButton1Action()); //Lamda function that passes the event call to testButton1Action()
        testButton2.setOnAction(event -> setTestButton2Action());
    }

    public void testButton1Action(){
        System.out.println("Test Button 1 Pressed");
    }

    public void setTestButton2Action(){
        System.out.println("Text Area Contents:" + textArea.getText());
    }
}
