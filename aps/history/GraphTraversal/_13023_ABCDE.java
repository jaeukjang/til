package GraphTraversal;

import java.io.*;
import java.util.*;

public class _13023_ABCDE {
	/*
	 * ABCDE
	 * 1. 친구수 최대 2000명 관계수 최대 2000개이므로 인접리스트를 사용하자.
	 * 2. 2000C4 인데 백트래킹으로 좀 잘라내야 할 듯.
	 */
	static int n,m;
	static int flag=0;
	static List<Integer>[] list;
	static TreeSet<Integer> set=new TreeSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());//친구 수
		m=Integer.parseInt(st.nextToken());//친구 관계수
		list=new ArrayList[n];
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<n;i++) {
			set.add(i);
			dfs(0,i);
			set.remove(i);
		}
		System.out.println(flag);
	}
	private static void dfs(int depth,int before) {
		
		if(set.size()<depth-1) {
			return;
		}
		if(flag==1) {
			return;
		}
		if(depth==4) {
			if(set.size()==5) {
				flag=1;
			}
			return;
		}
		for(Integer i: list[before] ) {
			if(!set.contains(i)) {
				set.add(i);
				dfs(depth+1,i);
				set.remove(i);
			}
		}
		
		
	}
}
