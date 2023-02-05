package GraphTraversal;

import java.io.*;
import java.util.*;

public class _7576_Tomato1 {
	/*
	 * 토마토
	 * 1. 익은 토마토를 큐에 담고  visited에 넣고 그 주변을 탐색.
	 * 2. 그전에 익은 day에서 +1하기.
	 */
	static int[] status;
	static boolean[] visited;
	static int m,n;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		status=new int[n*m];
		visited=new boolean[n*m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				status[i*m+j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		boolean flag=true;
		int max=0;
		for(int i=0;i<n*m;i++) {
			if(status[i]==0) {
				flag=false;
				break;
			}else {
				max=Math.max(max, status[i]);
			}
		}
		if(flag) {
			System.out.println(max-1);
		}else {
			System.out.println(-1);
		}
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n*m;i++) {
			if(status[i]==1) {
				q.offer(i);
				visited[i]=true;
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/m;
			int c=cur%m;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				int next=nr*m+nc;
				if(status[next]==0) {
					q.offer(next);
					visited[next]=true;
					status[next]=status[cur]+1;
				}
			}
		}
		
	}
}
