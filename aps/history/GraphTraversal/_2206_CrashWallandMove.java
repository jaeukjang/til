package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2206_CrashWallandMove {
	/*
	 * 벽 부수고 이동하기
	 * 1.이거 말이되고 싶은 원숭이랑 비슷하게 풀면 되지않아 ? 3차원 visitied 관리하면서
	 * 2.jmpCnt가 1인
	 * 
	 */
	static boolean[][][] visited;
	static int[][] arr;
	static int n,m;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int min=Integer.MAX_VALUE;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		visited=new boolean[n][m][2]; //높이는 crash or uncrash
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=tmp.charAt(j)-'0';
			}
		}
		bfs();
		if(flag) System.out.println(min);
		else System.out.println(-1);
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(0);// r
		q.offer(0);// c
		q.offer(1);// dist
		q.offer(1);// crash point
		visited[0][0][1]=true;
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			int dist=q.poll();
			int crash=q.poll();
			if(r==n-1&&c==m-1) {
				flag=true;
				min=Math.min(min, dist);
			}
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(arr[nr][nc]==1) {
					if(crash==1&&!visited[nr][nc][crash-1]) {
						q.offer(nr);
						q.offer(nc);
						q.offer(dist+1);
						q.offer(crash-1);
						visited[nr][nc][crash-1]=true;
					}
				}else {
					if(!visited[nr][nc][crash]) {
						q.offer(nr);
						q.offer(nc);
						q.offer(dist+1);
						q.offer(crash);
						visited[nr][nc][crash]=true;
					}
				}
			}
		}
	}
}
