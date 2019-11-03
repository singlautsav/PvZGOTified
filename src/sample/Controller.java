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

        final Node source = (Node)event.getSource();

        String id = source.getId();

        //System.out.println(id);

        Parent secondPane = FXMLLoader.load(getClass().getResource("playScreen.fxml"));

        if(id.equals("loadGame")) {
            //System.out.println("loadBut");
            secondPane = FXMLLoader.load(getClass().getResource("AboutScreen.fxml"));
        }

        else if(id.equals("exit")) {
            System.exit(0);
        }

        Scene secondScene = new Scene(secondPane);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(secondScene);
        window.show();
    }

}
