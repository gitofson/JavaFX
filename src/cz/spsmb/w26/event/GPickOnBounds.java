package cz.spsmb.w26.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


// Hystereze umožňuje uživatelským vstupům být v rozmezí času (hysteresis time), či lokace (hzsteresis area). Např.
// moderní GUI poskytují tzv. double-click. Mezi těmito 2 kliknutími je nějaká časová mezera (time gap).
// Pokud se tato časová mezera vejde do hystereyního času poskztovaného OS, jde o double-click. Jinak se jedná o dvě
// nezávislá kliknutí. Metoda isStillSinceProcess() vrací true, právě když myš zůstane v této OS deklarované hysterezní
// oblasti.

// Klávesové modifikátory - Alt, Shift, Meta (jen na Mac), Caps Lock, Num Lock
// boolean isAltDown()
// boolean isControlDown()
// boolean isMetaDown()
// boolean isShiftDown()
// boolean isShortcutDown()  - Ctrl klávesa ve win, Meta klávesa v Mac.

// Vlastnost pickOnBounds
// Ovládání toho, zda jsme klikli do ohraničení uzlu, nebo na jeho daný tvar je dán touto vlastností.
// Pokud je true, události se generují, pokud klikneme do ohraničení. Jinak na tvar. Následující program to
// demonstruje na kruhu a obdelníku, kde kruh je přidán do Group poyději, tudíž je "vepředu":


public class GPickOnBounds extends Application {
    private CheckBox pickonBoundsCbx = new CheckBox("Pick on Bounds");
    Circle circle = new Circle(50, 50, 50, Color.LIGHTGRAY);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.RED);

        Group group = new Group();
        group.getChildren().addAll(rect, circle);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(group, pickonBoundsCbx);

        // Add MOUSE_CLICKED event handlers to the circle and rectangle
        circle.setOnMouseClicked(e -> handleMouseClicked(e));
        rect.setOnMouseClicked(e -> handleMouseClicked(e));

        // Add an Action handler to the checkbox
        pickonBoundsCbx.setOnAction(e -> handleActionEvent(e));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pick on Bounds");
        stage.show();
    }

    public void handleMouseClicked(MouseEvent e) {
        String target = e.getTarget().getClass().getSimpleName();
        String type = e.getEventType().getName();
        System.out.println(type + " on " + target);
    }

    public void handleActionEvent(ActionEvent e) {
        if (pickonBoundsCbx.isSelected()) {
            circle.setPickOnBounds(true);
        }
        else {
            circle.setPickOnBounds(false);
        }
    }
}
