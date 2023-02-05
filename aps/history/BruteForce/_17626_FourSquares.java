package BruteForce;

import java.io.*;
import java.util.*;

public class _17626_FourSquares{
	/*
	 * Four Squares
	 * 1.n의 제곱근부터 시작해서 최대 700^4 정도인가?.음...에러인데  이러면
	 * 2. 계속 n과 비교하면서 min값을 depth로 갱신
	 * 3. depth==4 이면 return 끝내
	 */
	static int n,k;
	static int min=5;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		k=(int)Math.sqrt(n);
		dfs(0,0,k);
		System.out.println(min);
	}
	private static void dfs(int depth,int num,int start) {
		if((4-depth)*start*start<n-num) {
			return;
		}
		if(num>n) {
			return;
		}
		if(depth>=min) {
			return;
		}
		if(num==n) {
			min=Math.min(min, depth);
			return;
		}
		if(depth==4) {
			return;
		}
		
		for(int i=k;i>=1;i--) {
			dfs(depth+1,num+i*i,i);
		}
	}
}