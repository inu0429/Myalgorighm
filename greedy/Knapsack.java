package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//�ڵ� ������ ��õ���б� ������Ű��а� ������.
//https://github.com/inu0429/java_Myalgorighm.git

public class Knapsack {
		static int w;// Ŭ���� �ɹ����� 0���� �ڵ��ʱ�ȭ.
		static int v;
		static Scanner scanner = new Scanner(System.in);
		//�賶�� ������ ������.
		static int bag_weight = scanner.nextInt();
		//������ � ����ǰ�?
		static int n = scanner.nextInt();
		//���ǵ��� ��ü�迭�� ����.
		static Something[] somethings= new Something[n];
		// �������Դ� ��ġ�� ���� ����Ʈ.
		static ArrayList<Integer> arrayList = new ArrayList<Integer>(n);
		// � ������ ��Ҵ��� ������ ����Ʈ.
		static ArrayList<String> real_name = new ArrayList<String>(n);
		
	public static void main(String[] args) {
		for(int i=0; i<n;i++) {
			somethings[i]= new Something();
		}
		// ���ǵ��� ���ݰ� ����. �׸��� ���̸�.
		for(int i=0;i<n;i++) {
			somethings[i].nameString=scanner.next();
			somethings[i].price=scanner.nextInt();
			somethings[i].weight=scanner.nextInt();
		}
		//���ǵ��� �������Ը� ���� List����.
		for(int i=0;i<n;i++) {
			int j = somethings[i].price / somethings[i].weight;
			arrayList.add(j);
		}
		//������������ ����.
		Collections.sort(arrayList,new AscendingInteger());
		// �� ���ҵ��� ����� ���ҵ鿡 ���� �������Դ� ���� �ʱ�ȭ �Ϸ�.
		
		while(w<=bag_weight) {
			int temp= findweight(arrayList, somethings);
			w=w+somethings[temp].weight;
			if(w>bag_weight) {
				w=w-somethings[temp].weight;
				break;
			}
			v=v+somethings[temp].price;
			real_name.add(somethings[temp].nameString);
			arrayList.remove(0);
		}
		
		if((bag_weight-w)>0) {
			int temp= findweight(arrayList, somethings);
			real_name.add(somethings[temp].nameString);
			v=v+(bag_weight-w)*arrayList.get(0);
		}

		System.out.println(real_name);
		System.out.println(v);
}	
		
	public static int findweight(ArrayList<Integer> arrayList,Something[] somethings) {
		int k=0;
		for(int j=0;j<n;j++) {
			int temp= somethings[j].price / somethings[j].weight;
			if(arrayList.get(0)==temp) {
				k=j;
			}
		}
	return k;
	}
}



class Something{
	String nameString;
	int price;
	int weight;
}

class AscendingInteger implements Comparator<Integer>{
	public int compare(Integer a, Integer b) {
		return b.compareTo(a);
	}
}

