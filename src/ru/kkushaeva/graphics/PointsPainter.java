package ru.kkushaeva.graphics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import ru.kkushaeva.Converter;

public class PointsPainter implements Painter{
    private HashMap<Double, Double> points;
    int x, y;
    private Converter cnv;
    private Color color;
    private boolean check;

    public PointsPainter(Converter cnv, HashMap<Double, Double> points, Color color, boolean check) {
        this.points = new HashMap<Double, Double>(points);
        this.color = color;
        this.cnv = cnv;
        this.check = check;
    }

    public void addPoint(Double x, Double y){
        this.points.put(x, y);
    }
    public void deletePoint(Double x, Double y) {this.points.remove(x, y);}

    @Override
    public void paint(Graphics g, int width, int height) {
        if (check) {
            g.setColor(color);
            for (Map.Entry<Double, Double> point :
                    points.entrySet()) {
                x = cnv.xCrt2Scr(point.getKey());
                y = cnv.yCrt2Scr(point.getValue());
                //g.fillOval(x, y, cnv.xCrt2Scr(0.1), cnv.xCrt2Scr(0.1));
                g.fillOval(x - 3, y - 3, 6, 6);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
