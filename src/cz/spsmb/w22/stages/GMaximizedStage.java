package cz.spsmb.w22.stages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;
//Ukázka zobrazení okna maximální velikosti a možnosti přechodu do celoobrazovkového režimu.
// Pokud není celoobrazovkový režim na systému dostupný, použije se maximaizované undecorated okno.
public class GMaximizedStage extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("full screen");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setFullScreen(true);
            }
        });
        stage.setScene(new Scene(new Group(button)));
        stage.setTitle("A Maximized Stage");

        // Set the position and size of the stage equal to the position and
        // size of the screen
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(visualBounds.getMinX());
        stage.setY(visualBounds.getMinY());
        stage.setWidth(visualBounds.getWidth());
        stage.setHeight(visualBounds.getHeight());

        // Show the stage
        stage.show();
    }
}