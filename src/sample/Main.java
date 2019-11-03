package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.io.IOException;

public class Main extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        Scene scene = new Scene(root);

        String path = Main.class.getResource("themeSong.mp3").toString();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        System.out.println(path);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
