package cz.spsmb.w21;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoundProperty {
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(10);
        IntegerProperty y = new SimpleIntegerProperty(20);
        IntegerProperty z = new SimpleIntegerProperty(60);
        //bindování na typ IntegerProperty
        z.bind(x.add(y));
        System.out.println("Po bindování z : Bound = " + z.isBound() +  ", z = " + z.get());
        //změna x a y
        x.set(15);
        y.set(19);
        System.out.println("Po změně x a y : Bound = " + z.isBound() +  ", z = " + z.get());
        //unbind z
        z.unbind();
        //z již ovlivňováno hodnotami x a y nebude
        x.set(100);
        y.set(200);
        System.out.println("Po odbindování z : Bound = " + z.isBound() +  ", z = " + z.get());
    }
}
