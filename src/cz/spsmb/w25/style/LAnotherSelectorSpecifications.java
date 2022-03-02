package cz.spsmb.w25.style;
// Kombinace ID a selectoru a selectoru třídy. V takové  případě selector vybere uzly se specifikovaným ID a třídou stylu.
// Např.:
// #closeButton.button {
//      -fx-text-fill: red;
// }
// Což vybere všechny uzly s closeButtonID a třídou stylu button

// Univerzální selector - *
// mo6nost vybrat jakýkoliv uzel
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

// Sestupný (descendant) selector - slouží k označení uzkul, který je poduzlem jiného. Oddělovač je v tomto případě
// mezera. Příklad:
// .hbox .button {
//      -fx-text-fill: blue;
// }
public class LAnotherSelectorSpecifications {
}
