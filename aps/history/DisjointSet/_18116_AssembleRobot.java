package DisjointSet;

import java.io.*;
import java.util.*;

public class _18116_AssembleRobot {
	/*
	 * 로봇 조립
	 * 1.기존 disjointset문제와 똑같은데 다른점은 이 집합의 크기를 출력해야돼 그러면 집합 크기를 담는 배열을 만들자.
	 */
	static int[] root=new int[1000001];
	static int[] setSize=new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n=Integer.parseInt(br.readLine());
		for(int i=1;i<=1000000;i++) {
			root[i]=i;
		}
		Arrays.fill(setSize, 1);
		char order;
		int a,b;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			order=st.nextToken().charAt(0);
			a=Integer.parseInt(st.nextToken());
			if(order=='I') {
				b=Integer.parseInt(st.nextToken());
				union(a,b);
			}else {
				sb.append(setSize[find(a)]+"\n");
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
		
		setSize[ar]+=setSize[br];
		root[br]=ar;
		return true;
	}
}
