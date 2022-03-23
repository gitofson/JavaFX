package cz.spsmb.w27.container;
// FlowPane  je jednoduchý layout, který uspořádá poduzly v řádcích (Orientation.HORIZONTAL), či ve sloupcích
// (Orientation.VERTICAL). Je možné specifikovat horizontální šířku, resp. vertikální výšku zalamování obsahu.
// FlowPane se používá tam, kde relativní pozice poduzlů nejsou důležité. Např. zobrazení série obrázků, či tlačítek.
// FlowPane dává všem uzlům jejich preferované veliosti.

//K použití následující konstruktory:

// Vytvoří prázdný horizontální FlowPane s 0px mezerami:
// FlowPane fpane1 = new FlowPane();

// Vytvoří prázdný vertikální FlowPane s 0px mezerami:
// FlowPane fpane2 = new FlowPane(Orientation.VERTICAL);

// Vytvoří prázdný horizontální FlowPane s 5px horizontáními a 10px vertikálními mezerami:
// FlowPane fpane3 = new FlowPane(5, 10);

// Vytvoří prázdný vertikální FlowPane s 5px horizontáními a 10px vertikálními mezerami:
// FlowPane fpane4 = new FlowPane(Orientation.VERTICAL, 5, 10);

// Vytvoří horizontální FlowPane s 2 tlačítky a 0px mezerami:
// FlowPane fpane5 = new FlowPane(new Button("But1"), new Button("But2"));

// Následující příklad ukazuje vytvoření horizontálního FlowPane a přidání 10 tlačítek.
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PFlowPaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        double hgap = 5;
        double vgap = 10;
        FlowPane root = new FlowPane(hgap, vgap);

        // Add ten buttons to the flow pane
        for(int i = 1; i <= 10; i++) {
            root.getChildren().add(new Button("Button " + i));
        }

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Horizontal FlowPane");
        stage.show();
    }
}
