package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class _2503_NumberBaseball {
	/*
	 * 숫자 야구
	 * 1. 기껏해봤자 9^3 경우의수 다 따져보면됨. 완전탐색
	 */
	
	static int n;
	static int[][] arr;
	static boolean[] visited=new boolean[10];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		arr=new int[n][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());//숫자
			arr[i][1]=Integer.parseInt(st.nextToken());//스트라이크
			arr[i][2]=Integer.parseInt(st.nextToken());//볼
		}
		
		dfs(0,0);
		System.out.println(cnt);
	}
	private static void dfs(int depth,int num) {
		if(depth==3) {
			if(check(num)) {
				cnt++;
			}
			return;
		}
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(depth+1,num*10+i);
				visited[i]=false;
			}
		}
	}
	private static boolean check(int num) {
		for(int i=0;i<n;i++) {
			if(arr[i][1]!=strikeCheck(arr[i][0],num))
				return false;
			if(arr[i][2]!=ballCheck(arr[i][0],num)) {
				return false;
			}
		}
		return true;
	}
	private static int ballCheck(int target, int num) {
		int cnt=0;
		if(target/100==(num%100)/10) cnt++;
		if(target/100==num%10) cnt++;
		if((target%100)/10==num/100) cnt++;
		if((target%100)/10==num%10) cnt++;
		if(target%10==num/100) cnt++;
		if(target%10==(num%100)/10) cnt++;
		return cnt;
	}
	private static int strikeCheck(int target, int num) {
		int cnt=0;
		if(target/100==num/100) cnt++;
		if((target%100)/10==(num%100)/10) cnt++;
		if(target%10==num%10) cnt++;
		return cnt;
	}
}
