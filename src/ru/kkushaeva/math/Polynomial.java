package ru.kkushaeva.math;

public class Polynomial implements Function{
    protected double[] coeff; //массив коэффициентов
    public static final double EPS = 1e-50;
    //final = const

    public Polynomial(){ //конструктор по умолчанию
        coeff = new double[1];
        coeff[0] = 0.0;
    }

    public Polynomial(double[] coeff){ //создание полинома по массиву коэффициентов
        this.coeff = coeff.clone();
        //this.coeff = coeff; //присвоение без клонирования, массивы будут по одному адресу
        correctPower();
    }

    public Polynomial(Polynomial p){
        coeff = p.coeff.clone();
    }

    private void correctPower(){ //делаем так, чтобы если в конце массива 0, полином создавался правильно
        int j = coeff.length;
        while (j > 1 && Math.abs(coeff[j - 1]) < EPS){
            j--;
        }
        if (j < coeff.length){
            var ncoeff = new double[j];
            System.arraycopy(coeff, 0, ncoeff, 0, j);
            coeff = ncoeff;
        }
    }

    public double get(int i){ //получение коэффициента полинома
        if (i >= 0 && i < coeff.length) return coeff[i];
        return Double.NaN; //Not a Number
    }

    public Polynomial plus(Polynomial other){ //сложение полиномов
        double[] nc = new double[Math.max(this.coeff.length, other.coeff.length)];
        var minl = Math.min(this.coeff.length, other.coeff.length);
        for (int i = 0; i < minl; i++){
            nc[i] = this.coeff[i] + other.coeff[i];
        }
        var longPol = (this.coeff.length > other.coeff.length) ? this : other; //ссылка на более длинный полином
        //for (int i = minl; i < nc.length; i++){
        //    nc[i] = longPol.coeff[i];
        //}
        System.arraycopy(longPol.coeff, minl, nc, minl, nc.length - minl); //это то же самое, что сверху, только короче и быстрее (еопирование массива)
        return new Polynomial(nc);
    }

    public Polynomial times(double num){ //умножение полинома на число
        double[] nc = new double[coeff.length];
        for (int i = 0; i < coeff.length; i++){
            nc[i] = coeff[i] * num;
        }
        return new Polynomial(nc);
    }

    public Polynomial minus(Polynomial other) { //вычитание полиномов
        return plus(other.times(-1));
    }

    public Polynomial div(double num) throws Exception { //деление полинома на число
        if (Math.abs(num) >= EPS) return times(1.0/num);
        else throw new Exception("Деление на 0");
    }

    public Polynomial times(Polynomial other){ //умножение полинома на полином
        double [] nc = new double[coeff.length + other.coeff.length - 1];
        for (int i = 0; i < other.coeff.length; i++){
            for (int j = 0; j < this.coeff.length; j++){
                nc[i + j] += other.coeff[i] * this.coeff[j];
            }
        }
        return new Polynomial(nc);
    }

    public double invoke(double x){ //вычисление значения полинома в точке
        double result = coeff[0];
        double p = x;
        for (int i = 1; i < coeff.length; i++){
            result += coeff[i] * p;
            p *= x;
        }
        return result;
    }

    public int getPower(){ //возвращает степень полинома
        return this.coeff.length - 1;
    } //возвращает степень полинома

    public String output(){

        String s = new String();
        int l = coeff.length - 1; //степень многочлена

        if (l == 0) {
            if (Math.abs(Math.round(coeff[0]) - coeff[0]) <= EPS) s += (int)coeff[0];
            else s += coeff[0];
        }
        else {
            for (int i = l; i > 1; i--){ //вывод всех одночленов степени >=1
                if (Math.abs(coeff[i]) < EPS) continue;
                else if ((coeff[i] > EPS) && (i != l)) s += "+";
                if ((Math.abs(Math.round(coeff[i]) - coeff[i])) <= EPS) {
                    if (Math.abs(coeff[i]) - 1 > EPS) s += (int)coeff[i] + "x^" + i;
                    else if (Math.abs(coeff[i] - 1) < EPS) s += "x^" + i;
                    else s += "-x^" + i;
                }
                else s += coeff[i] + "x^" + i;
            }

            if (Math.abs(coeff[1]) > EPS) //вывод одночлена степени 1
            {
                if ((l != 1) && (coeff[1] > EPS)) s += "+";
                if (Math.abs(Math.round(coeff[1]) - coeff[1]) <= EPS) {
                    if (Math.abs(coeff[1]) - 1 > EPS) s += (int)coeff[1] + "x";
                    else if (Math.abs(coeff[1] - 1) < EPS) s += "x";
                    else s += "-x";
                }
                else s += coeff[1] + "x";
            }

            if (Math.abs(coeff[0]) >= EPS) //вывод одночлена степени 0
            {
                if (coeff[0] > EPS) s += "+";
                if (Math.abs(Math.round(coeff[0]) - coeff[0]) < EPS) s += (int)coeff[0];
                else s += coeff[0];
            }
        }
        return s;
    }

    public Polynomial derivative(){
        if ((this.coeff.length == 1) || (this.coeff.length == 0)) return new Polynomial();
        double[] nc = new double[this.coeff.length - 1];
        for (int i = 0; i < this.coeff.length - 1; i++){
            nc[i] = this.get(i + 1) * (i + 1);
        }
        return new Polynomial(nc);
    }
}
