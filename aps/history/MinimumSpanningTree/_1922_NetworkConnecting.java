package MinimumSpanningTree;

import java.io.*;
import java.util.*;


public class _1922_NetworkConnecting {
	/*
	 * 네트워크 연결
	 * using Kruskal & Arrays.sort
	 * 1. 간선 배열 만들고 가중치로 오름차순 정렬하기
	 * 2. 하나의 집합에 우겨넣을 수 있으면 간선 채택하고 V-1개 간선 고르기
	 * 	2-1. 집합의 union find 메서드를 활용하면서 하나의 집합으로 만들기.
	 * 
	 */
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V,E;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		make();
		edgeList=new Edge[E];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i]=new Edge(Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edgeList); //간선 배열 가중치 오름차순
		long result=0;
		int cnt=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++cnt==V-1) break;
			}
		}
		System.out.println(result);
	}

	private static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return  false;
		
		parents[bRoot]=aRoot; //b 집합을 a집합에 포함시켜버려
		return true;
	}

	private static int find(int a) {//a의 대표자 찾기
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]); //우리의 대표자를 나의 부모로 만듬 plus Path Compression까지 해줘.
	}

	private static void make() { //우선 크기가 1인 서로소 집합 생성
		parents=new int[V];
		for (int i=0;i<V;i++) {//모든 노드가 자신을 우선 부모로하는 (대표자) 집합으로 만듬
			parents[i]=i;
		}
		
	}
}
