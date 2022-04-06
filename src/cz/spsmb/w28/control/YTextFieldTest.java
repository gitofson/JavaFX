package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Zajímavé jsou následující vlastnosti:
// alignment        - zarovnání textu uvnitř TextField oblasti. Výchozí hodnota je CENTER_LEFT pro LEFT_TO_RIGHT orientaci.
//                    CENTER_RIGHT pak pro RIGHT_TO_LEFT orientaci
// onAction         - ActionEvent handler, který je zavolán, pokud je stitknut enter
// prefColumnCount  - šířka ovládacího prvku, výchozí hodnota je 12. Šířka 1 by mělq být dostatečná pro zobrazení písmena W.

// TextField poskytuje výchozí kontextové menu, které se zobrazí po stisku pravého tlačítka myši. Výchozí menu není možné
// upravovat, ale lze ho nahradit. jiným.
public class YTextFieldTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a TextFiled with an empty string as its initial text
        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        // Both fields should be wide enough to display 15 chars
        firstNameFld.setPrefColumnCount(15);
        lastNameFld.setPrefColumnCount(15);

        // Add a ChangeListener to the text property
        firstNameFld.textProperty().addListener(this::changed);
        lastNameFld.textProperty().addListener(this::changed);

        // Add a dummy custom context menu for the firstname field
        ContextMenu cm = new ContextMenu();
        MenuItem dummyItem = new MenuItem("Context menu is disabled");
        cm.getItems().add(dummyItem);
        firstNameFld.setContextMenu(cm);

        // Set ActionEvent handlers for both fields
        firstNameFld.setOnAction(e -> nameChanged("First Name"));
        lastNameFld.setOnAction(e -> nameChanged("Last Name"));

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        root.addRow(0, new Label("First Name:"), firstNameFld);
        root.addRow(1, new Label("Last Name:"), lastNameFld);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using TextField Controls");
        stage.show();
    }

    public void nameChanged(String fieldName) {
        System.out.println("Action event fired on " + fieldName);
    }

    public void changed(ObservableValue<? extends String> prop,
                        String oldValue,
                        String newValue) {
        System.out.println("Old = " + oldValue + ", new = " + newValue);
    }
}
