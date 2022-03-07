package cz.spsmb.w26.event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//Pro události rozlišujeme následující třídy, resp. rozhraní:
// Event        třída   - Instance této třídy reprezentuje událost (event). Existuje několik podtříd pro reprezentaci
//                        specifických typů událostí. Např: InputEvent (podtřídy KeyEvent, MouseEvent a TouchEvent),
//                        WindowEvent, ActionEvent
// EventTarget  rozhraní- instance tohoto rozhraní reprezentuje definovaný cíl události. Jedná se o nějaký UI element
//                        a nemusí nutně jít vždy o uzel, který může nějak reagovat na událost. Třídy Window, Scene a
//                        Node implementují rozhraní EventTarget. Toto royhraní je také zodpovědné za vybudování tzv.
//                        řetězu dispečerů událostí (chain of event dispatchers). Každý z těchto dispečerů pak můče
//                        událost obsloužit, či zkonzumovat.
// EventType    třída   - instance této třídy reprezentuje typ. (mouse pressed, mouse released, mose moved)
// EventHandler rozhraní- instance tohoto rozhraní repreyentuje buď tzv event handler, nebo tzv. event filter. Jeho
//                        metoda handle() je volána, pokud událost nastane a handler,či filtr je k události registrován.

public class AEventRegistration extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle (100, 100, 50);
        circle.setFill(Color.CORAL);

        // Create a MouseEvent filter
        EventHandler<MouseEvent> mouseEventFilter =
                e -> System.out.println("Mouse event filter has been called.");

        // Create a MouseEvent handler
        EventHandler<MouseEvent> mouseEventHandler =
                e -> System.out.println("Mouse event handler has been called.");

        // Register the MouseEvent filter and handler to the Circle
        // for mouse-clicked events
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

        HBox root = new HBox();
        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registering Event Filters and Handlers");
        stage.show();
        stage.sizeToScene();
    }
}