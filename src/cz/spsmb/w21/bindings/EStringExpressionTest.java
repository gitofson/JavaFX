package cz.spsmb.w21.bindings;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Locale;

public class EStringExpressionTest {
    public static void main(String[] args) {
        DoubleProperty r = new SimpleDoubleProperty(7.0);
        DoubleProperty area = new SimpleDoubleProperty(0);
        StringProperty initStr = new SimpleStringProperty("Plocha= ");
        //bindování plochy k výrazu výpočtu plochy kruhu:
        area.bind(r.multiply(r).multiply(Math.PI));
        //vytvořerní StrinExpression pro popis kružnice:
        StringExpression desc = initStr.concat(r.asString())
                .concat(", Plocha = ")
                .concat(area.asString(Locale.US, "%.2f"));
        System.out.println(desc.getValue());
        //změna poloměru
        r.set(14.0);
        System.out.println(desc.getValue());
    }
}
