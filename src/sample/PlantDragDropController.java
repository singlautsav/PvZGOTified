package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PlantDragDropController implements Initializable {

    @FXML
    private ImageView plant;

    @FXML
    private ImageView plant2;

    @FXML
    private GridPane battlefield;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleDragDetected(MouseEvent event) {
        Dragboard db = plant.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(plant.getImage());
        db.setContent(cb);
        event.consume();
        System.out.println("Drag detected");
    }

    @FXML
    public void handleDragOver(DragEvent event) {
        System.out.println("hi");
        if(event.getGestureSource()!= plant && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    public void handleDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if(db.hasImage()) {
            ImageView plant2 = new ImageView(db.getImage());
            battlefield.getChildren().add(plant2);
        }
        event.consume();
    }
}
