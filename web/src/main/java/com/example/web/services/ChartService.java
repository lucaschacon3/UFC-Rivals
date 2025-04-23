package com.example.web.services;

import com.example.web.entities.Fighter;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
@Service
public class ChartService {

    public String generateRadarChart(Fighter fighter1, Fighter fighter2, String filename) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Peleador 1
        dataset.addValue(fighter1.getWinsKo(), fighter1.getName(), "Wins by KO");
        dataset.addValue(fighter1.getWinsSub(), fighter1.getName(), "Wins by Sub");
        dataset.addValue(fighter1.getWinsDec(), fighter1.getName(), "Wins by Dec");
        dataset.addValue(fighter1.getLossesKo(), fighter1.getName(), "Losses by KO");
        dataset.addValue(fighter1.getLossesSub(), fighter1.getName(), "Losses by Sub");
        dataset.addValue(fighter1.getLossesDec(), fighter1.getName(), "Losses by Dec");

        // Peleador 2
        dataset.addValue(fighter2.getWinsKo(), fighter2.getName(), "Wins by KO");
        dataset.addValue(fighter2.getWinsSub(), fighter2.getName(), "Wins by Sub");
        dataset.addValue(fighter2.getWinsDec(), fighter2.getName(), "Wins by Dec");
        dataset.addValue(fighter2.getLossesKo(), fighter2.getName(), "Losses by KO");
        dataset.addValue(fighter2.getLossesSub(), fighter2.getName(), "Losses by Sub");
        dataset.addValue(fighter2.getLossesDec(), fighter2.getName(), "Losses by Dec");

        SpiderWebPlot plot = new SpiderWebPlot(dataset);
        plot.setStartAngle(0);
        plot.setInteriorGap(0.35);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setSeriesPaint(0, new Color(231, 30, 30)); // Peleador 1
        plot.setSeriesPaint(1, new Color(15, 117, 227));  // Peleador 2
        plot.setOutlineVisible(false);

        JFreeChart chart = new JFreeChart(
                 fighter1.getName() + " vs " + fighter2.getName(),
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                true // Mostrar leyenda
        );

        String path = "web/src/main/resources/static/img/" + filename;
        File outputfile = new File(path);
        ChartUtilities.saveChartAsPNG(outputfile, chart, 600, 600);

        return "/img/" + filename;
    }

}
