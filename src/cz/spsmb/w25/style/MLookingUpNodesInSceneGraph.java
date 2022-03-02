package cz.spsmb.w25.style;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;

// Může přijít vhod vyhledání nějakého uzlu, nebo celé množiny uzlů, které vyhovují selectorem nějakému vzoru.
// Následující metody toto umožňují:
// lookup(String selector) - vyhledání jednoho uzlu. Bude vrácena instance prvního uzlu, který vyhovuje zadanému selectoru
// lookupAll(String selector) - vyhledání všech uzlů vyhovující zadanému selectoru
public class MLookingUpNodesInSceneGraph extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("Close");
        b1.setId("closeBtn");
        VBox root = new VBox();
        root.setId("myVbox");
        root.getChildren().addAll(b1);
        Scene scene = new Scene(root, 200, 300);
        //n1, n2 i n3 budou referencí na b1
        Node n1 = scene.lookup("#closeBtn");
        Node n2 = root.lookup("#closeBtn");
        Node n3 = b1.lookup("#closeBtn");
        //
        Node n4 = root.lookup("#myVbox");

        Node n5 = b1.lookup("#myVbox");
        Set<Node> s = root.lookupAll("#closeBtn");

    }
}
