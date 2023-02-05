package DynamicProgramming1;

import java.io.*;
import java.util.*;
public class _1231_주식왕동호 {
	/*
	 * 주식왕 동호
	 * 1. 알고스탁이랑 똑같지 않나?
	 */
	static int[][] price;
	static int[][] profit;
	static int N,L,sum;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());//주식의 종류
		L=Integer.parseInt(st.nextToken());//Day 기간
		sum=Integer.parseInt(st.nextToken());//초기비용
		
		price=new int[N+1][L];
		profit=new int[N+1][L-1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<L;j++) {
				price[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=0;j<L-1;j++) {
				profit[i][j]=price[i][j+1]-price[i][j];
			}
		}
		
		dp=new int[N+1][500001];
		for(int m=0;m<L-1;m++) {//month
			for(int i=1;i<=N;i++) {//종목
				int cnt=1;
				for(int j=1;j<=sum;j++) {//비용
					dp[i][j]=dp[i-1][j];
					if(j>=price[i][m]*cnt) {
						if(j>=price[i][m]*(cnt+1)) {
							cnt++;
						}
						if(cnt==1)
							dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-price[i][m]]+profit[i][m]);
						else
							dp[i][j]=Math.max(Math.max(dp[i-1][j], dp[i-1][j-price[i][m]]+profit[i][m]),dp[i][j-price[i][m]]+profit[i][m]);
					}
				}
			}
			sum+=dp[N][sum];
		}
		System.out.println(sum);
	}

}


