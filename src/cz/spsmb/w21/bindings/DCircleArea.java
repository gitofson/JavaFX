package cz.spsmb.w21.bindings;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Locale;

//Rozhraní pro bindování je
// -vysokoúrovňové - Fluent API a Binding class - častěji používanější pro jednoduchost
// -nízkoúrovňové - umnožňuje vytvořit vlastní logiku pro bindování
public class DCircleArea {
    public static void main(String[] args) {
        DoubleProperty r = new SimpleDoubleProperty(7);
        DoubleBinding area = r.multiply(r).multiply(Math.PI);
        System.out.format("r= %f, area= %f%n", r.get(), area.get());
        //změna poloměru:
        r.set(14.0);
        System.out.format("r= %f, area= %f%n", r.get(), area.get());

        //Totéž pro vlastnost (DoubleProperty) s metodou .bind()
        DoubleProperty area2 =new SimpleDoubleProperty();
        area2.bind(r.multiply(r).multiply(Math.PI));
        System.out.format("r= %f, area= %f%n", r.get(), area2.get());

        //Bindování Stringu:
        StringProperty initStr = new SimpleStringProperty("Poloměr= ");
        StringExpression desc = initStr.concat(r.asString())
                .concat(", Plocha = ")
                .concat(area2.asString(Locale.US, "%.2f"));
        System.out.println(desc.getValue());
        //změna poloměru
        r.set(18.0);
        System.out.println(desc.getValue());
    }

}
