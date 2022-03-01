package cz.spsmb.w25.style;

// Uzly (Region a Control) mohou mít pomopcí CSS nastaveny různé okraje. Specifikováno je to těmito 5 vlastnostmi:
//      -fx-border-color  - počet položek oddělených čárkou v seznamu určuje kolik okrajů se má vykreslit.
//                          Jeden okraj jednou barvou:
//                          -fx-border-color: red;
//                          Okraje začínají horním, poračuje se ve směru hod. ručiček:
//                          -fx-border-color: red green blue aqua;
//                          Možnost specifikace dvou okrajů:
//                          -fx-border-color: red green blue aqua, tan;
//      -fx-border-width  - možné specifikovat rozdílné šířky pro jednotlivé části okraje:
//                          -fx-border-color: red green blue aqua, tan, aqua;
//                          -fx-border-width: 2 1 2 2, 2 2 2 1, 3;
//      -fx-border-radius - poloměr, resp. poloměry rohů. V případě zadání čtveřice je první vlevo nahoře
//      -fx-border-insets - "vložka", tj. vzdálenost od okraje uzlu kde bude okraj vykreslen, opět se v případě 4
//                          hodnot začíná nahoře, pokračuje se podle hod. ručiček.
//      -fx-border-style  - styl okraje, může obsahovat vícero částí, a to následovně:
//                          -fx-border-style: <dash-style> [phase <number>] [<stroke types>] [line-join <line-join-value>]
//             <dash style> - možné hodnoty: none, solid, dotted, dashed, segments(<number>, <number>, ...)
//             <stroke type>- možné hodnoty: centered, inside, outside.
//         <line-join-value>- možné hodnoty: miter <number>, bevel, round.
//         <line-cap-value> - možné hodnoty: square, butt, round.
//                        - nejjednodušší příklad stylu okraje:
//                          -fx-border-style: solid;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HBordersSpecification extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Pane p = new Pane();
        p.setPrefSize(100, 100);
        int mode = 3;
        String style = "";
        switch(mode){
            case 0:
                style = "-fx-border-color: black;" +
                        "-fx-border-width: 5;" +
                        "-fx-border-radius: 0;" +
                        "-fx-border-insets: 0;" +
                        "-fx-border-style: solid line-join bevel line-cap square;";
                break;
            case 1:
                style = "-fx-border-color: red, black;" +
                        "-fx-border-width: 5, 5;" +
                        "-fx-border-radius: 0, 0;" +
                        "-fx-border-insets: 0, 5;" +
                        "-fx-border-style: solid inside, dotted outside;";
                break;
            case 2:
                style = "-fx-border-color: black, black;" +
                        "-fx-border-width: 1, 1;" +
                        "-fx-border-radius: 0, 0;" +
                        "-fx-border-insets: 0, 5;" +
                        "-fx-border-style: solid centered, dotted centered;";
                break;
            default:
                style = "-fx-border-color: red black red black;" +
                        "-fx-border-width: 5;" +
                        "-fx-border-radius: 0;" +
                        "-fx-border-insets: 0;" +
                        "-fx-border-style: solid line-join bevel line-cap round;";
                break;

        }
        p.setStyle(style);
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.show();

    }
}
