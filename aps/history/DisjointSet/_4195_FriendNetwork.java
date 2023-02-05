package DisjointSet;

import java.io.*;
import java.util.*;

public class _4195_FriendNetwork {
	/*
	 * 친구 네트워크
	 * 1.로봇 조립이랑 똑같은데 
	 * 2.int배열로 관리하던거를  map으로 관리하기~
	 * 자료구조만 좀 더 복잡할뿐..
	 */
	static Map<String,Integer> map=new HashMap<>();
	static int[] root;
	static int[] setSize;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc=Integer.parseInt(br.readLine());
		int n;
		String a,b;
		for(int t=0;t<tc;t++) {
			int cnt=1;
			n=Integer.parseInt(br.readLine());
			root=new int[2*n+1];
			for(int i=1;i<=2*n;i++) {
				root[i]=i;
			}
			setSize=new int[2*n+1];
			Arrays.fill(setSize, 1);
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				a=st.nextToken();
				b=st.nextToken();
				if(!map.containsKey(a)) {
					map.put(a, cnt++);
				}
				if(!map.containsKey(b)) {
					map.put(b, cnt++);
				}
				union(map.get(a),map.get(b));
				sb.append(setSize[find(map.get(a))]+"\n");
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
