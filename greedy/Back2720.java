package backjun.test;

import java.util.Scanner;
//ÇÏ¾á Ä­ ¹®Á¦.
public class Back2720 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] money = new int[T];
		for(int i =0;i<T;i++) {
			money[i]=scanner.nextInt();
		}
		for(int i=0;i<T;i++) {
			count(money[i]);
		}
	}
	
	static void count(int p) {
		int a=p;
		System.out.printf("%d ",a/25);
		a%=25;
		System.out.printf("%d ",a/10);
		a%=10;
		System.out.printf("%d ",a/5);
		a%=5;
		System.out.printf("%d ",a/1);
		System.out.println();
	}
}
