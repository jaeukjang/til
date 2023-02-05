package BackTracking;

import java.io.*;
import java.util.*;

public class _3980_Lineup {
	/*
	 * 선발명단
	 * 
	 * 1.중복이 없는 순열 문제로 (순서 상관있으니까.) 각 케이스별로 11! >>4천만개 일텐데
	 * 1-1. 가지치기를 어떻게 할까...? 일단 0인 스탯은 가지 쳐내버리기
	 * 2.max 값 출력
	 */
	
	static int max;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			arr=new int[11][11];
			visited=new boolean[11];
			for(int j=0;j<11;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<11;k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			max=0;
			dfs(0,0);
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}

	
	private static void dfs(int depth, int sum) {
		if(depth==11) {
			max=Math.max(max, sum);
			return;
		}
		for(int i=0;i<11;i++) {
			if(!visited[i]&&arr[depth][i]!=0) {
				visited[i]=true;
				dfs(depth+1,sum+arr[depth][i]);
				visited[i]=false;
			}
		}
	}
}
