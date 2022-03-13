package cz.spsmb.w27.container;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// Vlastnosti deklarované ve třídě FlowPane:
// alignment    ObjectProperty<pos>    - specifikuje zarovnání poduzlů relativně k oblasti obsahu FlowPane.
//                                       Výchozí hodnota je TOP_LEFT.
// rowAlignment ObjectProperty<pos>    - specifikuje vertikální zarovnání poduzlů uvnitř každého řádku v horiz. FlowPane.
// columnAlignment ObjectProperty<pos> - specifikuje horiz. zarovnání poduzlů uvnitř každého sloupce ve vert. FlowPane.
// hgap, vgap   DoubleProperty         - horiz. a vert. mezery mezi poduzly.
// orientation  ObjectProperty<Orientation> - orientace FlowPane, default je HORIZONTAL
// prefWrapLength DoubleProperty       - preferred width pro horiz FlowPane, resp. prefferedHeight pro vert. FlowPane,
//                                       kde se má obsah zalamovat. Výchzí hodnota je 400.


//Následující příklad ukazuje 3 FlowPanes v HBoxu. Každý z nich má jiný alignment
public class QFlowPaneAlignment extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        FlowPane fp1 = createFlowPane(Pos.BOTTOM_RIGHT);
        FlowPane fp2 = createFlowPane(Pos.BOTTOM_LEFT);
        FlowPane fp3 = createFlowPane(Pos.CENTER);

        HBox root = new HBox(fp1, fp2, fp3);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FlowPane Alignment");
        stage.show();
    }

    private FlowPane createFlowPane(Pos alignment) {
        FlowPane fp = new FlowPane(5, 5);
        fp.setPrefSize(200, 100);
        fp.setAlignment(alignment);
        fp.getChildren().addAll(new Text(alignment.toString()),
                new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3"));

        fp.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        return fp;
    }
}
