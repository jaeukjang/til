package DynamicProgramming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_ContinuousSum {
	/*
	 * 연속합
	 * 1.계속 더해가기
	 * 2.근데 이전 dp값이 0보다 작으면 내값이 dp값이 되버리기.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		int[] dp=new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		for(int i=1;i<n;i++) {
			if(dp[i-1]>0) {
				dp[i]=dp[i-1]+arr[i];
			}else {
				dp[i]=arr[i];
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
