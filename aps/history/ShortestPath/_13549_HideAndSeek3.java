package ShortestPath;

import java.io.*;
import java.util.*;

public class _13549_HideAndSeek3 {
	/*
	 * 숨바꼭질 3
	 * 1.이거 어려워... 다익스트라 배웠으니까 사용해서 풀어볼까
	 * 2.dp로 푸는건줄 알았는데... 일단 다익스트라 써볼까?
	 */
	static class Node implements Comparable<Node>{
		int no,weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s,e;
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		
		boolean[] visited=new boolean[200001];
		Queue<Node> q=new PriorityQueue<>();
		q.offer(new Node(s,0));
		int no,weight,ans=0;
		while(!q.isEmpty()) {
			Node cur=q.poll();
			no=cur.no;
			weight=cur.weight;
			if(visited[no]) continue;
//			System.out.println(no+" "+weight);
			visited[no]=true;
			if(no==e) {
				ans=weight;
				break;
			}
			if(no<e) {
				if(no!=0&&!visited[no*2]) {
					q.offer(new Node(no*2,weight));
				}
				if(!visited[no+1]) {
					q.offer(new Node(no+1,weight+1));
				}
			}
			if(no>0&&!visited[no-1]) {
				q.offer(new Node(no-1,weight+1));
			}
		}
		System.out.println(ans);
	}
}
