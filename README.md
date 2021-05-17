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
            }
            m[0]=n_time[0];
            m[1]=n_time[1];

            //기계가 두개 이니까 굳이 최솟값 찾는데 for문을 돌리지 않겠습니다.
            for(int j=2;j<n_time.length;j++){
                if(m[0]<m[1])
                    m[0]+=n_time[j];
                else if (m[0]>m[1])
                    m[1]+=n_time[j];
                else
                    m[0]+=n_time[j];
            }
            if(m[0]>m[1])
                System.out.println("작업이"+job+"일 때"+"가장 마지막에 완료한 작업시간은: "+m[0]);
            else
                System.out.println("작업이"+job+"일 때"+"가장 마지막에 완료한 작업시간은: "+m[1]);
        }
    }
}
```


* 결과값이 원하는대로 출력하는지 확인하기 위해서 작업시간을 4로 고정한 채로 출력해봤습니다.


![4](https://user-images.githubusercontent.com/80373000/118442562-b5668580-b725-11eb-818f-3b094af0bdf3.JPG)


* 결과값이 원하는대로 나왔습니다. 알고리즘에는 문제가 없으니 이제 랜덤값을 넣어줘서 값을 확인합니다.


![random](https://user-images.githubusercontent.com/80373000/118442331-6d476300-b725-11eb-86c4-9dd9bf1303fe.JPG)


# 시간복잡도와 근사비율


* 시간복잡도


n개의 작업을 배정하고(동시에 n개의 작업에 대한 작업시간도 같이 배정) 그리고 m개의 기계에 대해 시간을 탐색해야함


O(NM) 으로 나타낼 수 있습니다.


* 근사비율

