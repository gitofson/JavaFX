package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.time.Month;
// TilePane rozmisťuje rozměrově stejné poduzly. Vše je podobné jako u FlowPane, jen zde mají všechny řádky stejnou
// výšku a sloupce stejnou šířku. Orientace může být nastavena jako horizontální (výchozí), nebo vertikální.
// Přizpůsobení:
// - lze překrýt  výchozí velikosti dlaždic,
// - lze zvolit zarovnání obsahu TilePane uvnitř oblasti obsahu. Výchozí je Pos.TOP_LEFT
// - lze specifikovat preferovaný počet sloupců a řádků TilePane.



public class WTilePaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        double hgap = 5.0;
        double vgap = 5.0;
        TilePane root = new TilePane(hgap, vgap);
        root.setPrefColumns(5);

        // Add 12 Buttons - each having the name of the 12 months
        for(Month month: Month.values()) {
            Button b = new Button(month.toString());
            b.setMaxHeight(Double.MAX_VALUE);
            b.setMaxWidth(Double.MAX_VALUE);
            root.getChildren().add(b);
        }

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Horizontal TilePane");
        stage.show();
    }
}
