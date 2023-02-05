package MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class _1774_CosmosGodConnecting {
	/*
	 * 우주신과의 교감
	 * 1. 하나로 문제와 비슷하다 거리를 sqrt double로 관리해야함.
	 * 2. 이미 연결된 것들은 서로 거리가 0이라고 생각해야함.
	 */
	static class Node implements Comparable<Node>{
		int to;
		double weight;
		Node next;
		
		public Node(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}

		public Node(int to, double weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight,o.weight);
		}
	}
	static long[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		map=new long[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0]=Long.parseLong(st.nextToken());
			map[i][1]=Long.parseLong(st.nextToken());
		}
		Node[] connected=new Node[n]; // 이미 연결된 통로를 관리하기 위한
 		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			connected[a]=new Node(b,0,connected[a]);
			connected[b]=new Node(a,0,connected[b]);
		}
 		
 		int cnt=0;
 		double sum=0;
 		double[] dist=new double[n];
 		boolean[] visited=new boolean[n];
 		Arrays.fill(dist, Integer.MAX_VALUE);
 		dist[0]=0;
 		PriorityQueue<Node> pq=new PriorityQueue<>();
 		pq.offer(new Node(0,0));
 		while(!pq.isEmpty()) {
 			Node tmp=pq.poll();
 			
 			if(visited[tmp.to]) continue;
 			
 			visited[tmp.to]=true;
 			sum+=tmp.weight;
 			if(++cnt==n) break;
 			//미리 connected 넣어주기
 			for(Node node=connected[tmp.to];node!=null;node=node.next) {
 				if(!visited[node.to]) {
 					dist[node.to]=0;
 					pq.offer(new Node(node.to,dist[node.to]));
 				}
 			}
 			// 그냥 전부 비교해서 넣기
 			for(int i=1;i<n;i++) {
 				if(!visited[i]&&dist[i]>distance(tmp.to,i)) {
 					dist[i]=distance(tmp.to,i);
 					pq.offer(new Node(i,dist[i]));
 				}
 			}
 			
 		}
 		System.out.printf("%.2f",(double) Math.round(sum * 100) / 100);
 		
	}
	private static double distance(int a, int b) {
		return Math.sqrt((double)Math.pow((double)map[a][0]-(double)map[b][0], 2)+(double)Math.pow((double)map[a][1]-(double)map[b][1], 2));
	}
	
}
