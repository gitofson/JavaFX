package cz.spsmb.w24.scenes;
// scene reprezentuje vizuální obsah stage. Třída Scene z balíku javafx.scene reprezentuje scénu v JavaFX aplikaci. Instance
// třídy Scene je přiřazena (attached) maximálně k jedné stage v daný okamžik. Stejně tak stage může mít přiřazenu pouze jednu
// scénu.
// Scéna obsahuje stromovou strukturu grafu scény (scene graph), která se skládá z uzlů (nodes). Tyto uzly jsou ve vzájemném propojení typu
// rodič - dítě. Rozlišujeme 2 typy uzlů:
// - typ větev (branch node) - může mít další uzly (děti) pod sebou
// - typ lístek (leaf node) - poslední uzel, nemá pod sebou další uzly
//Scéna vždy obsahuje kořenový uzel (root node). Pokud je může měnit velikost (resizable) (např. Region, Control), jeho velikost
// je dána velikostí scény.
// Třída Group nemůže měnit velikost a může být zvolena pro scénu  jako kořenová. Potom je obsah grafu scény ořezán na velikost
// scény.
// Abstraktní třída Parent je základdní třídou pro všechny uzly typu větev. Tyto třídy (potomci) se často používají:
// Group
// Pane
// HBox
// VBox

//Třídy, které jsou potomkem základní třídy Node, ale nikoliv Parent jsou typu lístek:
// Rectangle
// Circle
// Text
// Canvas
// ImageView

//Běžně používané vlastnosti ze třídy Scene:

//ObjectProperty<Cursor>            cursor      definuje kurzor myši uvnitř scény
//ObjectProperty<Paint>             fill        definuje parvu pozadí scény
//ReadOnlyObjectProperty<Node>      focusOwner  definuje uzel scény, který vlastní "focus"
//ReadOnlyDoubleProperty            height      definuje výšku scény
//ReadOnlyDoubleProperty            width       definuje šířku scény
//ObjectProperty<Parent>            root        definuje kořenový uzel scény
//ReadOnlyDoubleProperty            x           definuje horizontální pozici scény v okně
//ReadOnlyDoubleProperty            y           definuje vertikální pozici scény v okně


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

public class AUvod extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //URL url = this.getClass().getClassLoader().getResource("picture/node_tree.png");
        //Image image = new Image("/home/ste/IdeaProjects/JavaFX/src/resources/picture/node_tree.png");
        //Image image = new Image(url.toExternalForm());
        FileInputStream fis = new FileInputStream("src/resources/picture/node_tree.png");
        Image image = new Image(fis);
        fis.close();
        ImageView imageView = new ImageView(image);
        HBox root = new HBox(imageView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
