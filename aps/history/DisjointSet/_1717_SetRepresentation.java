package DisjointSet;

import java.io.*;
import java.util.StringTokenizer;

public class _1717_SetRepresentation {
	/*
	 * 집합의 표현
	 * 1. 와 disjointset 기억이 안나네..
	 */
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		root=new int[n+1];
		for(int i=0;i<=n;i++) { //make
			root[i]=i;
		}
		int a,b,c;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(a==0) {
				union(b,c);
			}else {
				if(find(b)==find(c)) {
					sb.append("YES"+"\n");
				}else {
					sb.append("NO"+"\n");
				}
			}
		}
		System.out.println(sb);
	}
	static int find(int a) {
		if(a==root[a]) {
			return a;
		}
		return root[a]=find(root[a]);
	}
	static boolean union(int a,int b) {
		int ar=find(a);
		int br=find(b);
		if(ar==br) return false;
		
		root[br]=ar;
		return true;
	}
}
