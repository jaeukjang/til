package ShortestPath;

import java.io.*;
import java.util.*;

public class _13913_HideAndSeek4 {
	/*
	 * 숨바꼭질 4
	 * 1.bfs로 찾는다... 2*x 가 1초걸리니까...
	 * 2.경로를 기록해놔야해 visited처리 뿐만 아니라 이전꺼를 adjList로 저장해두기.
	 * 3.나중에 뽑을때 스택에 다 넣고 pop해서 출력하자.
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
	static Node ans;
	static int s,e;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		visited=new boolean[200001];
		
		bfs();
		sb.append(ans.weight+"\n");
		Stack<Integer> stk=new Stack<>();
		for(Node tmp=ans;tmp!=null;tmp=tmp.next) {
			stk.push(tmp.no);
		}
		while(!stk.isEmpty()) {
			sb.append(stk.pop()+" ");
		}
		System.out.println(sb);
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
				ans=cur;
				break;
			}
			if(no<e) {
				if(no!=0&&!visited[no*2]) {
					q.offer(new Node(no*2,weight+1,cur));
					visited[no*2]=true;
				}
				if(!visited[no+1]) {
					q.offer(new Node(no+1,weight+1,cur));
					visited[no+1]=true;
				}
			}
			if(no>0&&!visited[no-1]) {
				q.offer(new Node(no-1,weight+1,cur));
				visited[no-1]=true;
			}
		}
		
	}
}
