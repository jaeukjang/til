package ShortestPath;

import java.io.*;
import java.util.*;

public class _11265_EndlessParty {
	/*
	 * 끝나지 않은 파티
	 * 1.인접행렬 받고, 플로이드 워셜 알고리즘 사용
	 * 2.경유지 거쳐서 최단 비용으로 다 고쳐놓고
	 * 3.요청 처리해주기.
	 */
	static int n,m;
	static long[][] arr;
	static long max=Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new long[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Long.parseLong(st.nextToken());
				if(arr[i][j]==0) arr[i][j]=max;
			}
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][k]!=max&&arr[k][j]!=max&&arr[i][j]>(arr[i][k]+arr[k][j])) {
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		int a,b,c;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken())-1;
			b=Integer.parseInt(st.nextToken())-1;
			c=Integer.parseInt(st.nextToken());
			if(arr[a][b]<=c) {
				sb.append("Enjoy other party\n");
			}else {
				sb.append("Stay here\n");
			}
		}
		System.out.println(sb);
	}
}
