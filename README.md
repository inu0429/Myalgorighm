# Algorithm

## Java 알고리즘을 공부하면서 만든 코드들을 업로드 하고 있습니다.

Kakao Talk Id: 
`sb9904`


# 작업 스케줄링(Job scheduling) 


``` java
public class Main {
    public static void main(String[] args){
        int[] n = {4,8,16};
        int[] m = new int[2];

        JobScheduling(n,m);
    }

    static void JobScheduling(int[] n, int[] m){
        int[] n_time;

        for(int i=0;i<n.length;i++){
            int job=n[i];
            n_time=new int[job];

            for(int j=0;j<job;j++){
                n_time[j]=(int)(Math.random()*10)+1;
                System.out.print(n_time[j]+" ");
            }
            System.out.println();

            m[0]=n_time[0];
            System.out.println("m[0]:"+m[0]);
            m[1]=n_time[1];
            System.out.println("m[1]:"+m[1]);

            //기계가 두개 이니까 굳이 최솟값 찾는데 for문을 돌리지 않겠습니다.
            for(int j=2;j<n_time.length;j++){
                if(m[0]<m[1]) {
                    m[0] += n_time[j];
                    System.out.println("m[0]:"+m[0]);
                }
                else if (m[0]>m[1]) {
                    m[1] += n_time[j];
                    System.out.println("m[1]:"+m[1]);
                }
                else {
                    m[0] += n_time[j];
                    System.out.println("m[0]:"+m[0]);
                }
            }
            if(m[0]>m[1])
                System.out.println("작업이"+job+"일 때"+"가장 마지막에 완료한 작업시간은: "+m[0]);
            else
                System.out.println("작업이"+job+"일 때"+"가장 마지막에 완료한 작업시간은: "+m[1]);
        }
    }
}
```


* Run을 돌렸을 때 결과입니다. 원하는대로 잘 설계된 모습입니다.


![random](https://user-images.githubusercontent.com/80373000/118442331-6d476300-b725-11eb-86c4-9dd9bf1303fe.JPG)


# 시간복잡도와 근사비율


* 시간복잡도


n개의 작업을 배정하고(동시에 n개의 작업에 대한 작업시간도 같이 배정) 그리고 m개의 기계에 대해 시간을 탐색해야함


O(NM) 으로 나타낼 수 있습니다.


* 근사비율


Run을 한번 돌렸을 때 의 결과값을 가지고 근사값과 근사 비율을 구해봤습니다.


![근사](https://user-images.githubusercontent.com/80373000/118449391-13976680-b72e-11eb-9e38-f79d61cc1e36.JPG)

