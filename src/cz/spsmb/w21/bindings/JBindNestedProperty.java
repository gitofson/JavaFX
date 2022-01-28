package cz.spsmb.w21.bindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// selectXXX() metoda třídy Bindings - používá se pro vytvoření vazby nějaké vnořené vlastnosti.
// Mějme třídu Address, která má vlastnost ZIP a třídu Person, která má vlastnost addr:
public class JBindNestedProperty {
    public static class Address {
        private StringProperty zip = new SimpleStringProperty("29301");
        public StringProperty zipProperty() {
            return this.zip;
        }
        public String getZip() {
            return this.zip.get();
        }
        public void setZip(String zip) {
            this.zip.set(zip);
        }
    }
    public static class Person {
        private ObjectProperty<Address> addr = new SimpleObjectProperty<>(new Address());
        public ObjectProperty<Address> addrProperty() {
            return this.addr;
        }
        public Address getAddr() {
            return this.addr.get();
        }

        public void setAddr(Address addr) {
            this.addr.set(addr);
        }
    }

    public static void main(String[] args) {
        ObjectProperty<Person> p = new SimpleObjectProperty(new Person());
        //vytvoření vazby na p.addr.zip
        StringBinding zipBinding = Bindings.selectString(p, "addr", "zip");
        System.out.println(zipBinding.get());

        //změna PSČ:
        p.get().addrProperty().get().setZip("27751");
        System.out.println(zipBinding.get());

        //vytvoření neexistující vazby nap.addr.state (stateBindings.get() vrátí null)
        StringBinding stateBinding = Bindings.selectString(p,"addr","state");
        //NoSuchMethodException:
        System.out.println(stateBinding.get());
    }
}
