package GraphTraversal;

import java.io.*;
import java.util.*;


public class _11725_FindParentNode {
	/*
	 * 트리의 부모 찾기
	 * 1. 정점 1로 시작했을때 큐나 스택에 들어가기 직전의 노드를 부모로 넣기.
	 * 2. 각각의 노드들에 parent node 배열을 관리하자. 
	 * 3. 노드의 갯수가 10만개 >> 인접 리스트 쓰기
	 */
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
	}
	static int n;
	static int[] parentNode;
	static boolean[] visited;
	static Node[] nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		nodes=new Node[n+1];
		parentNode=new int[n+1];
		visited=new boolean[n+1];
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			nodes[from]=new Node(to,nodes[from]);
			nodes[to]=new Node(from,nodes[to]);
		}
		
		dfs(1);
		for(int i=2;i<=n;i++) {
			sb.append(parentNode[i]+"\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cur) {
		visited[cur]=true;
		for(Node tmp=nodes[cur];tmp!=null;tmp=tmp.next) {
			if(!visited[tmp.to]) {
				parentNode[tmp.to]=cur;
				dfs(tmp.to);
			}
		}
		
	}
	
}
