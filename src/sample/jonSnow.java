package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class jonSnow implements Plant {

    final private String name = "JonSnow";
    private int attack = 100;
    private int cost = 100;
    private int health = 100;
    private Image image;
    private ImageView imageView;
    StackPane s = new StackPane();

    public jonSnow() {
        this.image = new Image("file:../images/chars/johnSnow.png");
        this.imageView = new ImageView(this.image);
        s.getChildren().add(imageView);
        //s.setTranslateY();
        //s.setTranslateX();
    }

    public void removeImage() {
        this.s.getChildren().remove(this.imageView);
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attack) {
        this.attack = attack;
    }

    public int getAttackPower() {
        return this.attack;
    }

    public String getPlantName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}


