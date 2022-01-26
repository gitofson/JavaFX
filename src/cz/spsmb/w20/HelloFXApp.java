package cz.spsmb.w20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application {
    //Run -> Edit Configurations -> Alt+V (add VM Options line), Add --module-path /path/to/JavaFX/lib --add-modules=javafx.controls
    @Override
    public void start(Stage stage) throws Exception {
        Text msg = new Text("Hello JavaFX");
        //vertikálkní box jako kořenový uzel scény
        VBox root = new VBox();
        //p5id8me do VBoxu text
        root.getChildren().add(msg);

        //Vytvoříme scénu (kořenový uzel, šířka scény,
        // výška):
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Moje okno");
        stage.show();

    }
}
