package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void changeScreen(ActionEvent event) throws IOException {
        Parent secondPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene secondScene = new Scene(secondPane);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(secondScene);
        window.show();
    }

}
