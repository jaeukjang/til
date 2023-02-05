package BackTracking;

import java.io.*;
import java.util.*;

public class _18430_WeaponEngineering {
	/*
	 * 무기공학
	 * 
	 * 1. n*m 2차원배열 만들기.
	 * 1-1. 무기 만들었으면 그부분 vistied true 해버리고
	 * 1-2. visited false 일경우에만 탐색.
	 * 1-3. depth는 n*m으로 (n,m이 5이하라 괜찮을듯)
	 * 2. 분기점은 총 5개 만들었냐(4가지 경우)/안만들고 넘어갔냐
	 * 2-1. 기저조건에서 max와 비교하고 갱신
	 */
	
	static int n,m,max;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(max);
	}

	private static void dfs(int depth, int sum) {
		if(depth>=n*m) {
			max=Math.max(max, sum);
			return;
		}
		int r=depth/m;
		int c=depth%m;
		if(!visited[r][c]) {
			// 총 4개 경우의 수 만들어야함.
			//1사분면
			if(r-1>=0&&c+1<m&&!visited[r-1][c]&&!visited[r][c+1]) {
				visited[r][c]=true;
				visited[r-1][c]=true;
				visited[r][c+1]=true;
				dfs(depth+1,sum+arr[r][c]*2+arr[r-1][c]+arr[r][c+1]);
				visited[r][c]=false;
				visited[r-1][c]=false;
				visited[r][c+1]=false;
			}
			//2사분면
			if(r-1>=0&&c-1>=0&&!visited[r-1][c]&&!visited[r][c-1]) {
				visited[r][c]=true;
				visited[r-1][c]=true;
				visited[r][c-1]=true;
				dfs(depth+1,sum+arr[r][c]*2+arr[r-1][c]+arr[r][c-1]);
				visited[r][c]=false;
				visited[r-1][c]=false;
				visited[r][c-1]=false;
			}
			//3사분면
			if(r+1<n&&c-1>=0&&!visited[r+1][c]&&!visited[r][c-1]) {
				visited[r][c]=true;
				visited[r+1][c]=true;
				visited[r][c-1]=true;
				dfs(depth+1,sum+arr[r][c]*2+arr[r+1][c]+arr[r][c-1]);
				visited[r][c]=false;
				visited[r+1][c]=false;
				visited[r][c-1]=false;
			}
			//4사분면
			if(r+1<n&&c+1<m&&!visited[r+1][c]&&!visited[r][c+1]) {
				visited[r][c]=true;
				visited[r+1][c]=true;
				visited[r][c+1]=true;
				dfs(depth+1,sum+arr[r][c]*2+arr[r+1][c]+arr[r][c+1]);
				visited[r][c]=false;
				visited[r+1][c]=false;
				visited[r][c+1]=false;
			}
		}
		dfs(depth+1,sum); // 안하고 넘어가기
		
	}
}
