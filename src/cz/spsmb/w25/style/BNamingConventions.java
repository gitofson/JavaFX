package cz.spsmb.w25.style;
// Veškeré třídy stylů jsou malým písmem. Například jméno třídy stylu a vlastně v tommto případě i selektor je button a
// rerezentuje Java třídu Button. V případě víceslovného názvu, např TextField, je vložena mezi tyto slova pomlčka. Např.
// TextField a CheckBox Java třídy vedou na třídy stylů text-field a check-box.

// Jména vlastností v JavaFX začínají na -fx-
// Style sheets jsou vkládány buď do scény (třída Scene), nebo do Parent tříd pomocí metody getStylesheets().add(...)

// Výchozí style sheet se jmenuje modena.css (default stylesheet, user-agent stylesheet) a je zabalen v souboru
// jfxrt.jar
// Do JavaFX 8 byl výchozí style sheet Caspian.
// Třída Application definuje dvě String konstanty STYLESHEET_CASPIAN a STYLESHEET_MODENA. Násedující dvě metody s tím pracují:
// public static void setUserAgetStylesheet(String url)
// public static String getUserAgentStylesheet()

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class BNamingConventions extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("tlacitko");
        VBox root = new VBox();
        root.getChildren().addAll(b1);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
        stage.show();
    }
}
