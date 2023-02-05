package GraphTraversal;

import java.io.*;
import java.util.*;

public class _14502_Lab {
	/*
	 * 연구소
	 * 1.벽을 세울 3개를 고른다음  이거는 n*mC3  n m 이 8보다 작으니 괜찮아보여
	 * 2.바이러스 퍼지게 하고 max값 찾아내기
	 * 
	 */
	
	static int[] map;
	static int[] map2;
	static int n,m,max;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n*m];
		map2=new int[n*m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i*m+j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);// 조합 3개를 고르기 위한 dfs
		System.out.println(max);
	}

	private static void dfs(int depth,int start) {
		// TODO Auto-generated method stub
		if(depth==3) {
			for(int i=0;i<n*m;i++) {//map2에 복사해놓기
				map2[i]=map[i];
			}
			bfs();// 바이러스를 퍼트리기 위한 bfs
			int cnt=0;
			for(int i=0;i<n*m;i++) {//map2에 복사해놓기
				if(map2[i]==0) cnt++;
			}
			max=Math.max(max,cnt);
			return;
		}
		for(int i=start;i<n*m;i++) {
			if(map[i]==0) {
				map[i]=1;
				dfs(depth+1,start+1);
				map[i]=0;
			}
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n*m;i++) {
			if(map2[i]==2) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/m;
			int c=cur%m;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(map2[nr*m+nc]==0) {
					q.offer(nr*m+nc);
					map2[nr*m+nc]=2;
				}
			}
		}
		
	}
}
