package BruteForce;

import java.io.*;
import java.util.*;

public class _16439_ChickenChickenChicken{
	/*
	 * 치킨치킨치킨
	 * 1.종류별 선호도 다 더해서 넣어놓고 mC3 한 후 합 젤큰거고르기
	 * 2.super easy
	 * ... 아 한 사람의 만족도는 시킨 치킨 중에서 선호도가 가장 큰 값으로 결정됩니다. 조건을 또 놓쳤네
	 */
	static int[] like;
	static int max,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		like=new int[m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				like[j]+=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		System.out.println(max);
	}
	private static void dfs(int depth, int start,int sum) {
		if(depth==3) {
			max=Math.max(max, sum);
			return;
		}
		for(int i=start;i<m;i++) {
			dfs(depth+1,i+1,sum+like[i]);
		}
	}
}