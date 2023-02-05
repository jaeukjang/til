package GraphTraversal;

import java.io.*;
import java.util.*;

public class _16973_RectangularEscaping {
	/*
	 * 직사각형 탈출
	 * 1.왼쪽위만 움직이고 직사각형 크기만큼 check하자 이동가능한 곳인지
	 * 2.min값 관리하기. 근데 그냥 bfs로 하면 자동으로 min되잖아?
	 * 
	 */
	static int n,m,h,w,sr,sc,fr,fc;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean[][] visited;
	static int[][] arr;
	static int ans;
	static int[][] prefixsum;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());//직사각형 크기
		sr=Integer.parseInt(st.nextToken())-1;
		sc=Integer.parseInt(st.nextToken())-1;//start
		fr=Integer.parseInt(st.nextToken())-1;
		fc=Integer.parseInt(st.nextToken())-1;//end
		prefixsum=new int[n-h+1][m-w+1];
		for(int i=0;i<n-h+1;i++) {
			for(int j=0;j<m-w+1;j++) {
				prefixsum[i][j]=sum(i,j);
			}
		}
		bfs();
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}
	private static int sum(int r, int c) {
		int sum=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				sum+=arr[r+i][c+j];
			}
		}
		return sum;
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(sr);
		q.offer(sc);
		q.offer(0);
		visited[sr][sc]=true;
		while(!q.isEmpty()) {
			int cr=q.poll();
			int cc=q.poll();
			int depth=q.poll();
			if(cr==fr&&cc==fc) {//찾았다 요놈
				flag=true;
				ans=depth;
				return;
			}
			for(int i=0;i<4;i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				if(nr<0||nc<0||nr>n-h||nc>m-w) continue;
				if(!visited[nr][nc]&&prefixsum[nr][nc]==0) {
					q.offer(nr);
					q.offer(nc);
					q.offer(depth+1);
					visited[nr][nc]=true;
				}
			}
		}
	}
	
//	private static boolean check(int nr, int nc) {
//		for(int i=0;i<h;i++) {
//			for(int j=0;j<w;j++) {
//				if(nr+i>=n||nc+j>=m||arr[nr+i][nc+j]==1) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
}
