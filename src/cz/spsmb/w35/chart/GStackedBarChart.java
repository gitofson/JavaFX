package cz.spsmb.w35.chart;

import cz.spsmb.w35.XYChartDataUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
// Skládaný sloupcový graf je variací sloupcového grafu, kde sloupce v rámci kategorie jsou poskládány na sebe.
public class GStackedBarChart extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");

        // Must set the categories in a StackedBarChart explicitly. Otherwise,
        // the chart will not show any bars.
        xAxis.getCategories().addAll("China", "India", "Brazil", "UK", "USA");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        StackedBarChart<String, Number> chart =
                new StackedBarChart<>(xAxis, yAxis);
        chart.setTitle("Population by Country and Year");

        // Set the data for the chart
        ObservableList<XYChart.Series<String, Number>> chartData =
                XYChartDataUtil.getYearSeries();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Vertical Stacked Bar Chart");
        stage.show();
    }
}
