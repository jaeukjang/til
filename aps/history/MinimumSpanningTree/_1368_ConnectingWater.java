package MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class _1368_ConnectingWater {
	/*
	 * 물대기
	 * 기존  인접행렬을 준 MST문제에서 직접 우물을 파는 거까지 고려해서 짜야한다.
	 * n개중 1개이상은 무조건 우물을 파야하고 그거를 커넥팅 해야하는거까지 고려~
	 * 오잉 18% 틀렸습니다.는 뭘까...
	 */
	static class Node implements Comparable<Node>{
		int no,weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	static int n;
	static boolean[] visited;
	static int[][] edge;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		edge=new int[n+1][n+1];
		visited=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			edge[i][0]=edge[0][i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				edge[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(0,0));
		int sum=0;
		int cnt=0;
		while(true) {
			Node cur=pq.poll();
			if(visited[cur.no]) continue;
			
			visited[cur.no]=true;
			sum+=cur.weight;
			if(++cnt==n+1) break;
			
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					pq.offer(new Node(i,edge[cur.no][i]));
				}
			}
			
		}
		System.out.println(sum);
	}
}
