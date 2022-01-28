package cz.spsmb.w21.bindings;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CBidirectionalBinding {
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);

        System.out.println("před bindováním: ");
        System.out.println(" x="+x.get()+" y="+y.get()+" z="+z.get());

        x.bindBidirectional(y);
        System.out.println("po 1. bindování: ");
        System.out.println(" x="+x.get()+" y="+y.get()+" z="+z.get());

        x.bindBidirectional(z);
        System.out.println("po 2. bindování: ");
        System.out.println(" x="+x.get()+" y="+y.get()+" z="+z.get());

        System.out.println("po změně z: ");
        z.set(19);
        System.out.println(" x="+x.get()+" y="+y.get()+" z="+z.get());

        //odstranění bindování
        x.unbindBidirectional(y);
        x.bindBidirectional(z);
        System.out.println("Po odbindování a změně všech vlastností (x,y,z)");
        x.set(100);
        y.set(200);
        z.set(300);
        System.out.println(" x="+x.get()+" y="+y.get()+" z="+z.get());
    }
}
