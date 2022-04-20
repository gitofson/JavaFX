package cz.spsmb.w28.control;

import javafx.application.Application;
import cz.spsmb.w28.GeneralTab;
import cz.spsmb.w28.AddressTab;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Uživatel může zavřít tab pomocí close tlačítka. Samotné zavření se řídí následujícími vlastnostmi:
// closable
// tabClosingPolicy - výčtový typ, možnosti:
//      ALL_TABS        - close tlačítko na všech tabech,
//      SELECTED_TAB    - close tlačítka na vybraném tabu,
//      UNAVAILABLE     - close tlačítko není zobrazeno.

// Další vlastnosti:
// side           - pozice Tabů v TabPane. Možnosti: TOP (default), RIGHT, BOTTOM, LEFT
// rotateGraphics - boolean, smysl pouze pro hodnoty vlastnosti side LEFT, nebo RIGHT

// TabPane může být ve dvou módech:
// recessed     - výchozí mód, taby vypadají připevněně,
// floating     - taby vypadají plovoucí. Zapnutí plovoucího módu:
// tabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING)
public class ZQTabClosingTest extends Application {
    GeneralTab generalTab = new GeneralTab("General", null);
    AddressTab addressTab = new AddressTab("Address", null);
    TabPane tabPane = new TabPane();

    CheckBox allowClosingTabsFlag = new CheckBox("Are Tabs closable?");
    Button restoreTabsBtn = new Button("Restore Tabs");
    ChoiceBox<TabPane.TabClosingPolicy> tabClosingPolicyChoices = new ChoiceBox<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Add Tabs to the TabPane
        tabPane.getTabs().addAll(generalTab, addressTab);
        //tabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);

        // Set a tab close request event handler for tabs
        generalTab.setOnCloseRequest(this::tabClosingRequested);
        addressTab.setOnCloseRequest(this::tabClosingRequested);

        // Set a closed event handler for the tabs
        generalTab.setOnClosed(e -> tabClosed(e));
        addressTab.setOnClosed(e -> tabClosed(e));

        // Set an action event handler for the restore button
        restoreTabsBtn.setOnAction(e -> restoreTabs());

        // Add choices to the choice box
        tabClosingPolicyChoices.getItems()
                .addAll(TabPane.TabClosingPolicy.ALL_TABS,
                        TabPane.TabClosingPolicy.SELECTED_TAB,
                        TabPane.TabClosingPolicy.UNAVAILABLE);

        // Set the default value for the tab closing policy
        tabClosingPolicyChoices.setValue(tabPane.getTabClosingPolicy());


        // Bind the tabClosingPolicy of the tabPane to the value property of the
        // of the ChoiceBoxx
        tabPane.tabClosingPolicyProperty().bind(
                tabClosingPolicyChoices.valueProperty());

        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding: 10;");
        grid.addRow(0, allowClosingTabsFlag, restoreTabsBtn);
        grid.addRow(1, new Label("Tab Closing Policy:"),
                tabClosingPolicyChoices);
        root.setTop(grid);
        root.setCenter(tabPane);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/tab_pane.css");
        stage.setScene(scene);
        stage.setTitle("Closing Tabs");
        stage.show();
    }

    public void tabClosingRequested(Event e) {
        if (!allowClosingTabsFlag.isSelected()) {
            e.consume(); // Closing tabs is not allowed
        }
    }

    public void tabClosed(Event e) {
        Tab tab = (Tab)e.getSource();
        String text = tab.getText();
        System.out.println(text + " tab has been closed.");
    }

    public void restoreTabs() {
        ObservableList<Tab> list = tabPane.getTabs();
        if (!list.contains(generalTab)) {
            list.add(0, generalTab);
        }

        if (!list.contains(addressTab)) {
            list.add(1, addressTab);
        }
    }

    public void closingPolicyChanged(
            ObservableValue<? extends TabPane.TabClosingPolicy> prop,
            TabPane.TabClosingPolicy oldPolicy,
            TabPane.TabClosingPolicy newPolicy) {
        tabPane.setTabClosingPolicy(newPolicy);
    }
}
