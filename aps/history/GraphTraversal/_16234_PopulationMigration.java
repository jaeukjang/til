package GraphTraversal;

import java.io.*;
import java.util.*;

public class _16234_PopulationMigration {
	/*
	 * 인구 이동 (어려운데?)
	 * 1. bfs로 L R 조건에 해당하는 경우에만 열기.
	 * 2. 해당하는 경우에 이동시키고
	 * 3. 다시하기
	 */
	
	static int n,L,R;
	static int[] arr;
	static int day;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[n*n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i*n+j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(day);
		
	}

	private static void bfs() {
		boolean visited[]=new boolean[n*n];
		boolean flag=false;
		for(int i=0;i<n*n;i++) {
			if(!visited[i]&&check(i)) {
				flag=true;
				bfs2(i,visited);
			}
		}
		if(flag) {
			day++;
			bfs();
		}
		
	}

	private static void bfs2(int start, boolean[] visited) {
		Queue<Integer> q=new ArrayDeque<>();
		Queue<Integer> q2=new ArrayDeque<>();
		q.offer(start);
		visited[start]=true;
		int sum=0;
		int cnt=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			q2.offer(cur);
			sum+=arr[cur];
			cnt++;
			int r=cur/n;
			int c=cur%n;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				int tmp=nr*n+nc;
				if(nr<0||nc<0||nr>=n||nc>=n||visited[tmp]) continue;
				int diff=Math.abs(arr[cur]-arr[tmp]);
				if(diff>=L &&diff<=R) {
					q.offer(tmp);
					visited[tmp]=true;
				}
			}
		}
		while(!q2.isEmpty()) { //연합 국가들 인구 바꾸기
			arr[q2.poll()]=sum/cnt;
		}
	}


	private static boolean check(int cur) { //국경을 열어야 하는지 check
		int r=cur/n;
		int c=cur%n;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nc<0||nr>=n||nc>=n) continue;
			int diff=Math.abs(arr[cur]-arr[nr*n+nc]);
			if(diff>=L &&diff<=R) {
				return true;
			}
		}
		return false;
	}
}
