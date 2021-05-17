# Algorithm

## Java 알고리즘을 공부하면서 만든 코드들을 업로드 하고 있습니다.

Kakao Talk Id: 
`sb9904`


# 작업 스케줄링(Job scheduling) 


```
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



