package GraphTraversal;

import java.io.*;
import java.util.*;

public class _13549_HideAndSeek3 {
	/*
	 * 숨바꼭질3
	 * 1. -1 +1 *2 3분기로 나눠서 dfs돌릴게
	 * 2. k보다 많이 커지면 가지치기 min값보다 커지면 가지치기
	 */
	static int n,k;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		if(n>k) {
			min=n-k;
		}else if(n==k) {
			min=0;
		}else{
			
			dfs(n,0);
		}
		
		System.out.println(min);
	}

	private static void dfs(int tmp, int time) {
		if(time>min) {
			return;
		}
		if(tmp==k) {
			min=Math.min(min, time);
			return;
		}
		if(tmp>2*k ||tmp<=0) {
			return;
		}
		
		dfs(tmp-1,time+1);
		dfs(tmp+1,time+1);
		dfs(tmp*2,time);
	}
}
