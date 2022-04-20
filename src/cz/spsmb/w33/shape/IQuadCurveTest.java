package cz.spsmb.w33.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
// Bezierovy křivky jsou používány v počítačové grafice ke kreslení vyhlazených křivek. Instance třídy QuadCurve
// reprezentuje kvadratickou Bezierovu křivku průnikem dvou specifikovaných bodů a kotrolním bodem.
// Více: https://cs.wikipedia.org/wiki/B%C3%A9zierova_k%C5%99ivka . 6 vlastností:
// startX, startY       - startovní bod křivky,
// controlX, controlY   - kontrolní bod křivky,
// endX, EndY           - koncový bod křivky.
public class IQuadCurveTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        QuadCurve qc1 = new QuadCurve(0, 100, 20, 0, 150, 100);
        qc1.setFill(Color.TRANSPARENT);
        qc1.setStroke(Color.BLACK);

        QuadCurve qc2 = new QuadCurve(0, 100, 20, 0, 150, 100);
        qc2.setFill(Color.LIGHTGRAY);

        HBox root = new HBox(qc1, qc2);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using QuadCurves");
        stage.show();
    }
}
