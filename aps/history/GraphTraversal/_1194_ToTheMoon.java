package GraphTraversal;

import java.io.*;
import java.util.*;

public class _1194_ToTheMoon {
	/*
	 * 달이 차오른다 가자
	 * 1.key 줏으면 visited[] 오픈
	 * 2.
	 */
	static int n,m,ans;
	static char[][] map;
	static boolean[][][] visited;
	static boolean flag;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new char[n][m];
		visited=new boolean[n][m][1<<6];
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			map[i]=tmp.toCharArray();
		}
		
		bfs();
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}

	private static void bfs() {
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='0') {
					q.offer(i);
					q.offer(j);
					q.offer(0);
					q.offer(0);
					visited[i][j][0]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			int dist=q.poll();
			int key=q.poll();
//			System.out.println("r : "+r+" c: "+c+" dist : "+dist+" key : "+key);
			if(map[r][c]=='1') {
				ans=dist;
				flag=true;
				return;
			}
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(map[nr][nc]=='#') continue;
				for(int j=0;j<6;j++) {
					if(map[nr][nc]=='a'+j) {
						if(!visited[nr][nc][key|1<<j]) {
							q.offer(nr);
							q.offer(nc);
							q.offer(dist+1);
							q.offer(key|1<<j);
							visited[nr][nc][key|1<<j]=true;
						}
					}
					if(map[nr][nc]=='A'+j&&!visited[nr][nc][key]&&((1<<j)&key)>0) {
						q.offer(nr);
						q.offer(nc);
						q.offer(dist+1);
						q.offer(key);
						visited[nr][nc][key]=true;
					}
				}
				if((map[nr][nc]=='.'||map[nr][nc]=='0'||map[nr][nc]=='1')&&!visited[nr][nc][key]) {
					q.offer(nr);
					q.offer(nc);
					q.offer(dist+1);
					q.offer(key);
					visited[nr][nc][key]=true;
				}
				
			}
		}
		
	}
}
