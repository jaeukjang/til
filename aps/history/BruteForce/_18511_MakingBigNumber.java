package BruteForce;

import java.io.*;
import java.util.*;

public class _18511_MakingBigNumber {
	/*
	 * 큰 수 구성하기
	 * N보다 작거나 같은 자연수 중 집합 K의  원소로만  구성된 가장 큰 수를 출력. 만들 수 있는 경우만 주어짐.
	 * 10<=N<=10억 1<=K=3
	 * 1. 조합으로 만들면 N=10억일때 기껏해야 3^9 그냥 완전탐색 돌리자.
	 */
	static int n,k,size,max;
	static int[] set;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		set=new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			set[i]=Integer.parseInt(st.nextToken());
		}
		size=Integer.toString(n).length();
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int depth, int num) {
		if(depth==size) {
			if(n>=num) {
				max=Math.max(max, num);
			}
			return;
		}
		for(int i=0;i<k;i++) {
			max=Math.max(max, num);
			dfs(depth+1,num*10+set[i]);
		}
	}
}
