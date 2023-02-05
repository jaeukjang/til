package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _11048_Moving {
	/*
	 * 이동하기
	 * 1.우,하,우하 3가지 방향으로만 이동가능해서 dp로 계속 저장하는데 Math.max를 세번 돌려야할듯?
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][m];
		int[][] dp=new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=arr[0][0];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i==0&&j==0) {
					continue;
				}else if(i==0) {//위를 볼 필요가없어 좌만보면됨.
					dp[i][j]=dp[i][j-1]+arr[i][j];
				}else if(j==0) {//바로 위만 보면됨.
					dp[i][j]=dp[i-1][j]+arr[i][j];
				}else {//세개 다봐야됨. 좌, 좌상, 상
					dp[i][j]=Math.max(Math.max(dp[i][j-1], dp[i-1][j-1]),dp[i-1][j])+arr[i][j];
				}
			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}
