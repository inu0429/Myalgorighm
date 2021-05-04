# 수업시간에 다룬 클래스들로 정의.

수업시간에 다룬 인터페이스와 클래스들로 그대로 구현했습니다.
***
# Bubble Sort

* 오름차순 버블정렬입니다.
```
import java.util.ArrayList;

public class BubbleSort extends AwesomeSort {
    @Override
    public int[] sort(int[] p) {
        int[] x = p.clone();
        for (int i = 0; i < x.length; i++) {
            for (int j = 1; j < x.length; j++) {
                if (x[j - 1] > x[j]) {
                    int temp = x[j - 1];
                    x[j - 1] = x[j];
                    x[j] = temp;
                }
            }
        }
        return x;
    }
}
```
시간 복잡도는 `n*n= n제곱` 입니다.

* main 함수 실행결과입니다.

![버블정렬 메인](https://user-images.githubusercontent.com/80373000/116962458-f8b20480-ace0-11eb-87b2-50f8519727b0.JPG)

# Insertion Sort

* 역순출력(내림차순) 삽입정렬입니다.
```
public class InsertionSort extends  AwesomeSort{
    @Override
    public int[] sort(int[] p) {
        int[] x = p.clone();
        for (int i = 1; i < x.length; i++) {
            int tmp = x[i];
            for (int j = i; j > 0 && x[j - 1] < tmp; j--) {
                x[j] = x[j - 1];
                x[j - 1] = tmp;
            }
        }
        return x;
    }
}
```
시간 복잡도는 `n*n= n제곱` 입니다.


* main 함수 실행결과입니다.
    ![삽입정렬 시간](https://user-images.githubusercontent.com/80373000/116873978-834c2280-ac53-11eb-887c-aa7b69665b59.JPG)
*** 

# Selection Sort

* 역순출력(내림차순) 선택정렬입니다.

```
public class SelectionSort extends AwesomeSort{
    @Override
    public int[] sort(int[] p){
        int[] x = p.clone();
        int n =p.length;
        for(int i=0;i<n;i++){
            int idx=i;
            for(int j=i;j<n;j++){
                if(x[idx]<x[j]){
                    idx=j;
                }
            }
            int temp=x[i];
            x[i]=x[idx];
            x[idx]=temp;
        }
        return x;
    }
}
```
시간 복잡도는 `n*n= n제곱` 입니다.

* main 함수 실행결과입니다.
    ![선택정렬 시간](https://user-images.githubusercontent.com/80373000/116873980-834c2280-ac53-11eb-8b55-fc4acd0d01ab.JPG)
***
# Shell Sort

* 역순출력(내림차순) 셸 정렬입니다.
```
public class ShellSort extends  AwesomeSort{
    @Override
    public int[] sort(int[] p) {
        int[] x =p.clone();
        int n= x.length;
        for(int i=n/2;i>0;i/=2){
            for(int j=i;j<n;j++){
                int temp =x[j];
                for(int k=j-i;k>=0 && x[k]<temp;k-=i){
                    x[k+i]=x[k];
                    x[k]=temp;
                }
            }
        }

        return x;
    }
}
```
시간 복잡도는 `n*n= n제곱` 입니다.

* main 함수 실행결과입니다.
    ![셸 정렬시간](https://user-images.githubusercontent.com/80373000/116873975-821af580-ac53-11eb-8afd-b99fea2fc5b3.JPG)
***

# 크기가 커졌을 때 셸 정렬과 선택,삽입 정렬 차이.

n값이 작을 때는 별로 티가 안나서 500까지 올려주었는데 시간 차이가 조금씩 나기 시작했습니다. 

근소하게 셸 정렬이 빠른 것을 볼 수 있습니다.

* 삽입, 선택 500크기 시간

    ![삽입 500](https://user-images.githubusercontent.com/80373000/116873977-82b38c00-ac53-11eb-94b1-cc09cf7d8add.JPG)

* 셸 500 크기 시간

    ![셸 500](https://user-images.githubusercontent.com/80373000/116873981-83e4b900-ac53-11eb-8faa-47728f377fd0.JPG)
