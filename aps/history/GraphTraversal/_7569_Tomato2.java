package GraphTraversal;

import java.io.*;
import java.util.*;

public class _7569_Tomato2 {
	/*
	 * 토마토
	 * 1. 익은 토마토를 큐에 담고  visited에 넣고 그 주변을 탐색.
	 * 2. 그전에 익은 day에서 +1하기.
	 * 3. 높이 탐색을 추가
	 */
	static int[] status; 
	static boolean[] visited;
	static int m,n,H;
	static int[] dr= {-1,1,0,0,0,0};
	static int[] dc= {0,0,-1,1,0,0};
	static int[] dh= {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		status=new int[n*m*H];
		visited=new boolean[n*m*H];
		for(int k=0;k<H;k++) {
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					status[k*n*m+i*m+j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		boolean flag=true;
		int max=0;
		for(int i=0;i<n*m*H;i++) {
			if(status[i]==0) {
				flag=false;
				break;
			}else {
				max=Math.max(max, status[i]);
			}
		}
		if(flag) {
			System.out.println(max-1);
		}else {
			System.out.println(-1);
		}
		
//		for(int i=0;i<H;i++) {
//			for(int j=0;j<n;j++) {
//				for(int k=0;k<m;k++) {
//					System.out.print(status[i*n*m+j*m+k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("----");
//		}
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n*m*H;i++) {
			if(status[i]==1) {
				q.offer(i);
				visited[i]=true;
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();
			int h=cur/(n*m);
			int r=(cur-n*m*h)/m;
			int c=(cur-n*m*h)%m;
			for(int i=0;i<6;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				int nh=h+dh[i];
				if(nr<0||nc<0||nr>=n||nc>=m||nh<0||nh>=H) continue;
				int next=nh*(n*m)+nr*m+nc;
				if(status[next]==0) {
					q.offer(next);
					visited[next]=true;
					status[next]=status[cur]+1;
				}
			}
		}
		
	}
}
