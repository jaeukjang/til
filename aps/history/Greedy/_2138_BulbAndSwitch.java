package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2138_BulbAndSwitch {
	/*
	 * 전구와 스위치
	 * 불가능한 경우 -1 
	 */
	static int n;
	static int min=Integer.MAX_VALUE;
	static int[] arr;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		String tmp=br.readLine();
		String tmp2=br.readLine();
		arr=new int[n];
		int[] arr2=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=tmp.charAt(i)-'0';
			if(arr[i]==tmp2.charAt(i)-'0') {
				arr[i]=0;
			}else {
				arr[i]=1;
			}
			arr2[i]=arr[i];
		}
		int cnt1=1;
		//첫번째 전구 스위치 on
		on(0);
		for(int i=0;i<n-1;i++) {
			if(arr[i]==1) {
				on(i+1);
				cnt1++;
			}
		}
		if(arr[n-1]==0) {
			flag=true;
			min=cnt1;
		}
		for(int i=0;i<n;i++) {
			arr[i]=arr2[i];
		}
		int cnt2=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]==1) {
				on(i+1);
				cnt2++;
			}
		}
		if(arr[n-1]==0) {
			flag=true;
			min=Math.min(min, cnt2);
		}
		if(flag) System.out.println(min);
		else System.out.println(-1);
	}


	private static void on(int a) {
		if(a==0) {
			arr[a]^=1;
			arr[a+1]^=1;
		}else if(a==n-1) {
			arr[a]^=1;
			arr[a-1]^=1;
		}else {
			arr[a-1]^=1;
			arr[a]^=1;
			arr[a+1]^=1;
		}
	}
}
