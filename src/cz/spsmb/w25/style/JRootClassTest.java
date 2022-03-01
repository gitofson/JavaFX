package cz.spsmb.w25.style;
// Kořenový (root) uzel scény má pro JavaFX style class výchozí jméno selektoru "root"
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JRootClassTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameTf = new TextField("");
        Button closeBtn = new Button("Close");

        HBox root = new HBox();
        root.getChildren().addAll(nameLbl, nameTf, closeBtn);

        Scene scene = new Scene(root);
        /* The root variable is assigned a default style class name "root" */

        scene.getStylesheets().add("css/rootclass.css");

        stage.setScene(scene);
        stage.setTitle("Using the root Style Class Selector");
        stage.show();
    }
}
