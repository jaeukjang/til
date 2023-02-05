package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2468_SafeArea_dfs{
	/*
	 * 안전영역_using dfs
	 * 1. 탐색조건을 비의 높이로 해서 cnt 넣으면 되잖아?
	 */
	static int[] cnts;
	static int[][] land;
	static boolean[][][] visited;
	static int n,high;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		land=new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				land[i][j]=Integer.parseInt(st.nextToken());
				high=Math.max(high, land[i][j]);
			}
		}
		cnts=new int[high+1];
		visited=new boolean[n][n][high+1];
		
		for(int i=1;i<=high;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(!visited[j][k][i]&&land[j][k]>i) {
						cnts[i]++;
						dfs(j,k,i);
					}
				}
			}
		}
		Arrays.sort(cnts);
		if(cnts[high]==0) {
			System.out.println(1);
		}else {
			System.out.println(cnts[high]);
		}
		
	}
	private static void dfs(int r, int c, int h) {
		visited[r][c][h]=true;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nc<0||nr>=n||nc>=n) continue;
			if(!visited[nr][nc][h]&&land[nr][nc]>h) {
				dfs(nr,nc,h);
			}
		}
	}
	
}