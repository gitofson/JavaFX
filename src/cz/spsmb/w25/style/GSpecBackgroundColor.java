package cz.spsmb.w25.style;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Uzly (Region a Control) mohou mít různé podbarvení pozadí. Specifikováno je to těmito 3 vlastnostmi:
//      -fx-background-color  - čárkou oddělená specifikace barev. Jejich seznam dává počet obdelníků, které se
//          mají vybarvit. Počet barev musí sedět s počtem následujících vlastností:
//      -fx-background-radius - čárkou oddělené 4 poleměry každého z rohů. Začátek je vlevo nahoře, pokračuje se
//          ve směru hodinových ručiček.
//      -fx-background-insets - čárkou oddělené 4 vzdálenosti okrajů vyplněného obdelníka. Začátek je na horním okraji,
//          pokračuje se ve směru hodinových ručiček.
public class GSpecBackgroundColor extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Pane p = new Pane();
        p.setPrefSize(100, 100);
        int mode = 3;
        switch (mode) {
            case 0:
                p.setStyle(
                        "-fx-background-color: gray; " +
                        "-fx-background-insets: 5; " +
                        "-fx-background-radius: 10; "
                );
                break;
            case 1:
                p.setStyle(
                        "-fx-background-color: gray; " +
                        "-fx-background-insets: 0; " +
                        "-fx-background-radius: 0; "

                );
                break;
            case 2:
                p.setStyle(
                        "-fx-background-color: gray; " +
                        "-fx-background-insets: 5 10 15 20; " +
                        "-fx-background-radius: 10 0 0 5; "
                );
                break;
            default:
                p.setStyle(
                        "-fx-background-color: red, green, blue;" +
                        "-fx-background-insets: 5, 10 15 10 10, 15 20 15 15;" +
                        "-fx-background-radius: 5, 0 0 10 10, 0 20 5 10;"
                );
                break;
        }
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.show();
    }
}
