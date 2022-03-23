package cz.spsmb.w28.control;

import cz.spsmb.w28.mvc.model.Person;
import cz.spsmb.w28.PersonStringConverter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//--module-path "C:\Users\stemb\IdeaProjects\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml

// V ChoiceBoxu nemusí být nutně jen položky typu String. Lze použít jakýkoliv objekt. ChoiceBox volá metodu toString()
// každé položky a zobrazí ji v pop-up menu. Třída
// cz.spsmb.w28.PersonStringConverter disponuje metodami toString() a fromString(String in). Více v příkladu, kde jsou
// na ukázku přidány i styly.

public class LDomainObjectsInChoiceBox extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ChoiceBox<Person> persons = new ChoiceBox<>();
        //Nastavení konvertoru pro konverzi objektu Person na String
        //persons.setConverter(new PersonStringConverter());

        persons.getItems().addAll(new Person("John", "Jacobs", null),
                                  new Person("Donna", "Duncan", null),
                                  new Person("Layne", "Estes", null),
                                  new Person("Mason", "Boyd", null));
        HBox root = new HBox(persons);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/choice_box.css");
        stage.setScene(scene);
        stage.show();
    }
}
