// CustomTableCellTest.java
package cz.spsmb.w38.tableview;

import cz.spsmb.w28.mvc.model.Person;
import cz.spsmb.w38.DatePickerTableCell;
import cz.spsmb.w38.PersonTableUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.FormatStyle;

public class FCustomTableCellTest extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());
		
		// Make sure teh TableView is editable
		table.setEditable(true);
		
		// Set up teh Birth Date column to use DatePickerTableCell
		TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn();
		StringConverter converter = new LocalDateStringConverter( FormatStyle.LONG);
		birthDateCol.setCellFactory(
			DatePickerTableCell.<Person>forTableColumn(converter, false));

		table.getColumns().addAll(PersonTableUtil.getIdColumn(), 
		                          PersonTableUtil.getFirstNameColumn(), 
		                          PersonTableUtil.getLastNameColumn(), 
		                          birthDateCol);
		
		HBox root = new HBox(table);
		root.setStyle("-fx-padding: 10;" + 
		              "-fx-border-style: solid inside;" + 
		              "-fx-border-width: 2;" +
		              "-fx-border-insets: 5;" + 
		              "-fx-border-radius: 5;" + 
		              "-fx-border-color: blue;");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Using a Custom TableCell");
		stage.show();
	}
}
