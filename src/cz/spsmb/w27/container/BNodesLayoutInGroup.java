package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
// T
// Group je kontejnerem a má následující vlastnosti:
// - vykresluje uzly v pořadí, v jakém jsou vkládány,
// - pozice podříyených uzlů má výchozí hodnotu 0 0, pomocí layoutX a layoutY se musí donastavit,
// - ve výchozím stavu  změní velikost přidávaných uzlů na jejich preffered size. Lze vypnout pomocí autoSizeChildren
//   vlastnosti. Pokud to však uděláme většina uzlů bude po přidání neviditelná (nulová velikost).
// Velikost Groupy se nedá nastavit a je dána cllective bounds všech podřazených uzlů.
public class BNodesLayoutInGroup extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Set the location of the OK button
        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);

        // Set the location of the Cancel botton relative to the OK button
        NumberBinding layoutXBinding =
                okBtn.layoutXProperty().add(okBtn.widthProperty().add(10));
        cancelBtn.layoutXProperty().bind(layoutXBinding);
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());

        Group root = new Group();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Positioning Nodes in a Group");
        stage.show();
    }
}