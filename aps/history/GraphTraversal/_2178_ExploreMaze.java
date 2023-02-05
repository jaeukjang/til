package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2178_ExploreMaze {
	/*
	 * 미로탐색
	 * 1.인접행렬로 해서 사방탐색하면 되잖아?
	 * 2.min보다 넘어가면 가지치기하기
	 */
	
	static int n,m;
	static int[] map;
	static boolean[] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n*m];
		visited=new boolean[n*m];
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<m;j++) {
				map[i*m+j]= tmp.charAt(j)=='0'?0:1;
			}
		}
		visited[0]=true;
		bfs();
		System.out.println(map[n*m-1]);
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(0);
		visited[0]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/m;
			int c=cur%m;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				
				if(!visited[nr*m+nc]&&map[nr*m+nc]==1) {
					q.offer(nr*m+nc);
					visited[nr*m+nc]=true;
					map[nr*m+nc]=map[cur]+1;
				}
			}
			
		}
	}
}
