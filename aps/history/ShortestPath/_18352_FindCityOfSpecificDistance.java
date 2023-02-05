package ShortestPath;

import java.io.*;
import java.util.*;

public class _18352_FindCityOfSpecificDistance {
	/*
	 * 특정 거리의 도시 찾기
	 * 1.다익스트라로 최단거리 갱신해주면서... 거리가 K일때 값들 담고 break해버리기.
	 * 2.단방향 간선이므로 adjList로 관리해주면서 간선 갯수가 총 100만개~
	 * 
	 */
	static class Node implements Comparable<Node>{
		int no,weight;
		Node next;
		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	static Node[] adjList;
	static boolean[] visited;
	static int n,m,k,x;
	static TreeSet<Integer> set=new TreeSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		adjList=new Node[n+1];
		visited=new boolean[n+1];
		int from,to;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			from=Integer.parseInt(st.nextToken());
			to=Integer.parseInt(st.nextToken());
			adjList[from]=new Node(to,adjList[from]);
		}
		
		Queue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(x,0));
	
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			
			if(visited[cur.no]) continue;
			
			visited[cur.no]=true;
			int nw=cur.weight;
			if(nw==k) {
				set.add(cur.no);
			}
			if(nw>k) {
				break;
			}
			for(Node tmp=adjList[cur.no];tmp!=null;tmp=tmp.next) {
				if(!visited[tmp.no]) {
					pq.offer(new Node(tmp.no,nw+1));
				}
			}
		}
		if(set.size()==0) {
			sb.append(-1);
		}else {
			for(Integer i:set) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}
}
