package cz.spsmb.w28.control;

import cz.spsmb.w28.GeneralTab;
import cz.spsmb.w28.AddressTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// TabPane je kontejner pro Tab a jeho úkolem je šetřit místo v aplikaci. Tab může být umístěn nahoře, vpravo, dole,
// či vlevo od TabPane. TabPane je rozdělen na
// hlavičkovou oblast (header area)
// oblast obsahu (content area)
// vlastnosti:
// text
// graphics
// closable
// content

public class ZOTabTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        ImageView privacyIcon = getImage("privacy_icon.png");
        GeneralTab generalTab = new GeneralTab("General", privacyIcon);

        ImageView addressIcon = getImage("address_icon.png");
        AddressTab addressTab = new AddressTab("Address", addressIcon);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(generalTab, addressTab);

        BorderPane root = new BorderPane();
        root.setCenter(tabPane);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using TabPane and Tab Controls");
        stage.show();
    }

    public ImageView getImage(String fileName) {
        ImageView imgView = null;
        try {
            String imagePath = "picture/" + fileName;
            Image img = new Image(imagePath);
            imgView = new ImageView(img);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return imgView;
    }
}
