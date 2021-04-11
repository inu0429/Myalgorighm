package backjun.test;

import java.util.Arrays;
import java.util.Scanner;

public class Back11399 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int[] number= new int[n];
		for(int i=0;i<n;i++) {
			number[i]=scanner.nextInt();
		}
		Arrays.sort(number);
		
		int k=0;
		int a=0;
		for(int i=0;i<n;i++) {
			a+=k+number[i];
			k+=number[i];
		}
		System.out.println(a);
	}
}
