package cz.spsmb.w24.nodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//bounds - velikost a pozice uzlů, existují 3 typy:
//layoutBounds - vlastnost, která je počítaná pouze z vlastností uzlu. Efekty jako ořezání, stíny a transformace se sem nepočítají.
//               miX a minY hodnoty budou vždy nulové. Příkladem budiž následující kód.
//boundsInLocal - k vlastnostem uzlu se zde připočítávají efekty (ořezání, stíny). Transformace nejsou započítávány.
//bundsInParent - k vlastnostem uzlu se zde připočítává vše včetně transformací.

public class ALayoutBoundsTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        int mode = 2;
        Button b1 = new Button("Close");
        b1.setEffect(new DropShadow());

        Button b2 = new Button("Close");

        Button b3 = new Button("Close");
        b3.setEffect(new DropShadow());
        b3.setRotate(30);

        Button b4 = new Button("Close");

        VBox root = new VBox();
        switch(mode){
            case 1:
                root.getChildren().addAll(b1, b2, b3, b4);
                break;
            case 2:
                //uzly s efekty uzavřu do Groupy. LayoutBounds Groupy je totiž sjednocením boundsInParent pro všechny její děti.
                //Pokud tedy chceme pro uzly dostatek místa pro zobrazení efektů a transformací, uzavřeme je do Groupy.
                root.getChildren().addAll(new Group(b1), b2, new Group(b3), b4);
                break;
        }


        Scene scene = new Scene(root,300,300);
        stage.setScene(scene);
        stage.setTitle("Testing LayoutBounds");
        stage.show();

        System.out.println("b1=" + b1.getLayoutBounds());
        System.out.println("b2=" + b2.getLayoutBounds());
        System.out.println("b3=" + b3.getLayoutBounds());
        System.out.println("b4=" + b4.getLayoutBounds());
    }
}
