package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
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

    @FXML
    private StackPane stX;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private Button menuBut;

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
        if(event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            System.out.println("here");
        }
        event.consume();
    }

    @FXML
    public void handleDrop(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
        Dragboard db = event.getDragboard();

//        Node node = event.getPickResult().getIntersectedNode();
        System.out.println("hello");
//
//
//        stX.getChildren().add(plant2);
//        Integer c = battlefield.getColumnIndex(node);
//        Integer r = battlefield.getRowIndex(node);
//        int x = c;
//        int y = r;
        ImageView plant2 = new ImageView(db.getImage());
        plant2.setFitHeight(100);
        plant2.setFitWidth(60);
//        Integer r =
//        battlefield.add(plant2,x,y,1,1);
        battlefield.add(plant2,2,2,1,1);

        event.setDropCompleted(true);
        event.consume();
        System.out.println("Dropped");

    }

    @FXML
    private void firstItemAction(ActionEvent event) {
    }

    @FXML
    private void secondItemAction(ActionEvent event) {
        System.exit(-1);
    }

}
