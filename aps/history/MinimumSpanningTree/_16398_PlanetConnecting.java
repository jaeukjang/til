package MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class _16398_PlanetConnecting {
	/*
	 * 행성 연결
	 * 1.완전그래프 문제네 그냥 인접행렬로 받아버리고 프림을 돌리자.
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
	static int[][] edge;
	static int[] minEdge;
	static boolean[] visited;
	static PriorityQueue<Node> pq=new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		edge=new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				edge[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visited=new boolean[n];
		minEdge=new int[n];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		pq.offer(new Node(0,0));
		int cnt=0;
		long sum=0;
		while(true) {
			Node tmp=pq.poll();
			if(visited[tmp.no]) continue;
			
			visited[tmp.no]=true;
			
			sum+=tmp.weight;
			if(++cnt==n) break;
			for(int i=0;i<n;i++) {
				if(!visited[i]&&minEdge[i]>edge[tmp.no][i]) {
					minEdge[i]=edge[tmp.no][i];
					pq.offer(new Node(i,minEdge[i]));
				}
			}
		}
		System.out.println(sum);
	}
}
