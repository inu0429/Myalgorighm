package Backjun;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {
    private double t;   // 초기온도
    private double a;   // 냉각비율
    private int niter;  // 종료조건
    public ArrayList<Double> hist;

    public SimulatedAnnealing(double t, double a, int niter) {
        this.t = t;
        this.a = a;
        this.niter = niter;
        hist = new ArrayList<>();
    }

    public double solve(Problem p, double lower, double upper) {
        Random r = new Random();
        double x0 = r.nextDouble()*upper+lower;   //  main함수에서 정해준 x값 범위내에서 값을 설정.
        double f0 = p.fit(x0);                    //  임의의 x값에 해당하는 y값 반환.
        hist.add(f0);                             //  비교하기 쉽게 극소값의 아주 조금 큰값들만 모으고 싶으나 함수마다 조건을 다르게 줘야해서 힘듬.

        for(int i=0; i<niter; i++) {    // REPEAT
            int kt = (int) Math.round(t * 20);
            for(int j=0; j<kt; j++) {
                double x1 = r.nextDouble()*upper+lower;
                double f1 = p.fit(x1);
                if(p.isNeighborBetter(f0, f1)) {
                    x0 = x1;
                    f0 = f1;
                    hist.add(f0);
                } else {
                    double d = f1 - f0;
                    double p0 = Math.exp(-d/t);
                    if(r.nextDouble() < p0) {
                        x0 = x1;
                        f0 = f1;
                        hist.add(f0);
                    }
                }
            }
            t *= a;
        }
        return x0;
    }
}