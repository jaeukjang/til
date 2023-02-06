    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class q16471_작은수내기 {
        /*
            정렬문제 같은데 둘다 정렬해두고 같은 숫자 주언이의 중앙값과
            사장의 중앙값을 비교하면 되는데 ?? 10만개면 그냥 정렬 NlogN정도면 될거같은데 collections sort하자.
         */
        public static void main(String[] args) throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int N=Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq1=new PriorityQueue<>();
            PriorityQueue<Integer> pq2=new PriorityQueue<>();
            StringTokenizer st1=new StringTokenizer(br.readLine());
            StringTokenizer st2=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                pq1.add(Integer.parseInt(st1.nextToken()));
                pq2.add(Integer.parseInt(st2.nextToken()));
            }
            int point=0;
            while(!pq1.isEmpty()&&!pq2.isEmpty()){
                if(pq1.peek()<pq2.poll()){
                    pq1.poll();
                    point++;
                }
            }
            String ans="";
            if(point>=(N+1)/2){
                ans="YES";
            }else{
                ans="NO";
            }
            System.out.println(ans);
        }
    }
