package cz.spsmb.w35.chart;

import cz.spsmb.w35.XYChartDataUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
// Abstraktní třída XYChart<X, Y> definuje dvouosý graf. Generické parametry X a Y jsou typy hodnot vykreslovaných na
// ose X, resp. na ose Y.
// Abstraktní třída Axis<T> je základní třídou pro všechny třídy reprezentující osy. Podtřídy:
// CategoryAxis - reprezentuje kategorii (v tomto příkladu státy),
// NumberAxis   - reprezentuje číselnou hodnotu (v tomto příkladu populaci).

// Data v XYChart jsou reprezentovány vnořenou statirckou třídou XYChart.Data<X,Y>. Ta obsahuje následující vlastnosti:
// XValue
// YValue
// extraValue       - typ Object, vhodné k uložení nějaké přídavné informace dané položky,
// node             - reference na uze, který má být vyrenderován pro danou položku v grafu

// Instance vnořené statické třídy XYChart.Series<X,Y> reprezentuje řadu datových položek. Vlastnosti:
// name             - jméno řady,
// data             - datová reprezentace, typ ObservableList<XYChart.Data<X,Y>>,
// chart            - read-only reference na graf, ke kterému tyto data patří,
// node             - Node reference na uzel, který tuto řadu zobrazuje.

// Instance třídy BarChart reprezentuje sloupcový graf. Ve sloupcovém grafu musí být jedna osa typu CategoryAxis a druhá
// typu ValueAxis/NumberAxis. BarChart obsahuje následující vlastnosti:
// barGap       - mezera mezi dvěma sloupci, default  4px,
// categoryGap  - mezera mezi dvěma sloupci v rámci kategorie, default  10px.
public class EVerticalBarChart extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Population by Country and Year");

        // Set the data for the chart
        ObservableList<XYChart.Series<String,Number>> chartData =
                XYChartDataUtil.getYearSeries();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/bar_chart.css");
        stage.setScene(scene);
        stage.setTitle("A Vertical Bar Chart");
        stage.show();
    }
}
