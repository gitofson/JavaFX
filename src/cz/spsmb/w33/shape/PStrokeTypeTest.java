package cz.spsmb.w33.shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
// Třída Shape obsahuje několik vlastností, které definují vzhled obrysové čáry (štětce):
// stroke           - barva štětce,
// strokeWidth      - šířka obrysové čáry,
// strokeType       - může být CENTERED (default), INSIDE, nebo OUTSIDE,
// strokeLineCap    - může být:
//                      - BUTT  (default) - žádná dekorace konců podobrysů,
//                      - SQUARE - rozšíření konců podobrysů o polovičku strokeWidth,
//                      - ROUND  - rozšíření konců podobrysů o polokruh s poloměrem poloviny strokeWidth.
// strokeLineJoin   - způsob, jakým se spojují prvky podobrysů.Může být:
//                      - BEVEL - vnější rohy spojeny přímou čárou,
//                      - MITER (default) - rozšíření vnějších hran dokud nejsou spojeny,
//                      - ROUND - zakulacení spojů pomocí kruhu s poloměrem poloviny strokeWidth.
// strokeMiterLimit - pokud by úhel mezi elementy byl malý, tak by mohlo dojít k velkému prodloužení v případě MITER
//                    Tento limit zajistí poměr mezi skutečným prodloužením a strokeWidth.
public class PStrokeTypeTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle r1 = new Rectangle(50, 50);
        r1.setFill(Color.LIGHTGRAY);

        Rectangle r2 = new Rectangle(50, 50);
        r2.setFill(Color.LIGHTGRAY);
        r2.setStroke(Color.BLACK);
        r2.setStrokeWidth(4);
        r2.setStrokeType(StrokeType.INSIDE);

        Rectangle r3 = new Rectangle(50, 50);
        r3.setFill(Color.LIGHTGRAY);
        r3.setStroke(Color.BLACK);
        r3.setStrokeWidth(4);

        Rectangle r4 = new Rectangle(50, 50);
        r4.setFill(Color.LIGHTGRAY);
        r4.setStroke(Color.BLACK);
        r4.setStrokeWidth(4);
        r4.setStrokeType(StrokeType.OUTSIDE);

        HBox root = new HBox(r1, r2, r3, r4);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Different Stroke Types for Shapes");
        stage.show();
    }
}
