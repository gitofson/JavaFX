package cz.spsmb.w24.nodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class BBoundsInLocal extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("Close");
        b1.setEffect(new DropShadow());

        Rectangle r = new Rectangle(75, 50, 50, 20);
        r.setEffect(new DropShadow());
        r.getTransforms().addAll(new Translate(150, 75), new Rotate(30));

        VBox root = new VBox();
        root.getChildren().addAll(new Group(b1), new Group(r));

        Scene scene = new Scene(root, 300,300);
        stage.setScene(scene);
        stage.setTitle("Testing LayoutBounds");
        stage.show();

        System.out.println("b1(layoutBounds)=" + b1.getLayoutBounds());
        System.out.println("b1(boundsInLocal)=" + b1.getBoundsInLocal());
        System.out.println("b1(boundsInParent)=" + b1.getBoundsInParent());

        System.out.println("r(layoutBounds)=" + r.getLayoutBounds());
        System.out.println("r(boundsInLocal)=" + r.getBoundsInLocal());
        System.out.println("r(boundsInParent)=" + r.getBoundsInParent());
    }
}
