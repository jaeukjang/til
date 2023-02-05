package GraphTraversal;

import java.io.*;
import java.util.*;

public class _1260_DFSandBFS {
	/*
	 * DFS와 BFS
	 * 1. 간선의갯수가 상대적으로 적으니 인접리스트 사용하고 싶은데 문제의 조건이 있어서 인접행렬 ㄱ
	 */
	static StringBuilder sb = new StringBuilder();
	static int n,m,v;
	static boolean[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		arr=new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			arr[from][to]=arr[to][from]=true;
		}
		visited=new boolean[n+1];
		dfs(v);
		visited=new boolean[n+1];
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}
	private static void dfs(int from) {
		visited[from]=true;
		sb.append(from+" ");
		for(int i=1;i<=n;i++) {
			if(arr[from][i]&&!visited[i]) {
				dfs(i);
			}
		}
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(v);
		visited[v]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			sb.append(cur+" ");
			for(int i=1;i<=n;i++) {
				if(arr[cur][i]&&!visited[i]) {
					visited[i]=true;
					q.offer(i);
				}
			}
		}
	}
}
