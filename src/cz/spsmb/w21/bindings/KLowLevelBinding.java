package cz.spsmb.w21.bindings;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Formatter;
import java.util.Locale;

// vyskokoúrovňové vazby (bindování) nemusí vždy poskytovat vše potřebné (např. odmocnina z Observable čísla). Nízkoúrovňové
// API nám tak umožňuje využít plný potenciál javy vazbu (binding) nadefinovat.
// Následující 3 kroky jsou potřeba pro použití nízkoúrovňového API:
// 1. Vytvoření třídy, která je potomkem jedné z vazebních (binding) tříd.
// 2. Zavolat metodu bind() z rodičovské třídy
// 3. Překrýt metodu computeValue(). Sem píšeme logiku samotné vazby.
public class KLowLevelBinding {
    public static void main(String[] args) {
        final DoubleProperty r = new SimpleDoubleProperty(7.0);
        final DoubleProperty area = new SimpleDoubleProperty(0);
        //krok 1:
        DoubleBinding areaBinding = new DoubleBinding() {
            //krok 2 v instančním inicializátoru:
            {
                this.bind(r);
            }
            //krok 3:
            @Override
            protected double computeValue() {
                double rTmp = r.get();
                double areaTmp = Math.PI * rTmp * rTmp;
                return areaTmp;
            }
        };
        //navázání (přibindování) plochy na areaBinding
        area.bind(areaBinding);

        //vytvoření StringBinding
        StringBinding desc = new StringBinding() {
            {
                this.bind(r, area);
            }

            @Override
            protected String computeValue() {
                Formatter f = new Formatter();
                        f.format(Locale.US, "Poloměr = %.2f, Plocha = %.02f", r.get(), area.get());
                String desc = f.toString();
                return desc;
            }

            @Override
            public ObservableList<?> getDependencies() {
                return FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(r, area));
            }

            @Override
            public void dispose() {
                System.out.println("Description binding is disposed.");
            }

            @Override
            protected void onInvalidating() {
                System.out.println("Description is invalid.");
            }
        };
        System.out.println(desc.getValue());

        //změna poloměru
        r.set(14.0);
        System.out.println(desc.getValue());
    }
}
