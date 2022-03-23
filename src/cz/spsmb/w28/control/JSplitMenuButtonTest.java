package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
//SplitMenuButton spadá do hybridní kategorie. Kombinuje výhody pop-up menu a běžného tlačítka. Dědí z MenuButton a je
// rozdělen do dvou částí:
// - action area (akční část) - pokud sem klikneme, událost ActionEvent je "odpálena",
// - menu-open area (rozbalovací část) - pokud sem klikneme, je zobrazeno menu.
// Mnemonic pasing je zde ve výchozím stavu povoleno
public class JSplitMenuButtonTest extends Application {
    private WebView webview;
    private String lastVisited = "http://www.jdojo.com";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Must create a WebView object from the JavaFX Application Thread
        webview = new WebView();

        MenuItem jdojo = new MenuItem("_JDojo");
        jdojo.setOnAction(e -> loadPage("http://www.jdojo.com"));

        MenuItem yahoo = new MenuItem("_Yahoo");
        yahoo.setOnAction(e -> loadPage("http://www.yahoo.com"));

        MenuItem google = new MenuItem("_Google");
        google.setOnAction(e -> loadPage("http://www.google.com"));

        // Create a SplitMenuButton
        SplitMenuButton splitBtn = new SplitMenuButton();
        splitBtn.setText("Home");

        // Add menu items to the SplitMenuButton
        splitBtn.getItems().addAll(jdojo, yahoo, google);

        // Add ActionEvent handler when "Home" is clicked
        splitBtn.setOnAction(e -> loadPage(this.lastVisited));

        BorderPane root = new BorderPane();
        root.setTop(splitBtn);
        BorderPane.setAlignment(splitBtn, Pos.TOP_RIGHT);
        root.setCenter(webview);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using SplitMenuButton Controls");
        stage.show();
    }

    public void loadPage(String url) {
        this.lastVisited=url;
        webview.getEngine().load(url);
    }
}

