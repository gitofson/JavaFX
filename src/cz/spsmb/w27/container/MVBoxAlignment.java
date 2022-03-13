package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// Vlastnosti deklarované ve třídě VBox:
// alignment    ObjectProperty<pos> - specifikuje zarovnání poduzlů relativně k oblasti obsahu VBoxu.
//                                    Výchozí hodnota je TOP_LEFT.
// fillWidth    BooleanProperty     - Specifikuje zda resizable uzly mají být velikostně upraveny tak, aby vyplnily
//                                    plnou šířku VBoxu, nebo majá zůstat v jejich preffered heights. Výchozí hodnota
//                                    je true.
// spacing     DoubleProperty       - výchozí hodnota 0, velikost mezery mezi poduzly.

//Následující program demonstruje vlastnost alignment, která je pro použitý VBox nastavena na Pos.BOTTOM_RIGHT:
public class MVBoxAlignment extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        VBox vbox = new VBox(10);
        vbox.setPrefSize(200, 100);
        vbox.getChildren().addAll(okBtn, cancelBtn);

        // Set the alignment to bottom right
        vbox.setAlignment(Pos.BOTTOM_RIGHT);

        vbox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Using VBox Alignment Property");
        stage.show();
    }
}
