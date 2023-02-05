package BruteForce;

import java.io.*;
import java.util.*;

public class _5568_PutCard {
	/*
	 * 카드 놓기
	 * 1. 총 nPk 의 경우의 수이므로 매우 easy
	 * 2. 만들어진 수를 set에 넣어놓고 set size를 출력
	 */
	static Set<Integer> set=new HashSet<>();
	static int n,k;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		k=Integer.parseInt(br.readLine());
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		visited=new boolean[n];
		dfs(0,0);
		System.out.println(set.size());
	}
	private static void dfs(int depth, int num) {
		if(depth==k) {
			set.add(num);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				if(arr[i]>=10) {
					dfs(depth+1,num*100+arr[i]);
				}else {
					dfs(depth+1,num*10+arr[i]);
				}
				visited[i]=false;
			}
		}
	}
}
