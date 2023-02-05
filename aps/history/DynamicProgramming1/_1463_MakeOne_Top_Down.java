package DynamicProgramming1;

import java.util.Scanner;

public class _1463_MakeOne_Top_Down {
	/*
	 * 1로 만들기 탑다운방식
	 * 1.분기점은 3가지 1을뺴거나 2로나누거나 3으로 나누기.
	 * 2.상향식으로 만들자. n부터 시작해서 dp[1]값을 도출.
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		dp[n]=0;
		int min;
		for(int i=n-1;i>=1;i--) {
			min=Integer.MAX_VALUE;
			min=dp[i+1]+1;
			if(i*2<=n) {
				min=Math.min(dp[i*2]+1, min);
			}
			if(i*3<=n) {
				min=Math.min(dp[i*3]+1, min);
			}
			dp[i]=min;
		}
		System.out.println(dp[1]);
	}
}	
