package cz.spsmb.w27.container;
// Rozmístění uzlů (layout) ve stromu scény je dvojího typu:
// Statické - velikost a pozice uzlů je vypočítána pouze jednou a nijak se nemění i když celé okno změní velikost.
//            Výhodou je dát vývojáři k dispozici libovolný vzhled aplikace.
// Dynamické - uzly jsou rozmisťovány a přizpůsobovány po každé  uživatelské iterakci, která to vyžaduje. Takto je
//             možné přizpůsobovat velikost a rozmístění uzlů, když celé okno mění rozměry. Vyžaduje větší
//             programátorské úsilí, nicméně aplikace se dopře přizpůsobuje pro různá roylišení, či uživatelem
//             nastavované velikosti oken.

// LayoutPane je uzel, který obsahuje další uzly (děti) a plně zodpovídá za jejich rozmístění. Říkáme mu také kontejner
// (container, lauyout container). Má tzv. layout policy, která ovládá jak budou children uzly rozmístěny (např.
// horizontálně, vertikálně, či jinak). Znamená to, že vypočítá
// - pozici (x, y souřadnice) uzlu uvnitř rodiče
// - velikost (width, height) uzlu uvnitř rodiče.
// uzel má tři velikosti: minimum size, maximum size a prefferedd size. Většina kontejnerů se pokouší dát
// poduzlům jejich preffered size. Ta ale může být pozměněna na základě velikosti okna, layout policy kontejneru,
// expanding/shrinking policy atd..

// Přidání poduzlů (children) do Layout Pane
// vytvoření dvou tlačítek
// Button okBtn = new Button("OK");
// Button cancelBtn = new Button("Cancel");

// Vytvoření HBox s 2 tlačítky jako poduzly:
// HBox hBox1 = new HBox(okBtn, cancelBtn);

// Vytvoření HBox s 2 tlačítky a mezerou 20px mezi nimi
// double hSpacing = 20;
// HBox hBox2 = new HBox(hSpacing, okBtn, cancelBtn);

// Vytvoření prázdného HBox a přidání 2 tlačítek později:
// Hbox hBox3 = new HBox();
// hBox3.getChildren().addAll(okBtn, cancelBtn);
public class ALayoutPaneIntroduction {
}
