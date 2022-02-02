package cz.spsmb.w21.bindings;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
//add --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
public class MAnimatedCircle extends Application {
    //DoubleProperty rad = new SimpleDoubleProperty(0);
    private Circle c = new Circle();
    private Scene scene;
    private double coef = + 1.0;
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        /*AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long l) {
                animationHandler();
            }
        };*/
        /*AnimationTimer at = new AnimationTimer() {
            private long lastUpdate; // Last time in which `handle()` was called
            private double speed = 50 ; // The snake moves 50 pixels per second
            @Override
            public void start() {
                this.lastUpdate = System.nanoTime();
                super.start();
            }
            @Override
            public void handle(long l) {
                long elapsedNanoSeconds = l - this.lastUpdate;
                // 1 second = 1,000,000,000 (1 billion) nanoseconds
                double elapsedSeconds = elapsedNanoSeconds / 25_000_000.0;
                if(elapsedSeconds >= 1) {
                    animationHandler();
                    this.lastUpdate = l;
                }

            }
        };
        at.start();
        */
        /*
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(25), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                animationHandler();
            }
        }));
        */
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(25), this::animationHandler));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

        Group root = new Group(this.c);
        this.scene = new Scene(root, 100, 100);
        //Vytvoření vazby centerX, centerY a poloměru kruhu c na šířku a výšku scény
        this.c.centerXProperty().bind(this.scene.widthProperty().divide(2));
        this.c.centerYProperty().bind(this.scene.heightProperty().divide(2));
        //c.radiusProperty().bind(this.rad);
        //c.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(2)));
        //nastavení vlastností stage
        stage.setTitle("Bindings in JavaFX");
        stage.setScene(this.scene);
        stage.sizeToScene();
        stage.show();

    }

    public void animationHandler(ActionEvent e){

        if(this.c.radiusProperty().get() > Math.min(
                this.scene.heightProperty().get()/2, this.scene.widthProperty().get()/2)){
            this.coef = - 1.0;
        } else if (this.c.radiusProperty().get() <= 0) {
            this.coef = 1.0;
        }
           this.c.radiusProperty().set(this.c.radiusProperty().get() + coef);
    }
}
