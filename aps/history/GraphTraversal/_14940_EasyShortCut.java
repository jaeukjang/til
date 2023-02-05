package GraphTraversal;

import java.io.*;
import java.util.*;

public class _14940_EasyShortCut{
	/*
	 * 쉬운 최단거리
	 * 1.목표지점 까지의 거리니까 목표지점에서 출발
	 * 2.목표지점을 0으로 놓고 더하기 하기 depth만큼 
	 */
	static int n,m;
	static int[] map;
	static int[] ans;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n*m];
		ans=new int[n*m];
		Arrays.fill(ans, -1);
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i*m+j]=Integer.parseInt(st.nextToken());
				if(map[i*m+j]==0) ans[i*m+j]=0; //ans에도 벽만들어주기
			}
		}
		bfs();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(ans[i*m+j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n*m;i++) {
			if(map[i]==2) {
				q.offer(i);
				ans[i]=0;
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
				int tmp=nr*m+nc;
				if(map[tmp]==1&&ans[tmp]==-1) {
					q.offer(tmp);
					ans[tmp]=ans[cur]+1;
				}
			}
		}
	}
}