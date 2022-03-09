package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Vlastnosti deklarované ve třídě HBox:
// alignment    ObjectProperty<pos> - specifikuje zarovnání poduzlů relativně k oblasti obsahu HBoxu.
//                                    Vlastnost fillHeight je ignorována pokud vertikální zarovnání je nastaveno na
//                                    BASELINE. Výchozí hodnota je TOP_LEFT.
// fillHeight  BooleanProperty      - Specifikuje zda resizable uzly mají být velikostně upraveny tak, aby vyplnily
//                                    výšku HBoxu, nebo majá zůstat v jejich preffered heights. Vlastnost je ignorována
//                                    pokud je vertikální zarovnání nastaveno na BASELINE. Výchozí hodnota je true.
// spacing     DoubleProperty       - výchozí hodnota 0, velikost mezery mezi poduzly.

//Následující program demonstruje vlastnost alignment, která je pro použitý HBox nastavena na Pos.BOTTOM_RIGHT:
public class IHBoxAlignment extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox hbox = new HBox(10);
        hbox.setPrefSize(200, 100);
        hbox.getChildren().addAll(okBtn, cancelBtn);

        // Set the alignment to bottom right
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        hbox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle("Using HBox Alignment Property");
        stage.show();
    }
}
