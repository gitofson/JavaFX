package cz.spsmb.w24.scenes;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

import static javafx.application.ConditionalFeature.*;

//Výčtový typ ConditionalFeature definuje následujícíí konstanty
// EFFECT        - indikace dostupnosti filtr efektů, např odrazy, stíny, apod.
// INPUT_METHOD  - indikace dostupnosti textových vstupů
// SCENE3D       - indikace dostupnosti 3D vymožeností
// SHAPE_CLIP    - indikace dostupnosti ořezání uzlu na libovolý tvar
// TRANSPARENT_WINDOW - indikace dostupnosti plné průhlednosti okna
public class EConditionalFeature extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        if (Platform.isSupported(ConditionalFeature.SCENE3D)){
            System.out.println(" dostupnost 3D vymožeností podporována");
        } else {
            System.out.println(" dostupnost 3D vymožeností nepodporována");
        }
        for (ConditionalFeature cf :ConditionalFeature.values()
             ) {
            try {
                System.out.format("Podpora %s: %b%n", cf.toString(), Platform.isSupported(cf));
            } catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }

        }

    }
}
