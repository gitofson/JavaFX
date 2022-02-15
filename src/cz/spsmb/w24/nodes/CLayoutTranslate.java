package cz.spsmb.w24.nodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// Pro další posuv v osách existují vlastnosti
// layoutX, layoutY           - definice posuvu v dané ose, určeno pro trvalé nastavení layoutu
// translateX, translateY     - definice posuvu v dané ose, určeno pro dočasné nastavení layoutu, např. animace
//Platí, že
// finalTranslationX = layoutX + translateX
// finalTranslationY = layoutY + translateY
public class CLayoutTranslate extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("OK");
        b1.setLayoutX(20);
        b1.setLayoutY(20);
        Button b2 = new Button("Cancel");
        b2.setLayoutX(50);
        b2.setLayoutY(50);
        Scene scene = null;
        int mode = 2;
        switch(mode) {
            case 1:
                //HBox a VBox poiužívá vlastní způsob roymístění a ignoruje tak naše nastavení metodami setLayoutX()
                VBox vb = new VBox();
                vb.getChildren().addAll(b1, b2);
                scene = new Scene(vb, 300, 300);
                break;
            case 2:
                //Pro plnou kontrolu potřeba použít rodičovské uzly tříd Group, nebo Pane:
                Group parent = new Group();
                parent.getChildren().addAll(b1, b2);
                scene = new Scene(parent, 300, 300);
                break;
        }

        stage.setScene(scene);
        stage.show();
    }
}
