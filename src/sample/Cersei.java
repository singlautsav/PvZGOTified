package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cersei implements Monster {

    private Image image;
    private ImageView imageView;
    StackPane s = new StackPane();
    private int attack;
    private int health;
    private int speed;

    public Cersei() {
        image = new Image("file:../images/chars/cersie.png");
        imageView = new ImageView(image);
        s.getChildren().add(imageView);
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void move() {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void removeImage() {
        this.s.getChildren().remove(this.imageView);
    }
}

