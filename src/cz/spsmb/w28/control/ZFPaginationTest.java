package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// Třída Pagination se používá pro zobrazení velkého jednoduchého obsahu tak, že se rozdělí do více stránek.
// Obsahuje 2 oblasti:
// oblast obsahu (content area)         - zobrazí obsah vybrané stránky
// navigační oblast (navigation area)   - zobrazuje části, které umožňují navigaci z jedné stránky na jinou.
// Vlastnosti:
// currentPageIndex         - index stránky, který je zobrazen
// maxPageIndicatorCount    - max počet stránek indikátoru, který se zobrazí (default 10)
// pageCount                - počet stránek
// pageFactory              - typ Callback<Integer, Node>, metoda call zaručí vykreslení stránky
public class ZFPaginationTest extends Application {
    private static final int PAGE_COUNT = 5;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pagination pagination = new Pagination(PAGE_COUNT);

        // Set the page factory
        pagination.setPageFactory(this::getPage);

        VBox root = new VBox(pagination);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/pagination.css");
        stage.setScene(scene);
        stage.setTitle("Using Pagination Controls");
        stage.show();
    }

    public Label getPage(int pageIndex) {
        Label content = null;

        if (pageIndex >= 0 && pageIndex < PAGE_COUNT) {
            content = new Label("Content for page " + (pageIndex + 1));
        }
        return content;
    }
}