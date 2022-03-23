package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// Na CombBox se můžeme dívat jako na pokročilejší verzi ChoiceBoxu. Tato třída dědí od třídy ComboBoxBase, stejně jako
// třídy ColorPicker a DatePicker. Je takto možné si vytvořit vlastní ovládací prvek pro výběr z možných voleb.
// ComboBox je parametrizovaná třída. Pokud však chceme používat v ComboBoxu různé typy, použijeme tzv. raw type:
//        ComboBox seasons = new ComboBox<>();

// Parametrizovaná verze pak vypadá takto:
//        ObservableList<String> seasonList = FXCollections.<String>observableArrayList(
//                                            "Spring", "Summer", "Fall", "Winter");
//        ComboBox<String> seasons = new ComboBox<>(seasonList);
// Namísto konstruktoru je možné přidat položky i pomocí vlastnosti items (preferovanější varianta):
//         seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");
// Podobně jako u ChoiceBoxu se zde používá vlastnost selectionModel pro uložení detailu vybrané položky.
// ComboBox může být editovatelný, pokud je vlastnost editable nastavena na true (výchozí hodnota je false).
// Pro zjištění vybrané hodnoty slouží vlastnost value.
// Vlastnost promptText může být nastavena pro zobrazení textu v případě, že je ComboBox editable, nemá focus a jeho
// value je null. Příklad:
//       breakfasts.setPromptText("Select/Enter an Item");
// Vlastnost placeholder odkazuje na referenci nějakého uzlu, který se má zobrazit v pop-up oblasti, pokud je list
// položek prázdný, či null. Příklad:
//       Label placeHolder = new Label("List is Empty.\nPlease enter an item");
//       breakfasts.setPlaceholder(placeHolder);


//Následující program vytvoří dva ComboBoxy: seasons (not editable) a breakfasts (editable):
public class MComboBoxTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label seasonsLbl = new Label("Season:");
        ComboBox<String> seasons = new ComboBox<>();
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        Label breakfastsLbl = new Label("Breakfast:");
        ComboBox<String> breakfasts = new ComboBox<>();
        breakfasts.getItems().addAll("Apple", "Banana", "Strawberry");
        breakfasts.setEditable(true);

        // Show the user's selection in a Label
        Label selectionLbl = new Label();
        StringProperty str = new SimpleStringProperty("Your selection: ");
        selectionLbl.textProperty().bind(str.concat("Season=")
                .concat(seasons.valueProperty())
                .concat(", Breakfast=")
                .concat(breakfasts.valueProperty()));

        HBox row1 = new HBox(seasonsLbl, seasons, breakfastsLbl, breakfasts);
        row1.setSpacing(10);
        VBox root = new VBox(row1, selectionLbl);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using ComboBox Controls");
        stage.show();
    }
}

