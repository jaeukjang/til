package ShortestPath;

import java.io.*;
import java.util.*;

public class _1753_ShortestPath {
	/*
	 * 최단경로
	 * using Dijkstra
	 * 
	 */
	static class Node{
		int vertex,weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int no,weight;
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int V,E;
	static boolean[] visited; // 신장트리에 포함여부 (크루스칼의 집합을 만들듯이)
	static int[] dist;
	static PriorityQueue<Vertex> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(br.readLine())-1;
		
		visited=new boolean[V];
		dist=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s]=0;

		Node[] adjList=new Node[V];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken())-1;
			int to=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			adjList[from]=new Node(to,weight,adjList[from]);
//			adjList[to]=new Node(from,weight,adjList[to]);
		}
		
		int cnt=0;
		pq.offer(new Vertex(s,0));
		while(!pq.isEmpty()) {
			Vertex tmp=pq.poll();
			
			if(visited[tmp.no]) continue;
			
			visited[tmp.no]=true;
			if(++cnt==V) break;
			for(Node cur=adjList[tmp.no];cur!=null;cur=cur.next) {
				if(!visited[cur.vertex]&&dist[cur.vertex]>dist[tmp.no]+cur.weight) {
					dist[cur.vertex]=dist[tmp.no]+cur.weight;
					pq.offer(new Vertex(cur.vertex,dist[cur.vertex]));
				}
			}
		}
		for(int i=0;i<V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF"+"\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb);
	}
}
