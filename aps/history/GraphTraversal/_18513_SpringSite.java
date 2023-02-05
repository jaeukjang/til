package GraphTraversal;

import java.io.*;
import java.util.*;

public class _18513_SpringSite {
	/*
	 * 샘터
	 * 1.HashMap을 이용하여 주변을 샘터 주변에 한 차수씩 높여서 건물을 세우자
	 * 2.key에는 좌표를 value에는 거리를
	 * 3.bfs사용해서 하나씩  늘려나가기. visited대신 contains를 이용
	 * 4.HashMap 에 value들  다 더해서 출력
	 */
	static Queue<Integer> q=new ArrayDeque<>();
	static Map<Integer,Integer> m=new HashMap<>();
	static int n,k;
	static long sum;
	static int[] dx= {-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int spring=Integer.parseInt(st.nextToken());
			q.add(spring);
			m.put(spring, 0);
		}
		bfs();
		for(Integer i: m.keySet()) {
			sum+=m.get(i);
		}
		System.out.println(sum);
	}
	private static void bfs() {
		int cnt=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int i=0;i<2;i++) {
				int nx=cur+dx[i];
				if(!m.containsKey(nx)) {
					q.add(nx);
					m.put(nx, m.get(cur)+1);	
					cnt++;
					if(cnt==k) return;
				}
			}
		}
	}
}
