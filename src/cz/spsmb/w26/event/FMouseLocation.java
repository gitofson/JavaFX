package cz.spsmb.w26.event;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
// Uzly zpravidla spouštějí uživatelské handlery před tím, než vykonají výchozí akci. Např. pokud registrujeme pro uzel
// třídy TextField handler k události typu "key typed", který událost zkonzumuje, tak se nám napsaný znak v tomto uzlu
// neobjeví.

//Události myši:
// ANY           - supertyp. Pokud chceme reagovat na všechny typy události myši, registrujeme.
// MOUSE_PRESSED - stisknutí tlačítka. Metoda getButton() pak vrátí které tlačítko bylo stisknuto (NONE, PRIMARY,
//                 MIDDLE a SECONDARY). Další užitečné metody: int getClickCount() (vrátí počet kliků), boolean
//                  isPrimaryButtonDown(), boolean isMiddleButtonDown(), boolean isSecondaryButtonDown(),
//                  isPopupTrigger(), isStillSincePress().
// MOUSE_RELEASED  uvolnění tlačítka. Událost doručena pouze uzlu, kde tlačítko bylo stitknuto.
// MOUSE_CLICKED   tlačítko musí být stisknuto a uvolněno na stejném uzlu, aby se událost vyvolala.
// MOUSE_MOVED     pouze přejetí myši nad daným uzlem bez stisknutí tlačítka
// MOUSE_ENTERED   vygenerováno, pokud kurzor vjede na daný uzel. Neprovádí se capture a bubbling fáze.
// MOUSE_ENTERED_TARGET - totéž jako předchozí, ale s capture a bubbling fázemi.
// MOUSE_EXITED    vygenerováno, pokud kurzor vyjede z uzlu. Neprovádí se capture a bubbling fáze.
// MOUSE_EXITED_TARGET - totéž jako předchozí, ale s capture a bubbling fázemi.
// DRAG_DETECTED   tlačítko stisknuto a taženo. Prah je učen platformou
// MOUSE_DRAGGED   pohyb myší se stisknutým tlačítkem

// Pro zjištění lokace myši používáme metody:
// getX(), getY()            - souřadnice vztaženy k "event source" uzlu
// getSceneX(), getSceneY()  - relativní ke scéně
// getScreenX(), getScreenY()- relativní k obrazovce, kam byl uzel přidán
public class FMouseLocation extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle (50, 50, 50);
        circle.setFill(Color.CORAL);

        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.TAN);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect);

        // Add a MOUSE_CLICKED event handler to the stage
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseMove(e));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Location");
        stage.show();
    }

    public void handleMouseMove(MouseEvent e) {
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();

        // Mouse location relative to the event source
        double sourceX = e.getX();
        double sourceY = e.getY();

        // Mouse location relative to the scene
        double sceneX = e.getSceneX();
        double sceneY = e.getSceneY();

        // Mouse location relative to the screen
        double screenX = e.getScreenX();
        double screenY = e.getScreenY();

        System.out.println("Source=" +  source + ", Target=" + target +
                ", Location:" +
                " source(" + sourceX + ", " + sourceY + ")" +
                ", scene(" + sceneX + ", " + sceneY + ")" +
                ", screen(" + screenX + ", " + screenY + ")");
    }
}
