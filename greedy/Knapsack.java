package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//코드 만든이 인천대학교 정보통신공학과 서성부.
//https://github.com/inu0429/java_Myalgorighm.git

public class Knapsack {
		static int w;// 클래스 맴버들은 0으로 자동초기화.
		static int v;
		static Scanner scanner = new Scanner(System.in);
		//배낭의 무개를 만들자.
		static int bag_weight = scanner.nextInt();
		//물건을 몇개 만들건가?
		static int n = scanner.nextInt();
		//물건들을 객체배열로 생성.
		static Something[] somethings= new Something[n];
		// 단위무게당 가치를 담을 리스트.
		static ArrayList<Integer> arrayList = new ArrayList<Integer>(n);
		// 어떤 물건을 담았는지 보여줄 리스트.
		static ArrayList<String> real_name = new ArrayList<String>(n);
		
	public static void main(String[] args) {
		for(int i=0; i<n;i++) {
			somethings[i]= new Something();
		}
		// 물건들의 가격과 무게. 그리고 ㅇ이름.
		for(int i=0;i<n;i++) {
			somethings[i].nameString=scanner.next();
			somethings[i].price=scanner.nextInt();
			somethings[i].weight=scanner.nextInt();
		}
		//물건들의 단위무게를 담을 List생성.
		for(int i=0;i<n;i++) {
			int j = somethings[i].price / somethings[i].weight;
			arrayList.add(j);
		}
		//내림차순으로 정렬.
		Collections.sort(arrayList,new AscendingInteger());
		// 각 원소들을 만들고 원소들에 대한 단위무게당 까지 초기화 완료.
		
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

