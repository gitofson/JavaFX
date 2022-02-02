package cz.spsmb.w20;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//run: VMOPtions: --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
public class ButtonsFXApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");
        //tlačítka:
         Button sayHelloBtn = new Button("Say hello");
         Button exitBtm = new Button("Exit");

         //přidání posluchače událostí pro Say Hello button
        sayHelloBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = nameFld.getText();
                if (name.trim().length() > 0) {
                    msg.setText("Hello " + name);
                } else {
                    msg.setText("Hello there");
                }
            }
        });
        //přidání posluchače událostí pro Exit button
        exitBtm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        //vytvoření kořenového uzlu:
        VBox root = new VBox();

        //nastavení vertikálního odstupu mezi prvky (dětmi) VBoxu
        root.setSpacing(5);

        //Přidání prvků do kořenového uzlu
        root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtm);

        Scene scene = new Scene(root, 350, 150);
        stage.setScene(scene);
        stage.setTitle("Zdokonalnější verze Hello World v JavaFX");
        stage.show();
    }
}
