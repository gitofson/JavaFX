package cz.spsmb.w25.style;


// Každý styl ve style sheetu má přiřazený tzv. selector, který jednoznažně určuje ke kterýn uzlům se má daný
// styl aplikovat. JavaFX podporuje následující druhy selektorů:
//      - class selector - třída Node definuje vlastnost styleClass (typ ObservableList<String>), která udržuje seznam
//                         JavaFX CSS stylů tříd pro daný uzel. Mnoho ovládacích prvků má svůj výchozí "style class name".
//                         Třídy kontejnerů (např. Region, Pane, HBox, VBox) tento výchozí "style class name" nemají.
//      - pseudo-class selector
//      - ID selector
//      - další

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class IStyleClassTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameTf = new TextField("");
        Button closeBtn  = new Button("Close");
        closeBtn.setOnAction(e -> Platform.exit());

        HBox root = new HBox();
        root.getChildren().addAll(nameLbl, nameTf, closeBtn);

        // Set the styleClass for the HBox to "hbox"
        root.getStyleClass().add("hbox");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/styleclass.css");

        stage.setScene(scene);
        stage.setTitle("Using Style Class Selectors");
        stage.show();
    }
}
