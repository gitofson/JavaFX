package cz.spsmb.w28.control;

import cz.spsmb.w28.ShapeCellFactory;
import cz.spsmb.w28.StringShapeCell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
// Předchozí problém viditelnosti jen jedné instance položky typu Node je možné řešit pomocí tzv. "cell factory"
// ComboBox obsahuje vlastnost cellFactory, která je deklarována následovně:
// public ObjectProperty<Callback<ListView<T>, ListCell<T>>> cellFactory;
// Rozhraní java.util.Callback obsahuje metodu call(), která bere argument typu P a vrací objekt typu R:
// public interface Callback<P,R> {
//      public R call(P param);
// }

// Princip je, že se ukládají callbacky objektů, jejichž metoda Call dostane ListView<T> a vrací ListCell<T>. Uvnitř
// metody call vytvoříme  instanci třídy ListCell<T> a překryjeme metodu updateItem(T item, boolean empty), abychom
// buňku naplnili.
public class OComboBoxCellFactory extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label shapeLbl = new Label("Shape:");
        ComboBox<String> shapes = new ComboBox<>();
        shapes.getItems().addAll("Line", "Rectangle", "Circle");

        // Set the cellFactory property
        shapes.setCellFactory(new ShapeCellFactory());

        // Set the buttonCell property
        shapes.setButtonCell(new StringShapeCell());

        HBox root = new HBox(shapeLbl, shapes);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using CellFactory in ComboBox");
        stage.show();
    }
}
