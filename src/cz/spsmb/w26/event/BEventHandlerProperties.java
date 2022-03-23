package cz.spsmb.w26.event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
// Třídy Node, Scene a Window obsahují vlastnosti události k uložení "event handlerů" ´vybraných typů. Jsou pojmenovány
// onXXX. Např. onMouseClicked, onKeyTyped. Sice to kód yjednodušuje, ale platí následující omezení:
//  - podporují pouze handlery a ne filtry
//  - je možné pro uzel přidat jen jednu událost
//  - existují pouze pro često používané typy uzlů.
//  - neposkytují speciální metodu pro unregistraci handleru. Namísto toho nastavíme danou vlastnost na null.
public class BEventHandlerProperties extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle (100, 100, 50);
        circle.setFill(Color.CORAL);

        HBox root = new HBox();
        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using convenience event handler properties");
        stage.show();
        stage.sizeToScene();

        // Create a MouseEvent filter
        EventHandler<MouseEvent> eventFilter =
                e -> System.out.println("Mouse event filter has been called.");

        // Create a MouseEvent handler
        EventHandler<MouseEvent> eventHandler =
                e -> System.out.println("Mouse event handler has been called.");

        // Register the filter using the addEventFilter() method
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventFilter);

        // Register the handler using the setter method for
        // the onMouseCicked convenience event property
        circle.setOnMouseClicked(eventHandler);
    }
}
