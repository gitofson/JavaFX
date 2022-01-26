package cz.spsmb.w21;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.List;
import java.util.Map;

// Předávání parametrů z příkazové řádky do aplikace - 3 druhy parametrů:
// pojmenované (named)     Map<String, String> gatNamed()
// nepojmenované (unnamed) List<String> getUnnamed()
// syrové (raw)            List<String> getRaw()
public class FXParamApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    //Run -> Edit Configurations -> Alt+V (add VM Options line), Add --module-path /path/to/JavaFX/lib --add-modules=javafx.controls
    @Override
    public void start(Stage stage) throws Exception {
        //přebrání parametrů aplikace
        Parameters p = this.getParameters();
        Map<String, String> namedParams = p.getNamed();
        List<String> unnamedParams = p.getUnnamed();
        List<String> rawParameters = p.getRaw();

        String paramStr = "Jmenné parametry: " + namedParams + "\n" +
                "Nepojmenované parametry: " + unnamedParams + "\n" +
                "Raw parameters: " + rawParameters;

        TextArea ta = new TextArea(paramStr);
        Group root = new Group();
        stage.setScene(new Scene(root));
        stage.setTitle("Parametry (argumenty) aplikace");
        stage.show();
    }
}
