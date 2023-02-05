package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_Resignation {
	/*
	 * 퇴사
	 * 1. N이 15까지이면  그냥 2^15이잖아 ?최대 경우의수가 별로안되네 브루트포스 ㄱㄱ
	 * 2. start부터 end까지 다 visited 해버려
	 */
	static int n,max;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		arr=new int[n+1][2];
		visited=new boolean[n+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i+1][0]=Integer.parseInt(st.nextToken());
			arr[i+1][1]=Integer.parseInt(st.nextToken());
		}
		dfs(1,0);
		System.out.println(max);
	}
	private static void dfs(int depth, int sum) {
		if(depth>=n+1) {
			return;
		}
		for(int i=depth;i<=n;i++) {
			if(!visited[i]&&i+arr[i][0]-1<=n) {
				for(int j=i;j<i+arr[i][0];j++) {
					visited[j]=true;
				}
				max=Math.max(max, sum+arr[i][1]);
				dfs(i+arr[i][0],sum+arr[i][1]);
				for(int j=i;j<i+arr[i][0];j++) {
					visited[j]=false;
				}
			}
		}
	}
}
