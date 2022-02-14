package cz.spsmb.w24.scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Pouze jeden uzel ve scéně můžem být vlastníkem "focusu" (focus owner). Vlastnost focusOwner třídy
//Scene je read-only. Pokud danému uzlu chceme dát focus vlastníka, musíme zavolat metodu
// requestFocus() daného uzlu.
//Scéna nemusí mít focus vlastníka, pak metoda getFocusOwner() vrací null.
//Je rozdíl "být vlastníkem focus" a "mít focus". V jeden čas může "mít focus" ve víceokenním systému
// pouze jeden uzel.
public class CFocusOwner extends Application {
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Button btn1 = new Button("Tlač1");
        Button btn2 = new Button("Tlač2");
        Button btn3 = new Button("Tlač3");
        btn1.setOnAction(this::printFocusInfo);
        btn2.setOnAction(this::printFocusInfo);
        btn3.setOnAction(this::printFocusInfo);
        this.scene = new Scene(new VBox(btn1, btn2, btn3));
        stage.setScene(scene);
        stage.show();
    }
    public void printFocusInfo(ActionEvent actionEvent){
        Node focusOwnerNode = this.scene.getFocusOwner();
        if(focusOwnerNode == null) {
            System.out.println("Scéna nemá focus owner");
        } else if (focusOwnerNode.isFocused()) {
            System.out.println("Focus owner je: " + focusOwnerNode.toString() + " a má focus");
        } else {
            System.out.println("Focus owner je: " + focusOwnerNode.toString());
        }
    }

}
