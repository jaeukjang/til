package MinimumSpanningTree;

import java.io.*;
import java.util.*;


public class _21924_CityConstruction {
	/*
	 * 도시 건설
	 * 1. 기존 MST문제에서 추가된건 모든 건물이 연결되지 않을 수 있다는 조건이 있음.
	 * 2. 그리고 기존 모든 도로의 비용에서 최솟값을 뺀거를 출력해야돼. 절약한 비용을 출력하고 싶은거니까
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
	static boolean flag;
	static long sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		make();
		edgeList=new Edge[E];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i]=new Edge(Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
			sum+=edgeList[i].weight;
		}
		Arrays.sort(edgeList); //간선 배열 가중치 오름차순
		long result=0;
		int cnt=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++cnt==V-1) {
					flag=true;
					break;
				}
			}
		}
		if(flag) System.out.println(sum-result);
		else System.out.println(-1);
		
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
