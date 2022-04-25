package cz.spsmb.w35.chart;

import cz.spsmb.w35.PieChartUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Graf je grafické znázornění dat. Grafy poskytují snadnou cestu, jak analyzovat velké množství dat. Typické použití je
// pro vytváření reportů.
// Abstraktní třída Chart je základní třídou pro všechny ostatní třídy reprezentující graf. Grafy dělíme do dvou
// kategorií:
// - bez os (koláčový graf - PieChart),
// - s osami (XYChart, LineCHart, BarChart).
// Vlastnosti:
// title        - specifikuje titulek ke grafu,
// titleSide    - výčtový typ výčtu Side. Možnosti: TOP (default), RIGHT, BOTTOM, LEFT,
// legend       - specifikace legendy, reference na instanci typu Node,
// titleSide    - pozice legendy, výčtový typ výčtu Side. Možnosti: TOP, RIGHT, BOTTOM (default), LEFT,
// animated     - true (default), pokud se mná provést nějaká animace při změně dat.

// Třída PieChart pak přidává následující vlastnosti:
// data         - specifikace obsahu grafu, typ ObservableList<PieChart.Data>,
// startAngle   - úhel ve stupních (od kladné osy x, v protisměru hod. ručiček), kde se má vykreslit první část koláče,
// clockwise    - pokud je true (default), části koláče jsou pokládány od startAngle ve směru hod. ručiček,
// labelsVisible- viditelnost popisků částí koláče,
// labelLineLength - délka čar od části koláče k popisku, výchozí hodnota je 20px.
public class APieChartTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        PieChart chart = new PieChart();
        chart.setTitle("Population in 2000");

        // Place the legend on the left side
        chart.setLegendSide(Side.LEFT);

        // Set the data for the chart
        ObservableList<PieChart.Data> chartData = PieChartUtil.getChartData();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("A Pie Chart");
        stage.show();
    }
}
