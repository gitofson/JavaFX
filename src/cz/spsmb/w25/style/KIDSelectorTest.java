package cz.spsmb.w25.style;
// Třída uzel má k dispozici vlastnost id (typ StringProperty), která může být použita k přiřazení jednoznačného id ke
// každému uzlu. V style sheetu je pak tyto selektory namísto tečky prefixovat mřížkou:
// #closeButton {
//  	-fx-text-fill: red;
// }

// JavaFX používá tzv. specifikaci selektoru (obdoba priority), která určí jaký selector bude ve finále použit. ID selector
// má v příkladu větší specifikaci, než class selector a proto je u closeBtn použit.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class KIDSelectorTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button openBtn = new Button("Open");
        Button saveBtn = new Button("Save");

        // nastavení ID closeBtn
        Button closeBtn = new Button("Close");
        closeBtn.setId("closeButton");

        HBox root = new HBox();
        root.getChildren().addAll(openBtn, saveBtn, closeBtn);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/idselector.css");

        stage.setScene(scene);
        stage.setTitle("Using ID selectors");
        stage.show();
    }
}
