package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// V předchozích přikladech Toggle a Radio Buttons umožňovaly všechny volby zobrazit uživateli najednou. Což zabere
// poměrně dost místa. Z tohoto důvodu pro výběr z více možností používáme následující ovládací prvky:
// ChoiceBox - uživatel si může vybrat z menšího seznamu voleb,
// ComboBox - rozšířenější verze CheckBoxu.  Lze např editovat položky, nebo měnit jejich vzhled,
// ListView - umožňuje vybrat ze seznamu víc položek najednou,
// ColorPicker - výběr barvy,
// DatePicker - výběr datumu.

//ChoiceBox disponuje následujícími vlastnostmi:
// converter    ObjectProperty<StringConverter<T>>  - poskytuje konvertující objekt s toString() metodou, která je
//                                                    volána pro zobrazení patřičného textu,
// items        ObjectProperty<ObservableList<T>>   - seznam voleb v ChoiceBoxu,
// selectionModel ObjectProperty<SingleSelectionModel<T>> - poskytuje model výběru,
// showing      ReadOnlyBooleanProperty             - true, pokud je ChoiceBox "rozbalen" (ukazuje seznam voleb)
// value        ObjectProperty<T>                   - vybraný prvek v ChoiceBoxu

// Použití vlastnosti value:
//        ChoiceBox<String> seasons = new ChoiceBox<>();
//        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");
//        String selectedValue = seasons.getValue();// get the selected value
//        seasons.setValue("Fall") //set the selected value
// V případě, že pomocí setValue() nastavíme položku, která v ChoiceBoxu není, ChoiceBox bude zobrazovat poslední
// zvolenou položku a ve vlastnosti value bude tato hodnota. Pokud je tato položka do ChoiceBoxu přidána později,
// zobrazí se.

// vlastnost selectionModel umožňuje:
// - vybrat položku za použití jejího indexu v seznamu,
// - vybrat první, další, předchozí, či poslední položku v seznamu,
// - vymazat výběr,
// - používat vlastnosti selectedIndex a selectedItem. Je možné použít  ChangeListener na tyto vlastnosti a připojit
//   handler.
// Příklad použití:
//         seasons.getSelectionModel().selectFirst();// lze i selectNext(), selectPrevious(), selectLast() a
//         clearSelection()
// Následující program dává na výběr ze 4 ročních období a ve výchozím stavu vybírá první položku.
public class KChoiceBoxTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label seasonLbl = new Label("Select a Season:");
        ChoiceBox<String> seasons = new ChoiceBox<>();
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        // Select the first season from the list
        seasons.getSelectionModel().selectFirst();

        // Add ChangeListeners to track change in selected index and item. Only
        // one listener is necessary if you want to track change in selection
        seasons.getSelectionModel().selectedItemProperty()
                .addListener(this::itemChanged);
        seasons.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);

        Label selectionMsgLbl = new Label("Your selection:");
        Label selectedValueLbl = new Label("None");

        // Bind the value property to the text property of the Label
        selectedValueLbl.textProperty().bind(seasons.valueProperty());

        // Display controls in a GridPane
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, seasonLbl, seasons);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using ChoiceBox Controls");
        stage.show();
    }

    // A change listener to track the change in selected item
    public void itemChanged(ObservableValue<? extends String> observable,
                            String oldValue,
                            String newValue) {
        System.out.println("Itemchanged: old = " + oldValue +
                ", new = " + newValue);
    }

    // A change listener to track the change in selected index
    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue);
    }
}