package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// Následující program demonstruje překrývací pravidla pro StackPane. Metoda createStackPane() vytvoří StackPane s
// Rectangle a Text. Parametry jsou text pro Text uzel, neprůhlednost (opacity) pro Rectangle a hodnotu boolean,
// která pokud je true, Rectangle je přidán do StackPane jako první.

public class TStackPaneOverlayTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane textOverRect = createStackPane("Hello", 1.0, true);
        StackPane rectOverText = createStackPane("Hello", 1.0, false);
        StackPane transparentRectOverText = createStackPane("Hello", 0.5, false);
        StackPane rectOverBigText = createStackPane("A bigger text", 1.0, false);
        StackPane transparentRectOverBigText =
                createStackPane("A bigger text", 0.5, false);

        // Add all StackPanes to an HBox
        HBox root = new HBox(textOverRect,
                rectOverText,
                transparentRectOverText,
                rectOverBigText,
                transparentRectOverBigText);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Overlaying Rules in StackPane");
        stage.show();
    }

    public StackPane createStackPane(String str, double rectOpacity, boolean rectFirst) {
        Rectangle rect = new Rectangle(60, 50);
        rect.setStyle("-fx-fill: lavender;" + "-fx-opacity: " + rectOpacity + ";");

        Text text = new Text(str);

        // Create a StackPane
        StackPane spane = new StackPane();

        // add the Rectangle before the Text if rectFirst is true.
        // Otherwise add the Text first
        if (rectFirst) {
            spane.getChildren().addAll(rect, text);
        } else {
            spane.getChildren().addAll(text, rect);
        }

        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        return spane;
    }
}
