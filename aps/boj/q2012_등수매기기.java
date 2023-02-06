import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q2012_등수매기기 {
    /*
        그냥 정렬해서 바꾸면 안되나?
        ❌ 너무 쉽게 생각했구나..
        1 1 1 3 5
        1 2 4 3 5 >> 4차이
        1 2 3 4 5 >> 4차이

        3 3 5 5 5
        1 2 3 4 5 >> 6차이
        3 4 1 2 5
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        boolean[] visited=new boolean[N+1];
        int input;
        for(int i=0;i<N;i++){
            input=sc.nextInt();
            if(!visited[input]){
                visited[input]=true;
            }else{
                pq.add(input);
            }
        }
        long sum=0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                sum+=Math.abs(i-pq.poll());
            }
        }
        System.out.println(sum);
    }
}
