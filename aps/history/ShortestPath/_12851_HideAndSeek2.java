package ShortestPath;

import java.io.*;
import java.util.*;

public class _12851_HideAndSeek2 {
	/*
	 * 숨바꼭질 2
	 * 1.bfs로 찾는다. 2*x 가 1초걸리니까.
	 * 2.경로를 기록해놓을 필요가 없고. 숨바꼭질 4 코드 그대로 가져와서 좀 수정하자.
	 */
	static class Node {
		int no,weight;
		Node next;
		public Node(int no, int weight, Node next) {
			super();
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}
	static int s,e;
	static boolean[] visited;
	static int ans=-1;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		visited=new boolean[200001];
		
		bfs();
		System.out.println(ans);
		System.out.println(cnt);
	}
	private static void bfs() {
		Queue<Node> q=new ArrayDeque<>();
		q.offer(new Node(s,0,null));
		visited[s]=true;
		int no,weight;
		while(!q.isEmpty()) {
			Node cur=q.poll();
			no=cur.no;
			weight=cur.weight;
			
			if(no==e) {
				if(ans==-1) {
					ans=weight;
					cnt++;
				}else if(ans==weight) {
					cnt++;
				}
			}
			if(no!=e) visited[no]=true;
			if(no<e) {
				if(no!=0&&!visited[no*2]) {
					q.offer(new Node(no*2,weight+1,cur));
				}
				if(!visited[no+1]) {
					q.offer(new Node(no+1,weight+1,cur));
				}
			}
			if(no>0&&!visited[no-1]) {
				q.offer(new Node(no-1,weight+1,cur));
			}
		}
		
	}
}
