package cz.spsmb.w25.style;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// CSS poskytuje syntaxi k psaní pravidel k nastavení výsledného vizuálního vzhledu jednotlivých komponent.
// Pravidlo se skádá ze selektoru (selector) a množiny párů vlastnost-hodnota (property-value). Např. v zde
// použitém příkladu (resources/css/buttonstyles.css):
// .button {
//    -fx-background-color: red;
//    -fx-text-fill: white;
// }

// Styly (styles) - poskytují mechanismus jak definovat jednotlivé grafické (UI) elementy. JavaFX umožňuje seskupování,
//      takže je možné daná nastavení sdílet mezi těmito elementy.
// Skiny (skins)  - jsou kolekcí jednotlivých aplikačně-specifických stylů a definují samotný vzhled aplikace.
// Themes         - jsou vyzuální charakteristiky v rámci operačního systému, které definují vzhled grafických elementů
//      všech aplikací v rámci OS. JAvaFX nedisponuje podporou pro themes.
public class AButtonStyleTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        HBox root = new HBox();
        root.getChildren().addAll(yesBtn, noBtn, cancelBtn);

        Scene scene = new Scene(root);

        // Add a style sheet to the scene
        scene.getStylesheets().add("css/buttonstyles.css");
        //scene.getStylesheets().add("css/button_hover.css");

        stage.setScene(scene);
        stage.setTitle("Styling Buttons");
        stage.show();
    }
}