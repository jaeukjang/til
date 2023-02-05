package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2468_SafeArea{
	/*
	 * 안전영역
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
						bfs(j,k,i);
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
	private static void bfs(int sr, int sc, int h) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(sr);
		q.offer(sc);
		visited[sr][sc][h]=true;
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=n) continue;
				if(!visited[nr][nc][h]&&land[nr][nc]>h) {
					q.offer(nr);
					q.offer(nc);
					visited[nr][nc][h]=true;
				}
			}
		}
	}
	
}