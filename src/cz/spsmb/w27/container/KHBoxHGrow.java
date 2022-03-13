package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
//HBox podporuje 2 typy omezení pro jednotlivé poduzly:
// hgrow  - specifikuje, zda daný poduzel se má horizontílně rozšířit, když uživatel změní šířku HBoxu
// margin - specifikuje mezeru mezi hrany poduzlů.
// Statické metody třídy HBox setHgrow() a setMargin() slouží k nastavení těchto omezení. Výmaz na původní hodnoty
// dostaneme statickou metodou clearConstraints()

//Následující program přidá šířku poduzlu nameFld, pokud okno "roztáhneme".
public class KHBoxHGrow extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();

        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox root = new HBox(10);
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);

        // Let the TextField always grow horizontally
        HBox.setHgrow(nameFld, Priority.ALWAYS);
        // reset it:
        //HBox.setHgrow(nameFld, null);


        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Horizontal Grow Priority in an HBox");
        stage.show();
    }
}
