package cz.spsmb.w28.control;

import cz.spsmb.w28.mvc.model.Person;
import cz.spsmb.w28.PersonStringConverter;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Program ukazuje použití  třídy StringConverter v ComboBoxu, který používá pro reprezentaci položek nějaký jiný objekt,
// než je String. Vkládané jméno se vždy zkonvertuje do objektu třídy Person. Poznamenejme, že pokud vyplníme String
// v ComboBoxu, změna vlastnosti selectedIndex se neprojeví. Abychom Jméno zobrazili v Label, musíme použít ActionEvent
// handler ComboBoxu.

// Pokud bychom chtěli změnit výchozí počet položek (10) v pop-up seznamu, použijeme vlastnost vcisibleRowCount

//Třída Cell je Labeled ovládací prvek pro zobrazení textového, či grafického obsahu. Položkykombo boxu  mohou být
// libovolného typu včetně Node. Používat Node jako prvek se však nedoporučuje, neboť nemůže být zobrazen na 2 místech
// současně. Více následující kód:
// Label shapeLbl = new Label("Shape: ");
// ComboBox<HBox> shapes = new ComboBox<>();
// shapes.getItems().addAll(
//              new HBox(new Line(0,10,20,10), new Label("Line")),
//              new HBox(new Rectangle(0,0,20,20), new Label("Rectangle")),
//              new HBox(new Circle(20,20,10), new Label("Circle")));
public class NComboBoxWithConverter extends Application {
    Label userSelectionMsgLbl = new Label("Your selection:");
    Label userSelectionDataLbl = new Label("");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label personLbl = new Label("Select/Enter Person:");
        ComboBox<Person> persons = new ComboBox<>();
        persons.setEditable(true);
        persons.setConverter(new PersonStringConverter());
        persons.getItems().addAll(new Person("John", "Jacobs", null),
                new Person("Donna", "Duncan", null),
                new Person("Layne", "Estes", null),
                new Person("Mason", "Boyd", null));

        // Add ChangeListeners to the selectedItem and selectedIndex
        // properties of the selection model
        persons.getSelectionModel().selectedItemProperty()
                .addListener(this::personChanged);
        persons.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);

        // Update the message Label when the value changes
        persons.setOnAction(e -> valueChanged(persons));

        GridPane root = new GridPane();
        root.addRow(0, personLbl, persons);
        root.addRow(1, userSelectionMsgLbl, userSelectionDataLbl);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using StringConverter in ComboBox");
        stage.show();
    }

    public void valueChanged(ComboBox<Person> list) {
        Person p = list.getValue();
        String name = p.getLastName() + ", " + p.getFirstName();
        userSelectionDataLbl.setText(name);
    }

    // A change listener to track the change in item selection
    public void personChanged(ObservableValue<? extends Person> observable,
                              Person oldValue,
                              Person newValue) {
        System.out.println("Itemchanged: old = " + oldValue +
                ", new = " + newValue);
    }

    // A change listener to track the change in index selection
    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue);
    }
}
