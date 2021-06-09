package Backjun;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 000000
        // 010000

        SimulatedAnnealing sa = new SimulatedAnnealing(2, 0.98, 10);
        sa.solve(new Problem() {
            @Override
            public double fit(double x) {
                return x*x*x*x-1;                       // 원하는 함수를 넣어서 x인풋 값에 해당하는 함수 y값 반환.
            }

            @Override
            public boolean isNeighborBetter(double f0, double f1) {
                return f1 > f0;
            }
        }, -4, 8);  // -4~부터 4까지 x값 범위 설정 하기위해서 upper값을 4더 큰 값을 대입.

        for(double i: sa.hist){
            if(i>=-1 && i<-0.9){
                System.out.println(i);
            }
        }
        // x=-4 f(x) = -64
    }
}