package DynamicProgramming1;

import java.util.Scanner;

public class _1463_MakeOne {
	/*
	 * 1로 만들기
	 * 1.분기점은 3가지 1을뺴거나 2로나누거나 3으로 나누기.
	 * 2.상향식으로 만들자. 1부터 시작해서 dp[n]값을 도출.
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		int min;
		for(int i=2;i<=n;i++) {
			min=Integer.MAX_VALUE;
			if(i%2==0) {
				min=dp[i/2]+1;
			}
			if(i%3==0) {
				min=Math.min(min, dp[i/3]+1);
			}
			min=Math.min(min, dp[i-1]+1);
			dp[i]=min;
		}
		System.out.println(dp[n]);
	}
}	
