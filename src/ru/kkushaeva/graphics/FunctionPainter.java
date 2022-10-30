package ru.kkushaeva.graphics;

import ru.kkushaeva.Converter;
import ru.kkushaeva.math.Function;
import ru.kkushaeva.math.Newton;

import java.awt.*;
import java.util.HashMap;

public class FunctionPainter implements Painter {
    private HashMap<Double, Double> points;
    private Converter cnv;
    private Color color;
    private boolean check;
    private Newton poly;
    private Function f;

    /*public FunctionPainter(Converter cnv, HashMap<Double, Double> points, Color color, boolean check){
        this.points = new HashMap<Double, Double>(points);
        this.color = color;
        this.cnv = cnv;
        this.check = check;
        poly = new Newton(points);
    }*/

    public FunctionPainter(Converter cnv, Function f, Color color, boolean check){
        this.f = f;
        this.color = color;
        this.cnv = cnv;
        this.check = check;
        //poly = new Newton(points);
    }

    /*@Override
    public void paint(Graphics g, int width, int height) {
        if (check) {
            g.setColor(color);
            //Newton poly = poly();
            if (points.size() > 0) {
                for (int xScr = 0; xScr < width - 1; xScr++) {
                    double xCrt1 = cnv.xScr2Crt(xScr);
                    double yCrt1 = poly.invoke(xCrt1);
                    double xCrt2 = cnv.xScr2Crt(xScr + 1);
                    double yCrt2 = poly.invoke(xCrt2);
                    g.drawLine(cnv.xCrt2Scr(xCrt1), cnv.yCrt2Scr(yCrt1), cnv.xCrt2Scr(xCrt2), cnv.yCrt2Scr(yCrt2));
                }
            }
        }
    }*/

    public void paint(Graphics g, int width, int height) {
        if (check) {
            g.setColor(color);
            for (int xScr = 0; xScr < width - 1; xScr++) {
                double xCrt1 = cnv.xScr2Crt(xScr);
                double yCrt1 = f.invoke(xCrt1);
                double xCrt2 = cnv.xScr2Crt(xScr + 1);
                double yCrt2 = f.invoke(xCrt2);
                g.drawLine(cnv.xCrt2Scr(xCrt1), cnv.yCrt2Scr(yCrt1), cnv.xCrt2Scr(xCrt2), cnv.yCrt2Scr(yCrt2));
            }

        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setF(Function f) {
        this.f = f;
    }

    /*public Newton poly(){
        return new Newton(points);
    }

    public void setPoints(HashMap<Double, Double> points) {
        this.points = points;
        poly = new Newton(points);
    }

    public void addPoint(double x, double y){
        this.points.put(x, y);
        poly.addNode(x, y);
    }*/
}
