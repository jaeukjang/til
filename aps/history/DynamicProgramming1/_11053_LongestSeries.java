package DynamicProgramming1;

import java.io.*;
import java.util.*;


public class _11053_LongestSeries {
	static int[] memo;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int max=0;
		int n=Integer.parseInt(br.readLine());
		arr=new int[n];
		memo=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			memo[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					memo[i]=Math.max(memo[i], memo[j]+1);
				}
			}
			max=Math.max(max,memo[i]);
		}
		System.out.println(max);
	}
}
