package GraphTraversal;

import java.io.*;
import java.util.*;

public class _17836_SavePrincess {
	/*
	 * 공주님을 구해라
	 * 1.검 까지 가기(갈 수 있으면) or 바로가기 둘중 비교 해서 min값 
	 */
	static int[] map;
	static int[] map2;
	static boolean[] visited;
	static int n,m,t;
	static int min=Integer.MAX_VALUE;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		map=new int[n*m];
		map2=new int[n*m];
		visited=new boolean[n*m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i*m+j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(flag&&min<=t) {
			System.out.println(min);
		}else {
			System.out.println("Fail");
		}
	}
	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		
		q.offer(0);
		visited[0]=true;
		map2[0]=0;
		map2[n*m-1]=Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/m;
			int c=cur%m;
			if(cur==n*m-1) {
				flag=true;
				break;
			}
			if(map[cur]==2) {
				flag=true;
				min=Math.min(min, map2[cur]+n-1-r+m-1-c);
			}
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				int tmp=nr*m+nc;
				if(!visited[tmp]&&map[tmp]!=1) {
					q.offer(tmp);
					visited[tmp]=true;
					map2[tmp]=map2[cur]+1;
				}
			}
		}
		min=Math.min(min, map2[n*m-1]);
	}
}
