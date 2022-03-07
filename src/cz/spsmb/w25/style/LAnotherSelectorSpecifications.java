package cz.spsmb.w25.style;
// Kombinace ID a selectoru a selectoru třídy. V takové  případě selector vybere uzly se specifikovaným ID a třídou stylu.
// Např.:
// #closeButton.button {
//      -fx-text-fill: red;
// }
// Což vybere všechny uzly s closeButtonID a třídou stylu button

// Univerzální selector - *
// možnost vybrat jakýkoliv uzel
// * {
//      -fx-text-fill: blue;
// }

// Seskupování vícero selectorů. Je možné namísto
// .button {
//      -fx-text-fill: blue;
// }
// .label {
//      -fx-text-fill: blue;
// }
// toto:
// .button, .label {
//      -fx-text-fill: blue;
// }

// Sestupný (descendant) selector - slouží k označení uzlu, který je poduzlem jiného. Oddělovač je v tomto případě
// mezera. Příklad:
// .hbox .button {
//      -fx-text-fill: blue;
// }
// se bude týkat všech uzlů, které mají CSS třídu button a jsou sestupné css třídě hbox. Sestupné se zde myslí v jakékoliv
// úrovni.

// Child selector - narozdíl sestupného selektoru označuje uzel podřízený druhému. Např.:
// .hbox > .button {
//      -fx-text-fill: blue;
// }
// se bude týkat uzlů, které jsou CSS třídy button a jsou vložené do CSS třídy hbox.

// Selector založený na stavu uzlu (state based selector) - známý také jako tzv pseudo-class selector.
// Vybírá uzly dle jejich stavu. Např:
// .button:hover {
//      -fx-text-fill: red;
// }
// vybere uzel CSS třídy button, pokud je nad ním kurzor myši. Seznam stavů:
// disabled         Node
// focused          Node
// hover            Node
// pressed          Node
// show-mnemonic    Node
// cancel           Button - obdržení VK_ESC
// default          Button  - obdržení VK_ENTER
// empty            Cell
// filled           Cell
// selected         Cell, CheckBox
// determinate      CheckBox
// indeterminate    CheckBox
// visited          Hyperlink
// horizontal       ListView
// vertical         ListView


public class LAnotherSelectorSpecifications {
}
