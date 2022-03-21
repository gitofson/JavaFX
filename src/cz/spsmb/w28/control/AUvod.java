package cz.spsmb.w28.control;
// Aplikace s GUI umožňuje následující akce:
// - přijímat vstupy od uživatele zkrz vstupní zařízení (klávesnice, myš)
// - zpracovat tyto vstupy
// - zobrazit výstup
// Ovládací prvky (controls, widgets) jsou právě elementy, zkrz ktreré uživatel s aplikací kominikuje. Namátkou se
// jedná o buttons, labels, text fields, text area, radio buttons a check boxes.

// Typicky je v JavaFX použit tzv. MVP (Model-View-Presenter) návrh. Ten vyžaduje použití 3 samostatných tříd a zde ho
// kvůli úspoře místa používat nebudeme.

// Labeled controls - zobrazují pouze read-only textový obsah a volitelně i grafický jako součíst UI. Například Label,
// Button, CheckBox, RadiButton a Hyperlink.
// Vlastnosti:
// alignment        ObjectProperty<Pos>     - specifikace zarovnání obsahu, výchozí hodnota Pos.CENTER_LEFT
// contentDisplay   ObjectProperty<ContentDisplay> - specifikace pozice grafiky vzhledem k textu.
// ellipsisString   StringProperty          - Specifikace co se má zobrazit, pokud je velikost prvku menší, než
//                                            preffered size. Výchozí hodnota "...".
// font             ObjectProperty<Font>
// graphics         OjectProperty<Node>     - specifikace volitelné ikony ovl. prvku.
// graphicsTextGap  DoubleProperty          - mezera mezi textem a obrázkem.
// labelPadding     ReadOnlyObjectProperty<Insets> - padding okolo oblasti obsahu. Vých. hodnota Insets.EMPTY.
// lineSpacing      DoubleProperty          - pokud má prvek více řádek, specifikuje výšku mezi nimi.
// mnemonicParsing  BooleanProperty         - pokud je true (default), písmeno za znakem "_" v textu prvku slouží jako
//                                            mnemonické. Stisk klávesy Alt ve Windows zvýrazní všechny mnem. znaky v app.
// textAlignment    ObjectProperty<TextAlignment> - zarovnání textu pro více řádků.
// textFill         ObjectProperty<Paint>   - barva textu.
// textOverrun      ObjectProperty<OverrunStyle> - specifikace způsobu zobrazení textu, pokud obsah překročí dostupné místo.
// text             StringProperty          - specifikace textového obsahu.
// underline        BooleanProperty         - podtržený text.
// wrapText         BooleanProperty         - odřádkování, pokud se text nevejde na jednu řádku.
public class AUvod {
}
