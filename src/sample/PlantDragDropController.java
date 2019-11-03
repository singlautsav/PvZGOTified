package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PlantDragDropController  implements Initializable  {


    public class TransitionXX extends Thread{

        StackPane st = new StackPane();

        public void moveSword(StackPane st){
            st.setLayoutX(st.getLayoutX()+1);
        }


        public void move() {

            AnimationTimer timer = new AnimationTimer() {


                @Override
                public void handle(long now) {
                    int pX = 0;
                    int pY = 0;

//                System.out.println("moving diver right!");
//                monster1.setX(monster1.getX() - .5);
                    monster2.setX(monster2.getX()- 1);
//                System.out.println(monster2.getLayoutX());
                    try {
//                    System.out.println(plant2.getLayoutX());
//                    System.out.println("Hiii");
                        Bounds boundsPlant1 = plant2.localToScreen(plant2.getBoundsInLocal());
//                        Bounds bounds = plant2.localTo
                        pX = (int) boundsPlant1.getMinX();
                        pY = (int) boundsPlant1.getMinY();
//                    System.out.println(pX);
                        if (!checkX) {
//                            System.out.println("hi");
                            swordX.setFitWidth(100);
                            swordX.setFitHeight(20);
//                            anchor.getChildren().add(swordX);

                            st.getChildren().add(swordX);
                            anchor.getChildren().add(st);
                            st.setTranslateX(dropValX+130);
                            st.setTranslateY(491-20);
//                            battlefield.add(swordX,2,2);
//                            swordX.setX(swordX.getX()-1);
//                            moveSword(st);
                            checkX =true;
                        }
                        else {
                            moveSword(st);
                        }
                    }
                    catch (Exception e){
//                        System.out.println(e.getMessage());
                    };
//                System.out.println(plant.getY());


                    Bounds boundsMonster1 = monster2.localToScreen(monster2.getBoundsInLocal());
                    int mX = (int) boundsMonster1.getMinX();
                    int mY = (int) boundsMonster1.getMinY();

                    if (pX == mX) {

//                        System.out.println("hello");
                        monster2.setImage(null);
//                        battlefield.getChildren().remove(monster2);
                        this.stop();
                    }
//                    System.out.println(mY);
                    try {
                        Bounds boundsst = st.localToScreen(st.getBoundsInLocal());
                        int stX = (int) boundsst.getMinX();
                        int stY = (int) boundsst.getMinY();
//                        System.out.println(stX);
                        if (Math.abs(stX-mX)<40) {
//                            System.out.println("Destroyed");
//                            st.getChildren().removeAll();
//                            st.get
                            st.setVisible(false);
                        }
                    }
                    catch (Exception e){

                    }

                }
            };
            timer.start();
            return;
        }

        @Override
        public void run(){
            move();
        }
    }



    double dropValX;
    double dropValY;
    boolean checkX;
    private Image sword = new Image(getClass().getResource("/images/extraImages/sword.png").toExternalForm());
    private ImageView swordX = new ImageView(sword);

    @FXML
    private ImageView scrollX;

    @FXML
    private ImageView plant;

    @FXML
    private ImageView plant2;


    @FXML
    private ImageView monster1;

    @FXML
    private ImageView monster2;

    @FXML
    private GridPane battlefield;

    @FXML
    private StackPane stX;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private Button menuBut;

    @FXML
    private Label sunCounter;

    @FXML
    private Label scoreCounter;

    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TransitionXX tr = new TransitionXX();
        tr.start();
        moveX();
//        System.out.println("wassup baby?");
    }

    @FXML
    public void handleDragDetected(MouseEvent event) {
        Dragboard db = plant.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(plant.getImage());
        db.setContent(cb);
        event.consume();
//        System.out.println("Drag detected");
    }

    @FXML
    public void handleDragOver(DragEvent event) {
//        System.out.println("hi");
        if(event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//            System.out.println("here");
        }
        event.consume();
    }

    @FXML
    public void handleDrop(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
        Dragboard db = event.getDragboard();

//        Node node = event.getPickResult().getIntersectedNode();
//        System.out.println("hello");
//
//
//        stX.getChildren().add(plant2);
//        Integer c = battlefield.getColumnIndex(node);
//        Integer r = battlefield.getRowIndex(node);
//        int x = c;
//        int y = r;
        plant2 = new ImageView(db.getImage());
        plant2.setFitHeight(100);
        plant2.setFitWidth(60);
//        Integer r =
//        battlefield.add(plant2,x,y,1,1);
        battlefield.add(plant2,2,2,1,1);
        dropValX = event.getX();
        dropValY = event.getY();
        event.setDropCompleted(true);
        event.consume();
//        System.out.println("Dropped");
    }


    public void onClick(MouseEvent event){
//        System.out.println(event.getX());
//        System.out.println(event.getY());
        scrollX.setImage(null);
        String xVal = sunCounter.getText();
        int val = Integer.parseInt(xVal)+50;
        sunCounter.setText(Integer.toString(val));

    }


    @FXML
    private void firstItemAction(ActionEvent event) {
    }

    @FXML
    private void secondItemAction(ActionEvent event) {
        System.exit(-1);
    }

    public void moveX(){
        Random random = new Random();

        double randX = 500 + 200*random.nextDouble();
        scrollX.setLayoutX(randX);
            AnimationTimer timerX = new AnimationTimer() {


            @Override
            public void handle(long now) {

//                System.out.println("moving diver right!");
//                monster1.setX(monster1.getX() - .5);
                scrollX.setY(scrollX.getY()+ 1);
//                System.out.println("Hello");
                Bounds boundsScroll1 = scrollX.localToScreen(scrollX.getBoundsInLocal());

                if (boundsScroll1.getMinY()==802){
                    this.stop();
                }
                }
            };
            timerX.start();
            return;
    }





}
