package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Game extends Application {


    private int level;
    private Parent pane;
    private Scene scene;
    public Game(int level,Parent pane,ActionEvent event) {
        System.out.println("Game Started");
        this.level = level;
        this.pane = pane;

        Scene secondScene = new Scene(this.pane);
        this.scene = secondScene;
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(secondScene);
        window.show();
        //this.animate();
    }

    @Override
    public void start(Stage primaryStage) {

    }

    private void setLevel() {
        if(this.level >=1 && this.level <= 4) {
            this.level++;
        }
        else {
            System.out.println("You Won!!");
        }
    }
}
