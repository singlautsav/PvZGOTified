package sample;

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

public class Game {

    private int level;
    private Parent pane;
    private Scene scene;
    Game(int level,Parent pane,ActionEvent event) {
        System.out.println("Game Started");
        this.level = level;
        this.pane = pane;

        Scene secondScene = new Scene(this.pane);
        this.scene = secondScene;
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();

        window.setScene(secondScene);
        window.show();

        this.setCharacters();
    }

    private void setLevel() {
        if(this.level >=1 && this.level <= 4) {
            this.level++;
        }
        else {
            System.out.println("You Won!!");
        }
    }

    private void setCharacters() {
        System.out.println("Setting Characters");
        HBox hb = (HBox) this.scene.lookup("#sideBar");
        Image image = new Image("file:../images/chars/johnSnow.png");
       // System.out.println(image);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        hb.getChildren().add(imageView);
        System.out.println("Done");
    }
}
