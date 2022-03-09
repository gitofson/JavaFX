package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
// Pane je podřídou třídy Region a má následující vlastnosti:
// - potřeba nastavit pozici poduzlů. Výchozí hodnota je 0 0
// - upravuje velikost všech resizable poduzlů (children) na jejich preffered value.

// Následující program ukazuje jak Pane vytvořit, přidat 2 tlačítka jak je umístit.
public class GPaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        okBtn.relocate(10, 10);
        cancelBtn.relocate(60, 10);

        Pane root = new Pane();
        root.getChildren().addAll(okBtn, cancelBtn);
        root.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 3;" +
                "-fx-border-color: red;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Panes");
        stage.show();
    }
}