package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GridPlaneController implements Initializable {
    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StackPane sourcePane = new StackPane(new Text("Source"));
        StackPane targetPane = new StackPane(new Text("Target"));

        sourcePane.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = sourcePane.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString("Hello!");
                db.setContent(content);
                System.out.println("Drag detected");
                event.consume();
            }
        });


        targetPane.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
                System.out.println("Drag over detected");
                event.consume();
            }
        });

        targetPane.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
                System.out.println("Drop detected");
                event.consume();
            }
        });

        grid.add(sourcePane, 1, 1);
        grid.add(targetPane, 0, 1);
    }
}
