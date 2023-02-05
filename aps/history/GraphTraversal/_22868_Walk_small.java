package GraphTraversal;

import java.io.*;
import java.util.*;

public class _22868_Walk_small {
	/*
	 * 산책(small)
	 * 1. N 10000개 M 50000개
	 * 2. 인접리스트로 짜야한다.
	 * 3. S부터 시작해서 E로 가는 경로를 두가지 짜는 문제인거네. 중복한거 없이.
	 * 4. bfs로 E만나기 직전까지 계속 queue에 넣는거야 depth 관리하면서.
	 * ---잘못된 방법 폐기
	 * 
	 * 1.bfs를 두번 돌리는 방법으로 짜보자. 먼저 돌려서 간 경로를 false로 바꾸고.
	 * 2.사전순으로 먼저 채택하고 그다음 또 돌려야되는거야.
	 * 왔던 경로 를 체크하는게 어려운 부분이구나...
	 * 
	 */
	static class Node{
		int x;
		int dist;
		List<Integer> list;
		Node(int x,int dist){
			this.x= x;
			this.dist= dist;
			this.list=new ArrayList<>();
		}
	}
	static int n,m,s,e;
	static TreeSet<Integer>[] list;
	static boolean[] visited;
	static Node node1;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		list=new TreeSet[n+1];
		visited=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			list[i]=new TreeSet<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		st = new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		
		//연산시작
		int ans=0;
		bfs();
		ans+=min;
		visited=new boolean[n+1];
		for(Integer i:node1.list) {
			visited[i]=true;
		}
		bfs();
		ans+=min;
		System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Node> q=new ArrayDeque<>();
		q.offer(new Node(s,0));
		visited[s]=true;
		while(!q.isEmpty()) {
			Node node=q.poll();
			for(Integer i:list[node.x]) {
				if(!visited[i]){
					if(i==e) {//도착 지점일경우 비교하기만 하고 잘라버리기
						min=node.dist+1;
						node.list.add(node.x);
						node1=node;
						return;
					}else {
						Node tmp= new Node(i,node.dist+1);
						for(Integer j:node.list) {
							tmp.list.add(j);
						}
						tmp.list.add(node.x);
						q.offer(tmp);
						visited[i]=true;
					}
				}
			}
		}
	}
}
