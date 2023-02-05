package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _11055_가장큰증가부분수열 {
	/*
	 * 가장 큰 증가 부분 수열
	 * 1.수열의 합이 가장 커져야 하므로 dp배열은 따로
	 * 
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
		int max=0;
		dp[0]=arr[0];
		for(int i=1;i<n;i++) {
			dp[i]=arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]+=dp[j];
					max=Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}
