package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// Ovládací prvek MenuButton vypadá jako Button, ale chová se jako menu. Pokud je aktivován, zobrazí seznam voleb ve
// formě pop-up menu. Tento seznam je udržován ve vlastnosti ObservableList<MenuItem> items. Pro vykonání kódu při
// výběru dané položky je potřeba navěsit ActionEvent handler do patřiční MenuItem položky.
// Další vlastnosti:
// ObjectProperty<Side> popupSide - určuje, jaká strana menu se má zobrazit. Šipka v MenuItem ukazuje tento směr. Možné
// konstanty výčtu: TOP, LEFT, BOTTOM (výchozí hodnota) a RIGHT.

public class FMenuButtonTest extends Application {
    private WebView webview;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Must create a WebView object from the JavaFX Application Thread
        webview = new WebView();

        MenuItem jdojo = new MenuItem("JDojo");
        jdojo.setOnAction(e -> loadPage("http://www.jdojo.com"));

        MenuItem yahoo = new MenuItem("Yahoo");
        yahoo.setOnAction(e -> loadPage("http://www.yahoo.com"));

        MenuItem google = new MenuItem("Google");
        google.setOnAction(e -> loadPage("http://www.google.com"));

        // Add menu items to the MenuButton
        MenuButton links = new MenuButton("Visit");
        links.setPopupSide(Side.LEFT);
        links.getItems().addAll(jdojo, yahoo, google);

        BorderPane root = new BorderPane();
        root.setTop(links);
        BorderPane.setAlignment(links, Pos.CENTER);
        root.setCenter(webview);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using MenuButton Controls");
        stage.show();
    }

    public void loadPage(String url) {
        webview.getEngine().load(url);
    }
}
