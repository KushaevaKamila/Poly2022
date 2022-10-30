package ru.kkushaeva;

import ru.kkushaeva.gui.MainWindow;
import ru.kkushaeva.math.Lagrange;
import ru.kkushaeva.math.Newton;
import ru.kkushaeva.math.Pair;
import ru.kkushaeva.math.Polynomial;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
    /*
        //var x = new double[]{1,2,3};
        //Polynomial p1 = new Polynomial(x);
        //x[0] = 555;
        //System.out.println(x[0]);
        //System.out.println(p1.get(0));
        var x = new double[]{1,2,3,-5.5, 1.5};
        var y = new double[]{9,-2,3.2,5,-2.};
        var z = new double[]{-1.00007, 0, 0, 0, 0, 2, 1};

        //тест вывода многочлена
        Polynomial p1 = new Polynomial(x);
        Polynomial p2 = new Polynomial(y);
        Polynomial p3 = p1.plus(p2);
        System.out.println(p1.getPower());
        System.out.println(p2.getPower());
        System.out.println(p3.getPower());
        System.out.println(p1.output());
        System.out.println(p2.output());
        System.out.println(p3.output());
        Polynomial p4 = new Polynomial(z);
        System.out.println(p4.output());

        //тест операций над многочленами
        Polynomial p5 = new Polynomial(new double[]{1, 2});
        Polynomial p6 = new Polynomial(new double[]{0, 1});
        System.out.println(p5.times(p6).output());
        System.out.println(p5.times(0).output());
        try {p5.div(0);}
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        //тест Лагранжа
        System.out.println("Лагранж");

        var d = new HashMap<Double, Double>();
        d.put(-1., 1.);
        d.put(0., 0.);
        d.put(1., 1.);
        Lagrange L1 = new Lagrange(d);
        System.out.println(L1.output());

        var q = new HashMap<Double, Double>();
        q.put(-1.0, 0.0);
        q.put(0., 1.);
        q.put(1., 2.);
        q.put(2., 9.);
        Lagrange L2 = new Lagrange(q);
        System.out.println(L2.output());

        //System.out.println((float)2 - (float)1.55);
        //System.out.println(2-1.55);

        //тест Ньютона
        System.out.println("Ньютон");
        Newton N1 = new Newton(d);
        System.out.println(N1.output());

        Newton N2 = new Newton(q);
        System.out.println(N2.output());

        N1.addNode(2.,7.);
        System.out.println(N1.output());

        N1.addNode(2.,7.);
        System.out.println(N1.output());

        System.out.println("Сравнение Лагранжа и Ньютона");
        double a = -15.;
        double b = -13.;
        var t = new HashMap<Double, Double>();
        for (int i = 0; i < 45; i++){
            t.put(a, b);
            a += 1.0;
            b += 1.0;
        }

        var start1 = System.currentTimeMillis();
        Lagrange l1 = new Lagrange(t);
        var end1 = System.currentTimeMillis();
        var delta1 = end1 - start1;
        System.out.println("Время создания полинома Лагранжа " + delta1);
        //System.out.println(l1.output());

        var start2 = System.currentTimeMillis();
        Newton n1 = new Newton(t);
        var end2 = System.currentTimeMillis();
        var delta2 = end2 - start2;
        System.out.println("Время создания полинома Ньютона " + delta2);
        //System.out.println(n1.output());

        var start3 = System.currentTimeMillis();
        t.put(30.0, 32.0);
        Lagrange l2 = new Lagrange(t);
        var end3 = System.currentTimeMillis();
        var delta3 = end3 - start3;
        System.out.println("Время добавления точки в полином Лагранжа " + delta3);
        //System.out.println(l2.output());

        var start4 = System.currentTimeMillis();
        n1.addNode(30.0, 32.0);
        var end4 = System.currentTimeMillis();
        var delta4 = end4 - start4;
        System.out.println("Время добавления точки в полином Ньютона " + delta4);
        //System.out.println(n1.output());

        System.out.println("Разница во времени добавления точки в полиномы " + (delta3 - delta4));

        HashMap<Pair, Double> map = new HashMap<>();
        map.put(new Pair(2,3), 4.5);
        map.put(new Pair(1,1), 0.3); //разделённая разность от одного элемента

        System.out.println(map.get(new Pair(2,3)));
        System.out.println(map.get(new Pair(3,3)));

        var x1 = new double[]{1,-1,3,8,-10,4};
        Polynomial p11 = new Polynomial(x1);
        System.out.println(p11.output());
        Polynomial derp1 = p11.derivative();
        System.out.println(derp1.output());
    */
        //графика
        var wnd = new MainWindow();
        wnd.setVisible(true);
    }
}
