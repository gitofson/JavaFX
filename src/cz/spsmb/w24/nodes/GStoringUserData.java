package cz.spsmb.w24.nodes;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.function.BiConsumer;
// Uzly v sobě mají implementovánu observable mapu pro uživatelsky definované vlastnosti. Lze sem cokoliv užitečného vkládat.

public class GStoringUserData extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField nameField = new TextField();
        ObservableMap<Object, Object> props = nameField.getProperties();
        props.put("originalData", "Advik");
        printProps(nameField);

        //toto z nějakého důvodu nefunguje:
        //nameField.setUserData("Saved");
    }
    public static void printProps(Node n){
        ObservableMap<Object, Object> props = n.getProperties();
        if(n.hasProperties()) {
            System.out.println("getProperties:");
            props.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object o, Object o2) {
                    System.out.println(o.toString() + " -> " + o2.toString());
                }
            });
        }
        //System.out.println("userData:");
        //System.out.println(n.getUserData());
    }
}
