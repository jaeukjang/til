package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _17069_MovingPipe2 {
	/*
	 * 파이프 옮기기2
	 * 1.얘도 이동하기 문제랑 비슷하다 . dp로 좌상, 좌, 상값을 확인하고 가능하면 값을 더해야함.
	 * 2.대신 까다로운건 position이랑 벽을 고려해야한다는점.
	 */
	static int n,cnt;
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		dp=new long[n][n][3]; //합과, position 까지 기록해두자. // pos 0은 가로, pos 1은 세로 pos2는 대각
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0]=1;
		for(int i=0;i<n;i++) {
			for(int j=1;j<n;j++) { //j=0을 갈 이유가 없어.
				if(map[i][j]==1) continue; //내가 벽이면 넘어가
				
				if(i==0) {//위를 볼 필요가없어 좌만보면됨.
					if(j==1) { //첫 위치는 생략
						continue;
					}
					if(dp[i][j-1][0]!=0)//그 전까지 길이 있었구나.
						dp[i][j][0]=dp[i][j-1][0];
				}else {//세개 다봐야됨. 좌, 상, 좌상
					//좌 pos 0,2만 체크
					if(dp[i][j-1][0]!=0) dp[i][j][0]+=dp[i][j-1][0]; //0 pos
					if(dp[i][j-1][2]!=0) dp[i][j][0]+=dp[i][j-1][2]; //2 pos
					//상 pos 1,2만 체크
					if(dp[i-1][j][1]!=0) dp[i][j][1]+=dp[i-1][j][1]; //1 pos
					if(dp[i-1][j][2]!=0) dp[i][j][1]+=dp[i-1][j][2]; //2 pos
					//좌상 얘는 어떤 포지션이든 다가능해 장애물만 체크.
					if(map[i-1][j]==0&&map[i][j-1]==0) {// 장애물 체크부터.
						if(dp[i-1][j-1][0]!=0) dp[i][j][2]+=dp[i-1][j-1][0]; //0 pos
						if(dp[i-1][j-1][1]!=0) dp[i][j][2]+=dp[i-1][j-1][1]; //1 pos
						if(dp[i-1][j-1][2]!=0) dp[i][j][2]+=dp[i-1][j-1][2]; //2 pos
					}
					
				}
			}
		}
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<n;j++) {
//				for(int k=0;k<n;k++) {
//					System.out.print(dp[j][k][i]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------- "+i);
//		}
		System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
	}

}
