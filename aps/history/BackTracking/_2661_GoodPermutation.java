package BackTracking;

import java.io.*;
import java.util.*;

public class _2661_GoodPermutation {
	/*
	 * 좋은순열
	 * 1. n/2 만큼 되돌아가서 같은지  검사
	 */
	static int n;
	static int[] arr;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n];
		
		dfs(0,0);
		System.out.println(sb);
	}
	private static void dfs(int depth,int past) {
		if(flag) {//처음 찾았으면 끝내
			return;
		}
		if(check(depth)) {
			return;
		}
		if(depth==n) {
			for(int i=0;i<n;i++) {
				sb.append(arr[i]);
			}
			flag=true;
			return;
		}
		for(int i=1;i<=3;i++) {
			if(past!=i) {
				arr[depth]=i;
				dfs(depth+1,i);
			}
		}
	}
	private static boolean check(int depth) {
		if(depth==0) {
			return false;
		}
		
		for(int i=1;i<=depth/2;i++) {
			boolean flag2 =true;
			for(int j=0;j<i;j++) {
				if(arr[depth-1-(j+i)]!=arr[depth-1-j]) {
					flag2=false;
					break;
				}
			}
			if(flag2) {//같네?
				return true;
			}
		}
		return false;
	}
}
