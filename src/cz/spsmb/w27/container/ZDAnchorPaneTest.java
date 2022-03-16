package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// AnchorPane umisťuje poduzly pomocí pevně zadaných kotev (anchors) čtyř stran. Bez specifikovaných kotev umisťuje
// poduzly do pozice 0 0 a nepřináší tak žádné výhody. Pro nastavení kotev se používají následující vlastnosti:
// topAnchor        Double - vzdálenost mezi horní hranou oblasti obsahu AnchorPane a horní hranou poduzlu,
// rightAnchor      Double - vzdálenost mezi pravou hranou oblasti obsahu AnchorPane a pravou hranou poduzlu,
// bottomAnchor     Double - vzdálenost mezi spodní hranou oblasti obsahu AnchorPane a spodní hranou poduzlu,
// leftAnchor       Double - vzdálenost mezi levou hranou oblasti obsahu AnchorPane a levou hranou poduzlu.

// Následující program přidá dvě tlačítka do AnchorPane. První má nastavenou horní a levou kotvu, Druhé dolní a pravou.
// Při změně velikosti okna kotvy demonstrují svou funkci.
public class ZDAnchorPaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button topLeft = new Button("Top Left");
        AnchorPane.setTopAnchor(topLeft, 10.0);
        AnchorPane.setLeftAnchor(topLeft, 10.0);

        Button bottomRight = new Button("Botton Right");
        AnchorPane.setBottomAnchor(bottomRight, 10.0);
        AnchorPane.setRightAnchor(bottomRight, 10.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(topLeft, bottomRight);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using an AnchorPane");
        stage.show();
    }
}
