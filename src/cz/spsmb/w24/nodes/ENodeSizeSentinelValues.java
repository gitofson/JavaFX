package cz.spsmb.w24.nodes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//resizable uzlům můžeme specifikovat 3 typy velikostí:
// preferovanou (preffered size) - ideální šířka a výška pro zobrazení obsahu. Např. tlačítko by mělo mít preferovanou velikost
//                                 takovou, aby bez problémů zobrazilo požadovaný obsah
// minimální (minimum size)      - nejmenší možná výška a šířka, kterou by daný uzel mohl mít
// maximální (maximum size)

// Třída Region obsahuje 2 konstanty, které určují, zda se má použít preferovaná, či vypočítaná velikost uzlu:
// USE_COMPUTED_SIZE -1                         - uzel si svou velikost automaticky spočítá
// USE_PREF_SIZE     Double.NEGATIVE_INFINITY   - používá se pro nastavení minimální a max. velikosti na preferovanou.
public class ENodeSizeSentinelValues extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        Button closeButton = new Button("Close");
        int mode = 1;
        switch (mode){
            case 1:
                //všechny 3 hodnoty nastaveny na 50. closeButton se tak stává horizontálně nonresizable
                closeButton.setPrefWidth(50);
                closeButton.setMinWidth(50);
                closeButton.setMaxWidth(50);
                break;
            case 2:
                //minimum a maximum nastaveno na preferovanou šířku. Ta se počítá automaticky
                closeButton.setMinWidth(Region.USE_PREF_SIZE);
                closeButton.setMaxWidth(Region.USE_PREF_SIZE);
                break;
        }
        // Override the intrinsic width of the cancel button
        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(80);

        VBox root = new VBox();
        root.getChildren().addAll(okBtn, cancelBtn, closeButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Overriding Node Sizes");
        stage.show();

        System.out.println("okBtn.getPrefWidth(): " + okBtn.getPrefWidth());
        System.out.println("okBtn.getMinWidth(): " + okBtn.getMinWidth());
        System.out.println("okBtn.getMaxWidth(): " + okBtn.getMaxWidth());

        System.out.println("cancelBtn.getPrefWidth(): " + cancelBtn.getPrefWidth());
        System.out.println("cancelBtn.getMinWidth(): " + cancelBtn.getMinWidth());
        System.out.println("cancelBtn.getMaxWidth(): " + cancelBtn.getMaxWidth());
    }
}
