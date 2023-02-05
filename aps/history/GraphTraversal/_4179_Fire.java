package GraphTraversal;

import java.io.*;
import java.util.*;

public class _4179_Fire {
	/*
	 * 불!
	 * 1.불을 먼저 퍼트린 다른 맵(integer) 로 된 맵에 불이 퍼진 시간을 기록해두고
	 * 2.지훈이는 이동을 하는데 만약 내 이동 시간이 불 이동시간보다 작거나 같으면 okay 크면 x
	 * 3.bfs를 이용해서 퍼트리기~
	 */
	
	static char[][] map;
	static int[][] person;
	static int[][] fire;
	static boolean[][] pv;
	static boolean[][] fv;
	static int n,m;
	static int min=Integer.MAX_VALUE;
	static boolean flag;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new char[n][m];
		person=new int[n][m];
		fire=new int[n][m];
		pv=new boolean[n][m];
		fv=new boolean[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(fire[i], -1);
		}
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			map[i]=tmp.toCharArray();
		}
		int pr=-1;
		int pc=-1;
		
		bfsF();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='J') {
					bfsP(i,j);
				}
			}
		}
		
		
		if(flag) {
			System.out.println(min+1);
		}else {
			System.out.println("IMPOSSIBLE");
		}
		
	}
	private static void bfsP(int sr, int sc) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(sr);
		q.offer(sc);
		pv[sr][sc]=true;
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			if(r==0||c==0||r==n-1||c==m-1) {
				flag=true;
				min=Math.min(min, person[r][c]);
			}
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(map[nr][nc]=='.'&&!pv[nr][nc]&&check(nr,nc,person[r][c]+1)) {
					q.offer(nr);
					q.offer(nc);
					pv[nr][nc]=true;
					person[nr][nc]=person[r][c]+1;
				}
			}
		}
	}
	private static boolean check(int nr, int nc, int person) {
		if(fire[nr][nc]==-1) return true;
		if(fire[nr][nc]<=person) return false;
		else return true;
	}
	private static void bfsF() {
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='F') {
					q.offer(i);
					q.offer(j);
					fv[i][j]=true;
					fire[i][j]=0;
				}
			}
		}
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(map[nr][nc]!='#'&&!fv[nr][nc]) {
					q.offer(nr);
					q.offer(nc);
					fv[nr][nc]=true;
					fire[nr][nc]=fire[r][c]+1;
				}
			}
		}
		
	}
}
