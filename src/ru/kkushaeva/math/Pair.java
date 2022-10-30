package ru.kkushaeva.math;

public class Pair {
    /*int start;
    int end;

    public Pair(int s, int e){
        start = Math.max(0, Math.min(s, e));
        end = Math.max(0, Math.max(s, e));;
    }

    public boolean equals(Object obj){
        if (obj.getClass() != getClass()) return false;
        var other = (Pair)obj;
        return (start == other.start) && (end == other.end);
    }

    public int hashCode(){
        return Objects.hash(start, end);
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }
    */

    double x, y;

    public Pair(double x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Pair obj){
        if (obj.getClass() != getClass()) return false;
        var other = (Pair)obj;
        return (x == other.x) && (y == other.y);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
