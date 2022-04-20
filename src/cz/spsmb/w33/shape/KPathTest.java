package cz.spsmb.w33.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
// Jednoduché tvary diskutované dříve nejsou vhodné pro kreslení  komplexnějších tvarů. K tomu slouží třída Path.
// Instance třídy Path definuje cestu, resp. obrys tvaru. Tato cesta (obrys) se skládá z vícero podcest a ty
// obsahují jeden, či více elementů. Ty jsou instancí abstraktní třídy PathElement. Následující potomci třídy
// PathElement jsou k dispozici pro vytvoření specifického tvaru:
// MoveTo
// LineTo
// HLineTo
// VLineTo
// ArcTo
// QuadCurveTo
// CubicCurveTo
// ClosePath

// Souřadnice mohou být absolutní (default), nebo relativní (vlastnost absolute == false).


public class KPathTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Path triangle = new Path(new MoveTo(0, 0),
                new LineTo(0, 50),
                new LineTo(50, 50),
                new ClosePath());

        Path star = new Path();
        star.getElements().addAll(new MoveTo(30, 0),
                new LineTo(0, 30),
                new LineTo(60, 30),
                new ClosePath(),/* new LineTo(30, 0), */
                new MoveTo(0, 10),
                new LineTo(60, 10),
                new LineTo(30, 40),
                new ClosePath() /*new LineTo(0, 10)*/);

        HBox root = new HBox(triangle, star);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Paths");
        stage.show();
    }
}
