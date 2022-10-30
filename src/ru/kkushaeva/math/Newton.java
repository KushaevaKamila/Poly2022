package ru.kkushaeva.math;

import java.util.*;

public class Newton extends Polynomial{
    private List<Double> nodes;
    private List<Double> values;

    public Newton(Map<Double, Double> d){ //конструктор
        nodes = new ArrayList<Double>(d.keySet());
        values = new ArrayList<Double>(d.values());
        var N = createNewton();
        this.coeff = N.coeff.clone();
    }

    private Polynomial createNewton(){  //формирование полинома
        if (this.nodes.size() == 0) return new Polynomial();
        Polynomial N = new Polynomial(new double[]{values.get(0)}); //создаём полином из первого слагаемого f(x0);
        Polynomial P = new Polynomial(new double[]{1}); //это будут полиномы вида (x-x0)(x-x1)...(x-xn)
        List<Double> x = new ArrayList<Double>(); //список узлов, передаваемых в createCoeff()
        List<Double> y = new ArrayList<Double>(); //список значений функции в узлах, передаваемых в createCoeff()
        x.add(nodes.get(0));
        y.add(values.get(0));
        double coeff;

        for (int i = 0; i < nodes.size() - 1; i++){
            P = P.times(new Polynomial(new double[]{-nodes.get(i), 1}));
            x.add(nodes.get(i + 1));
            y.add(values.get(i + 1));
            coeff = createCoeff(x, y);
            N = N.plus(P.times(coeff));
        }
        return N;
    }

    /*    private HashMap<Pair, Double> f = new HashMap<>(); //разделённые разности
    private double createCoeff(List<Double> x, List<Double> y){ //создание кэффициентов
        int i = 0;
        int j = x.size() - 1;

        if (x.size() == 1) {
            if (f.get(new Pair(i, j)) == null) f.put(new Pair(i, j), y.get(0));
            return f.get(new Pair(i, j));
        }
        else if (x.size() == 2) {
            if (f.get(new Pair(i, j)) == null) f.put(new Pair(i, j), (y.get(1) - y.get(0))/(x.get(1) - x.get(0)));
            return f.get(new Pair(i, j));
        }
        else {
            if (f.get(new Pair(i, j)) == null) f.put(new Pair(i, j), (createCoeff(x.subList(1, x.size()), y.subList(1, x.size())) -
                    createCoeff(x.subList(0, x.size() - 1), y.subList(0, x.size() - 1)))/
                    (x.get(x.size() - 1) - x.get(0)));
            return f.get(new Pair(i,j));
        }
    }*/

    //private List<Double> f = new ArrayList<Double>();
    private double createCoeff(List<Double> x, List<Double> y){ //создание кэффициентов
        double coeff = 0;
        for (int i = 0; i < x.size(); i++){
            double z = 1;
            for (int j = 0; j < x.size(); j++){
                if (i != j) z *= (x.get(i) - x.get(j));
            }
            coeff += y.get(i) / z;
        }
        return coeff;
    }

    public void addNode(double x, double y){ //добавление узловой точки
        Polynomial N = new Polynomial(this.coeff);
        Polynomial P = new Polynomial(new double[]{1});
        if (nodes.indexOf(x) == -1){ //добавляем новый узел, только если такого ещё не было
            nodes.add(x);
            values.add(y);
            double coeff = createCoeff(this.nodes, this.values);
            for (int i = 0; i < nodes.size() - 1; i++){
                P = P.times(new Polynomial(new double[]{-nodes.get(i), 1}));
            }
            N = N.plus(P.times(coeff));
            this.coeff = N.coeff.clone();
        }
    }
}
