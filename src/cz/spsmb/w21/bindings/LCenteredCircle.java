package cz.spsmb.w21.bindings;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class LCenteredCircle extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Circle c = new Circle();
        Group root = new Group(c);
        Scene scene = new Scene(root, 100, 100);
        //Vytvoření vazby centerX, centerY a poloměru kruhu c na šířku a výšku scény
        c.centerXProperty().bind(scene.widthProperty().divide(2));
        c.centerYProperty().bind(scene.heightProperty().divide(2));
        c.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(2)));
        //nastavení vlastností stage
        stage.setTitle("Bindings in JavaFX");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
