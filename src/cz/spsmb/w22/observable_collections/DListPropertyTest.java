package cz.spsmb.w22.observable_collections;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
// Rozhraní ObservableList, ObservableSet a ObservableMap mohou být rozšířeny o rozhraní Property. Získáváme tak
// rozhraní, které podporuje vysokoúrovňové i nízkoúrovňové bindování (vazbu).

//Konstruktory třídy SimpleListProperty pro vytvoření instance (potomka) třídy ListProperty:
//SimpleListProperty()
//SimpleListProperty(ObservableList<E> initialValue)
//SimpleListProperty(Object bean, String name)
//SimpleListProperty(Object bean, String name, ObservableList<E> initialValue)

// K instanci třídy impl. rozhraní ListProperty je možné nastavit následující posluchače (listeners):
//InvalidationListener - to lze ke všemu, co implementuje rozhraní Observable
//ChangeListener
//ListChangeListener

//Demonstrace všech tří uvedena v příkladu:
public class DListPropertyTest {
    public static void main(String[] args) {
        // Create an observable list property
        ListProperty<String> lp =
                new SimpleListProperty<>(FXCollections.observableArrayList());
        // Add invalidation, change, and list change listeners
        lp.addListener(DListPropertyTest::invalidated);
        lp.addListener(DListPropertyTest::changed);
        lp.addListener(DListPropertyTest::onChanged);

        System.out.println("Before addAll()");
        lp.addAll("one", "two", "three");
        System.out.println("After addAll()");

        System.out.println("\nBefore set()");

        // Replace the wrapped list with a new one
        lp.set(FXCollections.observableArrayList("two", "three"));
        System.out.println("After set()");

        System.out.println("\nBefore remove()");
        lp.remove("two");
        System.out.println("After remove()");
    }

    // An invalidation listener
    public static void invalidated(Observable list) {
        System.out.println("List property is invalid.");
    }

    // A change listener
    public static void changed(ObservableValue<? extends ObservableList<String>> observable,
                               ObservableList<String> oldList,
                               ObservableList<String> newList) {
        System.out.print("List Property has changed.");
        System.out.print(" Old List: " + oldList);
        System.out.println(", New List: " + newList);
    }

    // A list change listener
    public static void onChanged(ListChangeListener.Change<? extends String> change) {
        while (change.next()) {
            String action = change.wasPermutated() ? "Permutated"
                    : change.wasUpdated() ? "Updated"
                    : change.wasRemoved() && change.wasAdded() ? "Replaced"
                    : change.wasRemoved() ? "Removed" : "Added";

            System.out.print("Action taken on the list: " + action);
            System.out.print(". Removed: " + change.getRemoved());
            System.out.println(", Added: " + change.getAddedSubList());
        }
    }
}
