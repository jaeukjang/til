package MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class _14621_MeetingApplication {
	/*
	 * 나만 안되는 연애
	 * 1. 기존 MST에서 M W 경로 check추가
	 * 2. W M 인지 체크해야하니까 크루스칼로는 못풀 것 같고 프림으로 풀자.
	 */
	static class Node implements Comparable<Node>{
		int to,weight;
		Node next;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	static int n,m;
	static char[] sex;
	static int[] min;
	static Node[] adjList;
	static PriorityQueue<Node> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		min=new int[n];
		sex=new char[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			sex[i]=st.nextToken().charAt(0);
		}
		adjList=new Node[n];
		int from,to,weight;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			from=Integer.parseInt(st.nextToken())-1;
			to=Integer.parseInt(st.nextToken())-1;
			weight=Integer.parseInt(st.nextToken());
			if(sex[from]!=sex[to]) {
				adjList[from]=new Node(to, weight, adjList[from]);
				adjList[to]=new Node(from, weight, adjList[to]);
			}
		}
		boolean[] visited=new boolean[n];
		Queue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(0,0));
		int cnt=0,sum=0;
		boolean flag=false;
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			if(visited[cur.to]) continue;
			
			visited[cur.to]=true;
			sum+=cur.weight;
			if(++cnt==n) {
				flag=true;
				break;
			}
			for(Node tmp=adjList[cur.to];tmp!=null;tmp=tmp.next) {
				if(!visited[tmp.to]) {
					pq.offer(new Node(tmp.to,tmp.weight));
				}
			}
			
		}
		if(flag) System.out.println(sum);
		else System.out.println(-1);
	}
	
}
