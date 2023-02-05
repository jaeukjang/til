package GraphTraversal;

import java.io.*;
import java.util.*;

public class _4963_IslandCounting {
	/*
	 * 섬의 개수
	 * 1.8방향으로 탐색해서 이어지는 부분들 다 하나로 처리
	 */
	static int w,h;
	static int[][] arr;
	static int[] dr= {-1,-1,-1,0,0,1,1,1};
	static int[] dc= {-1,0,1,1,-1,-1,0,1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		do{
			st = new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			arr=new int[h][w];
			cnt=0;
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]==1)
						bfs(i,j);
				}
			}
			sb.append(cnt+"\n");
		}while(w!=0&&h!=0);
		System.out.println(sb);
		
	}
	private static void bfs(int r, int c) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(r);
		q.offer(c);
		arr[r][c]=0;
		while(!q.isEmpty()) {
			int cr=q.poll();
			int cc=q.poll();
			for(int i=0;i<8;i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				if(arr[nr][nc]==1) {
					q.add(nr);
					q.add(nc);
					arr[nr][nc]=0;
				}
			}
		}
		cnt++;
	}
}
