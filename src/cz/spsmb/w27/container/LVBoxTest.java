package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// VBox umisťuje svoje poduzly (children) v jednoduché vertikální řadě. Můžeme zadat vertikální šiřku mezer mezi
// poduzly, okraje (margins) poduzlům, chování při změně velikosti poduzlů apod. Výchozí výška VBoxu je taková, aby
// zobrazila všechny poduzly v jejich preferované výšce. Výchzí šířka je pak podle neširšího poduzlu.

// následující program ukazuje jak VBox použít. Přidá Label, TextField a dvě tlačítka. Nastaví vertikální šiřku
// mezer mezi poduzly (spacing) na 10 px;

// Vlastnost fillWidth třídy HBox rozšiřuje v případě hodnoty true (výchozí) poduzly horizontálně tak,
// aby došlo k vyplnění celé šířky VBoxu. Jinak je použit preffered width. Potřeba však je ještě nastavit maximum width
// tam, kde je shodná s preffered width (tlačítko v tomto případě). Při horizonálním roztažení VBoxu zde tlačítka
// zůstanou z tohoto důvodu stejná TextField se rozšíří.
public class LVBoxTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        VBox root = new VBox(10); // 10px spacing
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using VBox");
        stage.show();
    }
}
