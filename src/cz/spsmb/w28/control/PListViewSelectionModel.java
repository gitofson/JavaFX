package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// ListView umožňuje vybrat jednu, nebo více položek ze seznamu. Každá z položek je reprezentovaná instancí třídy
// ListCell a může být tak cusomizována. Seznam položek může obsahovat jakýkoliv typ objektu. Lze použít
// - parametrizovanou verzi: ListView<String> seasons = new ListView<String>();
// - raw verzi : ListView seasons = new ListView();

// ListView neobsahuje vlastnost visibleItemCount, jako ComboBox. Potřeba nastavit velikost takto:
// seasons.setPrefSize(100, 120);

// ListView disponuje vlastností placeholder, kerá odkazuje na referenci uzlu. Pokud je vlastnost items empty, nebo null,
// pak se placeholder uzel zobrazí v oblasti seznamu ListView.

// ListView nabízí podporu skrolování. ScrollToEvent je vysttřelena buď metodouu scrollTo, nebo skrolováním uživatelem.

// Orientace ListView může být horizontální, či vertikální:
// seasons.setOrientation(Orientation.HORIZONTAL)

// ListView obsahuje tzv. model výběru (selection model), který uchovává stav položek. Vlastnost selectionModel
// drží referenci na model výběru. Ve výchozím stavu jde o instanci třídy MultipleSelectionModel. Pokud bychom vhtěli
// přepnout do jdenoduchého modelu výběru, uděláme to takto:
// seasons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE)

// Třída MultipleSelectionModel dědí z SelectionModel, která obsahuje vlastnosti selectedIndex a selectedItem. Navíc
// přidává metodu getSelectedIndicies(), která vrací read-onlu ObservableList<Integer> obsahující  indicie vybraných
// položek. Pro detekci změny je možné přidat ChangeListener na vlastnost selectedIndex, nebo ListChangeListener na
// ObselrvableList, který vrací metoda getSelectedInicies().

// Následující program ukazuje, jek používat model výběru, jak provést výběr pomocí API a  jak poslouchat události změn
// výběru
public class PListViewSelectionModel extends Application {
    private ListView<String> seasons;
    private final Label selectedItemsLbl = new Label("[None]");
    private final Label lastSelectedItemLbl = new Label("[None]");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label seasonsLbl = new Label("Select Seasons:");
        seasons = new ListView<>();
        seasons.setPrefSize(120, 120);
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        // Enable multiple selection
        seasons.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Add a selection change listener
        seasons.getSelectionModel()
                .selectedItemProperty()
                .addListener(this::selectionChanged);

        // Add some buttons to assist in selection
        Button selectAllBtn = new Button("Select All");
        selectAllBtn.setOnAction(e -> seasons.getSelectionModel().selectAll());

        Button clearAllBtn = new Button("Clear All");
        clearAllBtn.setOnAction(
                e -> seasons.getSelectionModel().clearSelection());

        Button selectFirstBtn = new Button("Select First");
        selectFirstBtn.setOnAction(
                e -> seasons.getSelectionModel().selectFirst());

        Button selectLastBtn = new Button("Select Last");
        selectLastBtn.setOnAction(e -> seasons.getSelectionModel().selectLast());

        Button selectNextBtn = new Button("Select Next");
        selectNextBtn.setOnAction(e -> seasons.getSelectionModel().selectNext());

        Button selectPreviousBtn = new Button("Select Previous");
        selectPreviousBtn.setOnAction(
                e -> seasons.getSelectionModel().selectPrevious());

        // Let all buttons expand as needed
        selectAllBtn.setMaxWidth(Double.MAX_VALUE);
        clearAllBtn.setMaxWidth(Double.MAX_VALUE);
        selectFirstBtn.setMaxWidth(Double.MAX_VALUE);
        selectLastBtn.setMaxWidth(Double.MAX_VALUE);
        selectNextBtn.setMaxWidth(Double.MAX_VALUE);
        selectPreviousBtn.setMaxWidth(Double.MAX_VALUE);

        // Display controls in a GridPane
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);

        // Add buttons to two VBox objects
        VBox singleSelectionBtns = new VBox(selectFirstBtn, selectNextBtn,
                selectPreviousBtn, selectLastBtn);
        VBox allSelectionBtns = new VBox(selectAllBtn, clearAllBtn);
        root.addColumn(0, seasonsLbl, seasons);
        root.add(singleSelectionBtns, 1, 1, 1, 1);
        root.add(allSelectionBtns, 2, 1, 1, 1);

        // Add controls to display the user selection
        Label selectionLbl = new Label("Your selection:");
        root.add(selectionLbl, 0, 2);
        root.add(selectedItemsLbl, 1, 2, 2, 1);

        Label lastSelectionLbl = new Label("Last selection:");
        root.add(lastSelectionLbl, 0, 3);
        root.add(lastSelectedItemLbl, 1, 3, 2, 1);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using ListView Selection Model");
        stage.show();
    }

    // A change listener to track the change in item selection
    public void selectionChanged(ObservableValue<? extends String> observable,
                                 String oldValue,
                                 String newValue) {
        String lastItem = (newValue == null)?"[None]":"[" + newValue + "]";
        lastSelectedItemLbl.setText(lastItem);

        ObservableList<String> selectedItems =
                seasons.getSelectionModel().getSelectedItems();
        String selectedValues =
                (selectedItems.isEmpty())?"[None]":selectedItems.toString();
        this.selectedItemsLbl.setText(selectedValues);
    }
}
