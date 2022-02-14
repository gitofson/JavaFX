package cz.spsmb.w24.scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;


public class BSetCursor extends Application {
    Cursor currentCursor, defaultCursor;
    int cursorState = 0;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Stage");
        Button btn = new Button("Cursor change");
        Scene scene = new Scene(new Group(btn), 300, 300);
        this.defaultCursor = scene.getCursor();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch(cursorState){
                    //načtení z png
                    case 0:
                        BSetCursor.this.cursorState++;
                        URL url = this.getClass().getClassLoader().getResource("picture/cursor_PNG95.png");
                        BSetCursor.this.currentCursor = Cursor.cursor(url.toExternalForm());
                        break;
                    //použití výčtu Cursor.
                    case 1:
                        BSetCursor.this.cursorState++;
                        BSetCursor.this.currentCursor = Cursor.CROSSHAIR;
                        break;
                    //definice kurzoru pomocí Stringu
                    case 2:
                        BSetCursor.this.cursorState++;
                        BSetCursor.this.currentCursor = Cursor.cursor("WAIT");
                        break;
                    //použití výchozího kurzoru
                    case 3:
                        BSetCursor.this.cursorState=0;
                        BSetCursor.this.currentCursor = BSetCursor.this.defaultCursor;
                        break;
                    default:
                        throw new RuntimeException("Stav kurzoru mimo meze");
                }

                scene.setCursor(BSetCursor.this.currentCursor);
            }
        });

        scene.setCursor(Cursor.CROSSHAIR);
        stage.setScene(scene);
        stage.show();
    }
}
