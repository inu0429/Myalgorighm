package Backjun;

public interface Problem {
    double fit(double x);
    boolean isNeighborBetter(double f0, double f1);
}