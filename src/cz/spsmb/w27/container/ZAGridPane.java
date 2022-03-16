package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// GridPane představuje jeden z nejvýkonnějších layoutů. Rozložení poduzlů je v mřížce, kterou představují
// řádky a sloupce.
// Pomocí vlastnosti gridLinesVisible je možné mřížku zobrazit.
// Následující program ukazuje nejjednodušší možné přidání poduzlů do GridPane. Uzly se překrývají, neboť jsou vkládány
// do stejné buňky (0,0):
public class ZAGridPane extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("One One One One One");
        Button b2 = new Button("Two Two Two");
        Button b3 = new Button("Three");

        GridPane root = new GridPane();

        // Add three buttons to the list of children of the GridPane directly
        root.getChildren().addAll(b1, b2, b3);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Adding Children to a GridPane");
        stage.show();
    }
}

