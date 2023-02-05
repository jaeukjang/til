package BackTracking;

import java.io.*;
import java.util.*;

public class _22944_RainOfDeath {
	/*
	 * 죽음의  비
	 * 4<=N<=500 N*N격자
	 * 0<=K<10 우산갯수
	 * 1<=H<=10000 체력
	 * 1<=D<=5000 모든 우산의 체력
	 * 최소이동의 횟수출력 이동불가시 -1   입력은 N H D 그리고 격자
	 * S는 현재위치(시작점) U는 우산 E는 안전지대(도착점)
	 * 
	 * 1.S를 시작으로 사방탐색 시작? 내체력과 우산의 내구도는 따로 관리하기  
	 * 1-1. 일단 우산과 E 사이의 거리가 D+남은 체력 H 보다는 작아야하는데 그걸 미리 계산하는건 어려울것 같아...
	 * 1-2. 사방탐색을 하고 >> visited로 왔던길 안가게 관리하면서 죽어버릴때 가지치기하자.
	 * 2. 이동횟수가 min값보다  더 커질때도 가지치기 하자.  
	 * 
	 */
	static int n,k,d;
	static int min=Integer.MAX_VALUE;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};//상 하 좌  우
	
	static char[][] map;
	static boolean[][] visited;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		map=new char[n][n];
		visited=new boolean[n][n];
		int sr=0;int sc=0; int er=0; int ec=0;
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			map[i]=tmp.toCharArray();
			if(tmp.contains("S")) {
				sr=i;
				sc=tmp.indexOf("S");
			}
		}
		visited[sr][sc]=true;
		dfs(0,sr,sc,h,0);
		if(flag)
			System.out.println(min);
		else
			System.out.println(-1);
	}
	private static void dfs(int depth, int nr, int nc, int h, int uh) {
		if(map[nr][nc]=='E') {//도착시  min값 갱신하고 return;
			min=Math.min(min, depth);
			flag=true;
			return;
		}
		if(h<=0) {//죽어버리면 return;
			return;
		}
		if(depth>=min) {//더 길면 return;
			return;
		}
		for(int i=0;i<4;i++) {
			int tr=nr+dr[i];
			int tc=nc+dc[i];
			if(tr>=0&&tc>=0&&tr<n&&tc<n&&!visited[tr][tc]) {
				visited[tr][tc]=true;
				if(map[tr][tc]=='U') {
					uh=d;
				}
				if(uh>0) {
					dfs(depth+1, tr, tc, h, uh-1);
				}else {
					dfs(depth+1, tr, tc, h-1, uh);
				}
				visited[tr][tc]=false;
			}
		}
	}
}
