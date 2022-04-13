package cz.spsmb.w28.control;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class ZTDirectoryChooser extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //HBox root = new HBox();
        DirectoryChooser dirDialog = new DirectoryChooser();
        dirDialog.setTitle("Select destination directory");
        dirDialog.setInitialDirectory(new File("c:\\"));
        File dir = dirDialog.showDialog(null);
        if(dir == null) {
            System.out.println("Selected directory> " + dir);
        } else {
            System.out.println("No directory was selected");
        }
    }
}
