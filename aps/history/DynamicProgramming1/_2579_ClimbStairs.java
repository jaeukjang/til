package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _2579_ClimbStairs {
	/*
	 * 계단 오르기
	 * 1.dp에 저장할 값은 나를 무조건 포함한 값이다.
	 * 2.경우의수는 두가지. 내 이전 혹은 내전전을 건너뜀.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n+2];//n==1일때 dp[2] indexout나서 n+2로
		int[] dp=new int[n+2];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		dp[2]=arr[1]+arr[2];
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);//i-2번째를 건너뛰던가, i-1번째를 건너뛴 값. 에다가 나는 무조건 포함.
		}
		//이러면 dp[n]은 무조건 n번째가 밟게된다.
		System.out.println(dp[n]);
	}
}
