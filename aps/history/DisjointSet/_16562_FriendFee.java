package DisjointSet;

import java.io.*;
import java.util.*;

public class _16562_FriendFee {
	/*
	 * 친구비
	 * 문제가 슬프다...
	 * 1. union해버리기 / 전부다 find 한 후에 root들을 set에 넣어.
	 * 2. set에서 빼고 가장 값싼애 찾기
	 */
	static int[] root;
	static class Friend implements Comparable<Friend>{
		int no,fee;

		public Friend(int no, int fee) {
			this.no = no;
			this.fee = fee;
		}

		@Override
		public int compareTo(Friend o) {
			return this.fee-o.fee;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		root=new int[n+1];
		for(int i=1;i<=n;i++) {
			root[i]=i;
		}
		st = new StringTokenizer(br.readLine());
		Queue<Friend> pq=new PriorityQueue<>();
		Set<Integer> set=new HashSet<>();
		for(int i=1;i<=n;i++) {
			pq.offer(new Friend(i,Integer.parseInt(st.nextToken())));
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i=1;i<=n;i++) {
			find(i);
			set.add(root[i]);
		}
		int sum=0;
		int cnt=set.size();
		while(!pq.isEmpty()) {
			Friend cur=pq.poll();
			if(set.contains(root[cur.no])){
				sum+=cur.fee;
				set.remove(root[cur.no]);
			}
		}
		if(sum>k) {
			System.out.println("Oh no");
		}else {
			System.out.println(sum);
		}
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
