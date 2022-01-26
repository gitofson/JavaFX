package cz.spsmb.w21;
//JavaFX runtime běží v několika vláknech. Důležité jsou
// JavaFX-Launcher a
// JavaFX Application Thread.
// Statická metoda .launch() třídy Application vytvoří
// tyto 2 vlákna. Během života aplikace se spouští následující metody v uváěném
// pořadí:

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

//1. konstruktor bez parametrů
//2. init() metoda
//3. start() metoda
//4. stop() metoda - volána, když aplikace končí

//Explocitní ukončení aplikace můžeme provést pomocí Platform.exit()
//JavaFX aplikace může být ukončena implicitně, pokud zavřeme poslední okno.
// Tomuto se dá zabránit pomocí statické metody setImpicitExit(false). Default
// je true.
public class FXLifeCycleApp extends Application {
    public FXLifeCycleApp() {
        String name = Thread.currentThread().getName();
        System.out.println("FXLifeCycleApp() constructor: " + name);
    }

    public static void main(String[] args) {
        //tímto aplikace běží dál i po zavření okna
        //Platform.setImplicitExit(false);

        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("init() method: " + name);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("start() method: " + name);
        Scene scene = new Scene(new Group(), 200, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application Life Cycle");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }
}
