package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _1520_DownHill {
	/*
	 * 내리막 길
	 * 1.TopDown방식으로 짜보자. memoization하고
	 */
	static int n,m;
	static int[][] map;
	static int[][] memo;
//	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		memo=new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(memo[i],-1);
		}
//		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
//		visited[0][0]=true;
		int ans=dfs(0,0);
		System.out.println(ans);
	}
	private static int dfs(int r, int c) {
		if(r==n-1&&c==m-1) {
			return 1;
		}
		if(memo[r][c]!=-1) {
			return memo[r][c];
		}
		int nr,nc;
		int result=0;
		for(int i=0;i<4;i++) {
			nr=r+dr[i];
			nc=c+dc[i];
			if(nr<0||nc<0||nr>=n||nc>=m) continue;
//			if(!visited[nr][nc]&&map[r][c]>map[nr][nc]) {
			if(map[r][c]>map[nr][nc]) {
//				visited[nr][nc]=true;
				result+=dfs(nr,nc);
//				visited[nr][nc]=false;
			}
		}
		memo[r][c]=result;
		return result;
	}
	
}
