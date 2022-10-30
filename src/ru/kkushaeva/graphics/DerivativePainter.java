package ru.kkushaeva.graphics;

import ru.kkushaeva.Converter;
import ru.kkushaeva.math.Newton;
import ru.kkushaeva.math.Polynomial;

import java.awt.*;
import java.util.HashMap;

public class DerivativePainter implements Painter{
    private HashMap<Double, Double> points;
    private Converter cnv;
    private Color color;
    private boolean check;

    public DerivativePainter(Converter cnv, HashMap<Double, Double> points, Color color, boolean check){
        this.cnv = cnv;
        this.color = color;
        this.points = points;
        this.check = check;
    }
    @Override
    public void paint(Graphics g, int width, int height) {
        if (check) {
            g.setColor(color);
            Polynomial der = der();
            if (points.size() > 0) {
                for (int xScr = 0; xScr < width - 1; xScr++) {
                    double xCrt1 = cnv.xScr2Crt(xScr);
                    double yCrt1 = der.invoke(xCrt1);
                    double xCrt2 = cnv.xScr2Crt(xScr + 1);
                    double yCrt2 = der.invoke(xCrt2);
                    g.drawLine(cnv.xCrt2Scr(xCrt1), cnv.yCrt2Scr(yCrt1), cnv.xCrt2Scr(xCrt2), cnv.yCrt2Scr(yCrt2));
                }
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Polynomial der(){
        Polynomial p = new Newton(points);
        return p.derivative();
    }

    public void setPoints(HashMap<Double, Double> points) {
        this.points = points;
    }
}
