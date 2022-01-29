package cz.spsmb.w22.observable_collections;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

//Pozorovatelné kolekce (Observable Collections) umožňují podobně jako vlastnosti pomocí
// implementovaného rozhraní Observable reagovat pomocí posluchače událostí na případné
// změny v kolekci. Prvky totiž mohou být přeházeny (permutated), aktualizovány (updated),
// nahrazeny (replaced), přidány (added), nebo vymazány (deleted).
// ObservableList - rozhraní, které implementuje rozhraní Observable a List. Výsledkem je obohacení
// metod známých z běžného seznamu o metody z rozhraní Observable
// addListener()
// removeListener()
// Třída implementující rozhraní ObservableList může být vytvořena následujícími statickými metodami
// třídy FXCollections:
// <E> ObservableList<E> emptyObservableList()
// <E> ObservableList<E> ObservableArrayList()
// <E> ObservableList<E> ObservableArrayList(Collection(? extends E) col)
// <E> ObservableList<E> ObservableArrayList(E... items)
// <E> ObservableList<E> ObservableList(List<E> list)
// <E> ObservableList<E> ObservableArrayList(Callback<E, Observable[]> extractor)
// <E> ObservableList<E> ObservableList(List<E> list, Callback<E, Observable[]> extractor)
//
// Poslední dvě metody vytvoří ObservableList, jehož prvky mohou být pozorovány při aktualizacích.
// k tomu je zde použito extraktoru pro výběr seznamu implementující rozhraní typu Observable
// k provedení aktualizace.
//
public class ASimpleListChangeTest {
    public static void main(String[] args) {
        //Vytvoření pozorovatelného seznamu
        ObservableList<String> list = FXCollections.observableArrayList();
        //Přidání posluchače změn k seznamu
        list.addListener(ASimpleListChangeTest::onChanged);
        //Manipulace se seznamem
        list.add("one");
        list.add("two");
        FXCollections.sort(list);
    }
    public static void onChanged(ListChangeListener.Change<? extends String> change){
        System.out.println("Seznam změněn.");
    }
}
