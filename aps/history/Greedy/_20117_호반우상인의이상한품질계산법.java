package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20117_호반우상인의이상한품질계산법 {
	/*
	 * 호반우 상인의 이상한 품질 계산법
	 * 1. n이 짝수일때는 정렬한후 앞 절반 *2 더해준게 답
	 * 2. n이 홀 수 일때는 큰거중에 가장 작은것 하나만 따로
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans=0;
		for(int i=0;i<n/2;i++) {
			ans+=2*arr[n-1-i];
		}
		if(n%2==1) {
			ans+=arr[n/2];
		}
		System.out.println(ans);
	}
}
