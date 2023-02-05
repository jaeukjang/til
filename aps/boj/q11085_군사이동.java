import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11085_군사이동 {
    /**
     * 군사이동
     * p개의 노드와 w개의 간선 은 양방향으로 이어져있다.
     * 첫줄에 p w
     * 두번째줄에 c 시작지점 v 도착지점
     * 세번째줄부터는 w개의 줄이 w_start w_end w_width 가 주어짐
     *
     * 그래프를 탐색해야하는데 starting point에서 end point까지 가는 여러가지 path중에서
     * 최소넓이가 가장 큰 path를 찾고 최소넓이를 출력하는 문제
     * how to?
     * dijoint set을 이용해서 우선 pq에 w_width가 큰순으로 정렬하고 차례대로 join
     * start node와 end node가 같은 set에 있을때까지
     * join할때 group의 width를 두고 그 값을 갱신하자.
     */
    static class Edge implements Comparable<Edge>{
        int node1;
        int node2;
        int width;

        @Override
        public int compareTo(Edge o) {
            return o.width-this.width;
        }

        public Edge(int node1, int node2, int width) {
            this.node1 = node1;
            this.node2 = node2;
            this.width = width;
        }
    }
    static int p,w,s,e;
    static Queue<Edge> pq=new PriorityQueue<>();
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        p=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        int node1,node2,width;
        for(int i=0;i<w;i++){
            st=new StringTokenizer(br.readLine());
            node1=Integer.parseInt(st.nextToken());
            node2=Integer.parseInt(st.nextToken());
            width=Integer.parseInt(st.nextToken());
            pq.add(new Edge(node1,node2,width));
        }
        root=new int[p];
        for(int i=0;i<p;i++){
            root[i]=i;
        }
        Edge edge;
        while(true){
            edge=pq.poll();
            union(edge.node1, edge.node2);
            if(find(s)==find(e)){
                System.out.println(edge.width);
                break;
            }
        }
    }
    static int find(int a){
        if(a==root[a]){
            return a;
        }
        return root[a]=find(root[a]);
    }
    static boolean union(int a,int b){
        int ar=find(a);
        int br=find(b);
        if(ar==br) return false;
        root[br]=ar;
        return true;
    }
}
