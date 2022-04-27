package cz.spsmb.w35.chart;

import cz.spsmb.w35.XYChartDataUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
// V bodový graf (statter chart) je možné použít libovolný typ Axis pro osy x a y. Vlastnost autoRanging je nastavena
// na true jako výchozí.
public class HScatterChartTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Year");

        // Customize the x-axis, so points are scattred uniformly
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1900);
        xAxis.setUpperBound(2300);
        xAxis.setTickUnit(50);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        ScatterChart<Number,Number> chart = new ScatterChart<>(xAxis, yAxis);
        chart.setTitle("Population by Year and Country");

        // Set the data for the chart
        ObservableList<XYChart.Series<Number,Number>> chartData =
                XYChartDataUtil.getCountrySeries();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Scatter Chart");
        stage.show();
    }
}