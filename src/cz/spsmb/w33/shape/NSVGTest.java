package cz.spsmb.w33.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
// Instance třídy SVGPath vykresluje tvar z obrysu deklarovaném v nějakém řetězci. Třída SVGPath obsahuje vlastnosti:
// content      - řetězec s SVG daty. Řídí se následujícími pravidly:
//                      - řetězec obsahuje sérii příkazů,
//                      - každý příkaz je dlouhý právě jedno písmeno,
//                      - příkaz je následován parametry,
//                      - parametry mohou být odděleny čárkou, či mezerou,
//                      - před nebo za písmenem příkazu nemusí být mezera.
// fillRule     - může být FillRule.NON_ZERO, nebo FillRule.EVEN_ODD.

// Následující tabulka slouží jako převodník mezi SVG příkazy a Path API:
// SVG příkaz   parametry                           Path API
// M            (x, y)+                             MoveTo
// L            (x, y)+                             LineTo
// H            x+                                  HLineTo
// V            y+                                  VLineTo
// A            (rx, ry, x-axis-rotation,
//               large-arc-flag, sweep-flag, x, y)  ArcTo
// Q            (x1, y1, x, y)+                     QuadCurveTo
// T            (x, y)+                             QuadCurveTo
// C            (x1, y1, x2, y2, x, y)+             CubicCurveTo
// S            (x2, y2, x, y)+                     CubicCurveTo
// Z            None                                ClosePath
public class NSVGTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SVGPath sp = new SVGPath();
        sp.setContent("M50, 0 L0, 50 L100, 50 Z");
        sp.setFill(Color.LIGHTGRAY);
        sp.setStroke(Color.BLACK);
        HBox root = new HBox(sp);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
