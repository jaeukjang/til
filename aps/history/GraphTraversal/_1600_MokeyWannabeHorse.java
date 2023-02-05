package GraphTraversal;

import java.io.*;
import java.util.*;

public class _1600_MokeyWannabeHorse {
	/*
	 * 말이 되고픈 원숭이 HARD
	 * 1. 나이트처럼 움직일수 있는 기회는 k번.. 0<=k<=30
	 * 2. 4방탐색+8방탐색 (기회가 주어짐)
	 * 3. visited로 관리하면서? dfs로 관리해야할 것 같은데?...
	 * --- 안되네
	 */
	
	static int k,w,h;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int[] jdr= {2,2,1,1,-1,-1,-2,-2};
	static int[] jdc= {-1,1,-2,2,-2,2,-1,1}; // 사방탐색 + 나이트 8개
	static int min=Integer.MAX_VALUE;
	static boolean[][][] visited;
	static int[][] map;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		map=new int[h][w];
		visited=new boolean[h][w][k+1];
		
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(0);//depth
		q.offer(0);//r
		q.offer(0);//c
		q.offer(k);//kCnt
		visited[0][0][k]=true;
		while(!q.isEmpty()) {
			int depth=q.poll();
			int r=q.poll();
			int c=q.poll();
			int kCnt=q.poll();
//			System.out.printf("depth : %d     r : %d c : %d    k : %d\n",depth,r,c,kCnt);
			if(r==h-1&&c==w-1) {
				min=Math.min(min, depth);
				flag=true;
			}
			if(kCnt>0) {//점프
				for(int i=0;i<8;i++) {
					int nr=r+jdr[i];
					int nc=c+jdc[i];
					if(nr<0||nc<0||nr>=h||nc>=w) continue;
					if(!visited[nr][nc][kCnt-1]&&map[nr][nc]==0) {
						visited[nr][nc][kCnt-1]=true;
						q.offer(depth+1);
						q.offer(nr);
						q.offer(nc);
						q.offer(kCnt-1);
					}
				}
			}
			//사방탐색
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				if(!visited[nr][nc][kCnt]&&map[nr][nc]==0) {
					visited[nr][nc][kCnt]=true;
					q.offer(depth+1);
					q.offer(nr);
					q.offer(nc);
					q.offer(kCnt);
				}
			}
		}
		
	}
	
}
