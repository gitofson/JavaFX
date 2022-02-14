package cz.spsmb.w24.scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Třída Platform poskytuje tyto užitečné metody:
// void exit()                      - ukončí JavFX aplikaci
// boolean idFxApplicationThread()  - vrátí true, pokud volající vlákno je JavaFX Application vlákno.
// boolean isImplicitExit()         - vrací hodnotu vlastnosti implicitExit. Pokud vrátí true, znamená to, že se
//                                    po posledním uzavřeném okně JavaFX aplikace ukončí
//boolean                           - vrací true, pokud specifikovaná podmíněná feature je platformou podporována.
// isSupported(ContitionalFeature f)
//void runLater(Runnable runnable)  - spustí dané Runnable ve vlákně JavaFX Application. Načasování spuštění je
//                                    nespecifikováno. Pošle to zadané Runnable do fronty a okamžitě skončí. Pokud je
//                                    touto metodou posláno vícero Runnables, jsou spouštěny dle fronty.
//void setImplicitExit(boolean value)
public class DRunLaterApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        System.out.println("init(): " + Thread.currentThread().getName());

        // Create a Runnable task
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running the task on the "
                        + Thread.currentThread().getName());
            }
        };

        // Submit the task to be run on the JavaFX Aplication Thread
        Platform.runLater(task);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Group(), 400, 100));
        stage.setTitle("Using Platform.runLater() Method");
        stage.show();
    }
}
