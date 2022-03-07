package cz.spsmb.w26.event;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.MOUSE_ENTERED_TARGET;
import static javafx.scene.input.MouseEvent.MOUSE_EXITED_TARGET;


// MOUSE_ENTERED   vygenerováno, pokud kurzor vjede na daný uzel. Neprovádí se capture a bubbling fáze.
// MOUSE_ENTERED_TARGET - totéž jako předchozí, ale s capture a bubbling fázemi.
// MOUSE_EXITED    vygenerováno, pokud kurzor vyjede z uzlu. Neprovádí se capture a bubbling fáze.
// MOUSE_EXITED_TARGET - totéž jako předchozí, ale s capture a bubbling fázemi.

public class MouseEnteredExitedTarget extends Application {

    private CheckBox consumeCbx = new CheckBox("Consume Events");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.GRAY);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, consumeCbx);

        // Create mouse event handlers
        EventHandler<MouseEvent> circleHandler = e -> handleCircle(e);
        EventHandler<MouseEvent> circleTargetHandler =
                e -> handleCircleTarget(e);
        EventHandler<MouseEvent> hBoxTargetHandler = e -> handleHBoxTarget(e);

        // Add mouse-entered-target and mouse-exited-target event
        // handlers to HBox
        root.addEventFilter(MOUSE_ENTERED_TARGET, hBoxTargetHandler);
        root.addEventFilter(MOUSE_EXITED_TARGET, hBoxTargetHandler);

        // Add mouse-entered-target and mouse-exited-target event
        // handlers to the Circle
        circle.addEventHandler(MOUSE_ENTERED_TARGET, circleTargetHandler);
        circle.addEventHandler(MOUSE_EXITED_TARGET, circleTargetHandler);

        // Add mouse-entered and mouse-exited event handlers to the Circle
        circle.addEventHandler(MouseEvent.MOUSE_ENTERED, circleHandler);
        circle.addEventHandler(MouseEvent.MOUSE_EXITED, circleHandler);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Entered Target and Exited Target Events");
        stage.show();
    }

    public void handleCircle(MouseEvent e) {
        print(e, "Circle Handler");
    }

    public void handleCircleTarget(MouseEvent e) {
        print(e, "Circle Target Handler");
    }

    public void handleHBoxTarget(MouseEvent e) {
        print(e, "HBox Target Filter");
        if (consumeCbx.isSelected()) {
            e.consume();
            System.out.println("HBox consumed the " + e.getEventType() + " event");
        }
    }

    public void print(MouseEvent e, String msg) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        System.out.println(msg + ": Type=" + type +
                ", Target=" + target +
                ", Source=" + source);
    }
}
