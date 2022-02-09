package cz.spsmb.w22.stages;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CBlankStage extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        int m = 1;
        Scene scene;
        Group root;
        switch(m){
            case 1:
                stage.setTitle("Stage with an empty scene");
                scene = new Scene(new Group());
                stage.setScene(scene);
                break;
            case 2:
                stage.setTitle("Stage with a Button in the Scene");
                scene = new Scene(new Group(new Button("Hello")));
                //scene = new Scene(new Button("Hello"));
                stage.setScene(scene);
                break;
            case 3:
                stage.setTitle("Stage with a Sized Scene");
                root = new Group(new Button("Hello"));
                scene = new Scene(root, 300,100);
                stage.setScene(scene);
                break;
            case 4:
                stage.setTitle("A Sized Stage with a Sized Scene");
                root = new Group(new Button("Hello"));
                scene = new Scene(root, 300,100);
                stage.setScene(scene);
                stage.setWidth(400);
                stage.setHeight(100);
                break;
            case 5:
                stage.setTitle("A trully centered stage");
                root = new Group(new Button("Hello"));
                scene = new Scene(root);
                stage.setScene(scene);
                //nutno tuto  logiku použít až po zavolání stage.show()
                Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
                double x = bounds.getMinX() + (bounds.getWidth() - stage.getWidth())/2.0;
                double y = bounds.getMinY() + (bounds.getHeight() - stage.getHeight())/2.0;
                //stage.show();
                stage.setX(x);
                stage.setY(y);
                break;
            default:
                stage.setTitle("Blank Stage");
                break;
        }
        stage.show();
    }
}