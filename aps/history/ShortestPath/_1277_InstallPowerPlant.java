package ShortestPath;

import java.io.*;
import java.util.*;

public class _1277_InstallPowerPlant {
	/*
	 * 발전소 설치
	 * 1.하나로 문제랑 비슷하다. 거기다 이미 연결된 정점이 추가됨.
	 * 2.다익스트라를 사용할건데 미리 연결된거는 adjList에 담아두고 꺼내서 연결~.
	 * 3.visited로 관리하면서 방문처리
	 */
	static class Node implements Comparable<Node>{
		int no;
		double weight;
		Node next;
		public Node(int no, double weight) {
			this.no = no;
			this.weight = weight;
		}
		public Node(int no, double weight, Node next) {
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	static int[][] arr;
	static Node[] adjList;
	static int n,w;
	static double m;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		m=Double.parseDouble(br.readLine());
		arr=new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		int from,to;
		adjList=new Node[n];
		for(int i=0;i<w;i++) {
			st = new StringTokenizer(br.readLine());
			from=Integer.parseInt(st.nextToken())-1;
			to=Integer.parseInt(st.nextToken())-1;
			adjList[from]=new Node(to,0,adjList[from]);
			adjList[to]=new Node(from,0,adjList[to]);
		}
		visited=new boolean[n];
		Queue<Node> q=new PriorityQueue<>();
		q.offer(new Node(0,0));
		
		int no;
		double weight,dist;
		double ans=0;
		double[] dists=new double[n];
		Arrays.fill(dists, Double.MAX_VALUE);
		dists[0]=0;
		while(!q.isEmpty()) {
			Node cur=q.poll();
			
			no=cur.no;
			weight=cur.weight;
			
			if(visited[no]) continue;
			
			visited[no]=true;
//			System.out.println(no);
			if(no==n-1) {
				ans=dists[n-1];
				flag=true;
				break;
			}
			for(Node tmp=adjList[no];tmp!=null;tmp=tmp.next) {
				if(!visited[tmp.no]) {
					if(dists[tmp.no]>dists[no]) dists[tmp.no]=dists[no];
					q.offer(new Node(tmp.no,dists[tmp.no]));
				}
			}
			for(int i=0;i<n;i++) {
				if(!visited[i]&&no!=i) {
					dist=distance(no,i);
//					if(dist<=m)
						q.offer(new Node(i,dist+dists[no]));
					if(dists[i]>dists[no]+dist) dists[i]=dists[no]+dist;
				}
			}
		}
		ans=dists[n-1];
//		if(flag) 
//		System.out.println(Arrays.toString(dists));
			System.out.println((long)Math.floor(ans*1000));
//		else System.out.println(-1);
	}
	static double distance(int a,int b) {
		return Math.sqrt(Math.pow(arr[a][0]-arr[b][0], 2)+Math.pow(arr[a][1]-arr[b][1], 2));
	}
}
