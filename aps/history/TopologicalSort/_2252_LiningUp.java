package TopologicalSort;

import java.io.*;
import java.util.*;

public class _2252_LiningUp {
	/*
	 * 줄 세우기
	 * 1. 위상정렬 이용해서 푸는문제네
	 * 
	 */
	static class Node{
		int no;
		Node next;
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Node[] adjList=new Node[n+1];
		int[] in=new int[n+1];
		int from,to;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			from=Integer.parseInt(st.nextToken());
			to=Integer.parseInt(st.nextToken());
			adjList[from]=new Node(to, adjList[from]);
			in[to]++;
		}
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			sb.append(cur+" ");
			for(Node tmp=adjList[cur];tmp!=null;tmp=tmp.next) {
				in[tmp.no]--;
				if(in[tmp.no]==0) {
					q.offer(tmp.no);
				}
			}
		}
		System.out.println(sb);
	}
}
