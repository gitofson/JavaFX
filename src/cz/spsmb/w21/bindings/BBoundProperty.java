package cz.spsmb.w21.bindings;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
// Rozhraní NumberExpression obsahuje následující metody pro vytvoření vazby (bindování):
// návratový typ NumberBinding:
// add(), substract(), multiply(), divide() - vytvoření požadované vazby typu NumberExpression
// návratový typ: BooleanBinding:
// graterThan(), greaterThanOrEqualTo(), isEqualTo(), lessThan(), lessThanOrEqualTo()
// návratový typ: NumberBinding:
// negate()     - vytvoří novou třídu NumberBinding, která je negací NumberExpression
// návratový typ: StringBinding:
// asString()   - vytvoří vazbu typu StringBinding, která reprezentuje hodnotu typu NumberExpression
//
public class BBoundProperty {
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
