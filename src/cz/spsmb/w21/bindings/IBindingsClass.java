package cz.spsmb.w21.bindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Locale;


// Třída Bindings poskytuje mnoho statických pomocných metod pro vytvoření jednoduchých vazeb (bindigs)
// add(), substract(), multiple(), divide()     - vazby pomocí aritmetických operací
// and()    - výsledkem je instance třídy BooleanBinding (logická operace)
// bindBidirectiona(), unbindBidirectional()    - vytvořené obousměrné vazby
// concat() - výsledek je instance třídy StringExpression, která poskytuje hodnodu výsledného složení argumentů.
// convert()    - výsledek je instance třídy StringExpression, jako wrapper vstupního argumentu
// createXXXbinding()   - vytvoření vazby typu XXX, kde XXX může být Boolean, Double, Float, Integer, String, nebo Object
// equal(), notEqual(), equalIgnoreCase(), notEqualIgnoreCase() - výsledkem je instance třídy BooleanBinding. Některé metody
//      poskytují argument pro toleranci při použití pro porovnání reálných čísel.
// format() - výsledek je instance třídy StringExpression, poskytující reprezenaci více objektů formátovaných dle formátovacího
//      řetězce.
// greaterThan(), greaterThanOrEqual(), lessThan(), lessThanOrEqual()   - výsledkem je instance třídy BooleanBinding, která
//      reprezentuje výsledek mezi 2 argumenty
// isNotNull(), isNUll()    - výsledkem je instance třídy BooleanBinding, která vrací výsledek po porovnání s hodnotou null.
// max(), min() - vytvoří vazbu, která poskytuje daný výsledek. Jeden z argumentů musí být instance třídy posk. rozhr.
//      ObservableNumberValue.
// negate() - výsledkem je instance třídy NumberBinding, který poskytuje negaci argumentu  třídy posk. rozhr. ObservableNumberValue
// not()    - výsledkem je instance třídy BooleanBinding, který poskytuje výsledek opaku argumentu třídy posk. rozhr. ObservableNumberValue
// or()     - výsledkem je instance třídy BooleanBinding, který poskytuje výsledek dvou argumentů  tříd posk. rozhr. ObservableNumberValue
// selectXXX()  - vytvoří vazbu pro výběr vnitřní vlastnosti (nested property). Lépe uvedeno na příkladu.
// when()   - Vytvoří instanci třídy When. Podmínka je argumentem.
public class IBindingsClass {
    public static void main(String[] args) {
        DoubleProperty r = new SimpleDoubleProperty(7.0);
        DoubleProperty area = new SimpleDoubleProperty(0.0);
        //Vytvoření vazby plochy na výraz, který jí vypočítá
        area.bind(Bindings.multiply(Bindings.multiply(r,r), Math.PI));
        //Vytvoření popisu kruhu pomocí třídy StringExpression
        StringExpression desc = Bindings.format(Locale.US, "poloměr = %.2f, Area = %.2f", r, area);
        System.out.println(desc.get());
        //změna poloměru
        r.set(14.0);
        System.out.println(desc.getValue());
    }
}
