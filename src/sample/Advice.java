package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Advice {
    private Image image;
    private ImageView imageView;
    private StackPane s = new StackPane();
    public Advice() {
        this.image = new Image("file:../images/chars/advice.jpeg");
        this.imageView = new ImageView(this.image);
        s.getChildren().add(imageView);
    }
}
