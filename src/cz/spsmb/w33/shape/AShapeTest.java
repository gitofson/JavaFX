package cz.spsmb.w33.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
// JavaFX disponuje uzly reprezentující různé typy tvarů (shape). Ty jsou obsaženy v balíčku javafx.scene.shape.
// Vlastnosti:
// size     - obecný název. Ve skutečnosti používáme width, height pro obdelník (rectangle), radiue pro kružnici (circle),
// position - obecný název. Např. x, y definují levý horní roh obdelníka, centerX, centerY zas střed kružnice,
// fill     - barva, která se použije k výplni tvaru. Výchozí hodnota je Color.BLACK,
// stroke   - barva obrysu, výchozí null. Výjimka je pro Line, Polyline a Path, které mají výchozí Color.BLACK,
// strokeWidth - šířka obrysu (štětce), default je 1.0px,
// smooth   - pokud je true (default), použije se antialiasing pro vyrenderování tvaru,


// následující program vytvoří 2 kružnice. Jedna je světle šedá bez obrysu, druhá má žlutou výplň a 2px široký obrys.
public class AShapeTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a circle with a light gray fill and no stroke
        Circle c1 = new Circle(40, 40, 40);
        c1.setFill(Color.LIGHTGRAY);

        // Create a circle with an yellow fill and a black stroke of 2.0px
        Circle c2 = new Circle(40, 40, 40);
        c2.setFill(Color.YELLOW);
        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(2.0);

        HBox root = new HBox(c1, c2);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Shapes");
        stage.show();
    }
}
