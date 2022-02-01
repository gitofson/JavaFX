package cz.spsmb.w22.observable_collections;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

//Možnost navázání se na daný prvek třídy ObservableList obalený třídou ListProperty je poskytnuta následujícími metodami
// třídy ListExpression:
//ObjectBinding<E> valueAt(int index)
//ObjectBinding<E> valueAt(ObservableIntegerValue index)    - zde se index může v čase měnit.
public class HBindingToListElements {
    public static void main(String[] args) {
        ListProperty<String> lp =
                new SimpleListProperty<>(FXCollections.observableArrayList());

        // Create a binding to the last element of the list
        ObjectBinding<String> last = lp.valueAt(lp.sizeProperty().subtract(1));
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.add("John");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.addAll("Donna", "Geshan");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.remove("Geshan");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.clear();
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());
    }
}
