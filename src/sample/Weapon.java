package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Weapon {
    private int speed;
    private Image image;
    private ImageView imageView;
    private StackPane s = new StackPane();

    public Weapon() {
        this.image = new Image("file:../images/chars/sword.jpeg");
        imageView = new ImageView(this.image);
        s.getChildren().add(this.imageView);
    }

    public void removeImage() {
        this.s.getChildren().remove(this.imageView);
    }
}
