package DisjointSet;

import java.io.*;
import java.util.StringTokenizer;

public class _1976_LetsGoTrip {
	/*
	 * 여행 가자
	 * 1. 길이 있으면 union 해버리기.
	 * 2. 도시가 연결이 안되어있다면 false
	 */
	static int[] root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		root=new int[n+1];
		for(int i=0;i<=n;i++) {
			root[i]=i;
		}
		boolean[][] arr=new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				if(Integer.parseInt(st.nextToken())==1)
					union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int before,now;
		boolean flag=true;
		before=Integer.parseInt(st.nextToken());
		for(int i=1;i<m;i++) {
			now=Integer.parseInt(st.nextToken());
			if(find(before)!=find(now)) {
				flag=false;
			}
			before=now;
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
		
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
