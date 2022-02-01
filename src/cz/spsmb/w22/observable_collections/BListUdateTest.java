package cz.spsmb.w22.observable_collections;
//Třída ListChangeListener.Change
//
//Často nepotřebujeme jen zjistit, že "se něco změnilo", ale i k jaké konkrétní změně došlo. Instance třídy
//ListChangeListener.Change, která je paramterem metody onChanged() nabízí pro tento účel následující metody:

//ObservableList<E> getList()       - vrací seznam po provedených změnách. Např. 2 příkazy list.addAll("1","2","3"); list.removeAll("1", "3" )
//                                    představují právě 2 změny.
//boolean next()                    - pohyb kurzoru. Každý stav reoprezentuje jednu změnu.
//boolean reset()
//boolean wasAdded()                - sděluje k jaké změně došlo.
//boolean wasRemoved()
//boolean wasReplaced()
//boolean wasPermutated()
//boolean wasUpdated()
//int getFrom()                     - vrací rozsah indexů prvků, kde byla provedena změna.
//int getTo()
//int getAddedSize()                - vrací počet přidaných prvků.
//List<E> getAddedSubList()         - vrací podseznam přidaných prvků.
//List<E> getRemoved()              - vrací podseznam odebraných prvků.
//int getRemovedSize()              - vrací počet odebraných prvků.
//int getPermutation(int oldIndex)  - vrací nový index prvku po přemístění. Např. pokud se prvek z pozice 2 přemístil na
//                                    pozici 5, getPermutation(2) vrátí 5.

// Pro detekci aktualizace prvku v Seznamu je potřeba použít jednoho z těchto inicializátorů observable seznamů:
// <E> ObservableList<E> ObservableArrayList(Callback<E, Observable[]> extractor)
// <E> ObservableList<E> ObservableList(List<E> list, Callback<E, Observable[]> extractor)
// kde rozhraní Callback<P, R> je deklarováno tako:
//public interface Callback<P, R> {
//    R call(P param)
//}

//V observable množinách a mapách se extraktor ani kurzor nepoužívá. Tudíž jsou tak mnohem jednodušší.

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.util.List;

public class BListUdateTest {
    public static void main(String[] args) {
        //Vytvoření extraktoru pro IntegerProperty. Bez tohoto není možné dostat událost o změně prvku. Pole totiž musí
        //být typu Observable[]
        Callback<IntegerProperty, Observable[]> extractor = new Callback<IntegerProperty, Observable[]>() {
            @Override
            public Observable[] call(IntegerProperty p) {
                System.out.println("Extraktor byl volán pro " + p);
                //zabalení parametru p do pole Observable[] a navrácení
                return new Observable[]{p};
            }
        };
        //Vytvoření prázdného observable (pozorovatelného) seznamu s callbackem pro extrakci observable (pozorovatelných)
        // hodnot pro každý prvek
        ObservableList<IntegerProperty> list = FXCollections.observableArrayList(extractor);
        //bez extraktoru detekce aktualizace prvku fungovat nebude
        //ObservableList<IntegerProperty> list = FXCollections.observableArrayList();
        System.out.println("Před přidáním prvků...");
        IntegerProperty p1 = new SimpleIntegerProperty(10);
        IntegerProperty p2 = new SimpleIntegerProperty(20);
        list.addAll(p1, p2); //Zde se bude 2x volat call() metoda extraktoru. Jednou pro p1 a jednou pro p2.
        System.out.println("Po přidání prvků...");

        //Přidání changeListeneru do seznamu
        list.addListener(BListUdateTest::onChanged);

        //Aktualizace p1 z hodnoty 10 na 100 vyhodí událost typu akualizace seznamu
        p1.set(100);

    }
    public static void onChanged(ListChangeListener.Change<? extends IntegerProperty> change) {
        System.out.println("Seznam je " + change.getList());
        //Pracujeme pouze s aktualizacemi (updates) seznamu
        while (change.next()) {
            if(change.wasUpdated()){
                //Výpis detailu aktualizace
                System.out.println("Aktualizace detekována.");
                int start = change.getFrom();
                int end = change.getTo();
                System.out.format("Rozsah aktualizace: [%d, %d]%n", start, end);
                List<? extends IntegerProperty> updatedElementsList;
                updatedElementsList = change.getList().subList(start, end);
                System.out.println("Aktualizované prvky: " + updatedElementsList);
            }
        }
    }
}
