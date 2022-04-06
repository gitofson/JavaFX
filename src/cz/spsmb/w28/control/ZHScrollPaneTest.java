package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
// JavaFX poskytuje třídy ScrollBar a ScrollPane, které umožňují přidat "scrolling features" dalším ovládacím prvkům.
// ScrollBar je jednoduchý prvek, který disponuje metodami:
// setOrientation()         - nastavení orientace, default Orientation.HORIZONTAL
// setValue()           \
// increment()              - nastavení scrollbaru pomocí API
// decrement()          /

//ScrollPane poskytuje skrolovatelnou verzi uzlu. Vlastnosti:
// content          - specifikace rolovatelného obsahu, typ Node
// pannable
// fitToHeight
// fitToWidth
// hbarPolicy       - ALWAYS - scrollbar je zobrazen vždy, AS_NEED - scrollbar zobrazen podle velikosti obsahu, NEVER
// vbarPolicy
// hmin, hmax, hvalue
// vmin, vmax, vvalue
// prefViewPortHeight
// prevViewPortWidth
// viewportBounds   - aktuální bounds viewportu
public class ZHScrollPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label poemLbl = new Label("I told her this; her laughter light\n" +
                "Is ringing in my ears;\n" +
                "And when I think upon that night\n" +
                "My eyes are dim with tears.");

        // Create a scroll pane with poemLbl as its content
        ScrollPane sPane = new ScrollPane(poemLbl);
        sPane.setPannable(true);

        HBox root = new HBox(sPane);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using ScrollPane Controls");
        stage.show();
    }
}
