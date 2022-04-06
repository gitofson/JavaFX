package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
// Password překrývá metody cut() a copy()
public class ZAPasswordFieldTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        PasswordField pf = new PasswordField();
        pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(pf.getText());
            }
        });
        Label lab = new Label("Heslo: ");
        HBox root = new HBox(lab, pf);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
