package GraphTraversal;

import java.io.*;
import java.util.*;

public class _16932_MakingShape {
	/*
	 * 모양 만들기
	 * 
	 * 1.0 을 1로 바꾸는 경우의수 최대 100만개. 아무거나 바꾸지 말자(근접해있는 1이 있을때만 바꾸기)
	 * 2.바꾼후 bfs를 통해서 최대 크기 찾기.
	 * --- 시간초과 폐기
	 * 
	 * 1.우선 그룹핑을 다하고 0을 찾고 그 0 주변 그룹중에 다른 그룹꺼만 더하기.+ 나자신 +1
	 * 2.그룹핑한 것을 어떻게 저장해둘까... q를 두개 관리하면서 마지막에 q2에 있는거 다빼서 cnt만큼 값으로 다 바꿔주기 그룹번호도 따로 저장해두기.
	 * 
	 */
	
	static int n,m,max,groupNumber;
	static int[][] arr;
	static int[][] groupNumbers;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static Set<Integer> set =new HashSet<>();//groupNumber 담을 set
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[n][m];
		groupNumbers=new int[n][m];
		//먼저 1인것들 다 그룹핑 해줘~
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					groupNumber++;
					bfs(i,j);
				}
			}
		}
		//0을 1로 바꿔주기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					set.clear();
					check(i,j);
				}
			}
		}
//		System.out.println("GNO");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(groupNumbers[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("ARR");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(max);
		
	}


	private static void check(int r, int c) {
		int sum=0;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nc<0||nr>=n||nc>=m) continue;
			int gno=groupNumbers[nr][nc];
			int tmp=arr[nr][nc];
			if(!set.contains(gno)) {
				set.add(gno);
				sum+=tmp;
			}
		}
		max=Math.max(max, sum+1);
	}


	private static void bfs(int sr, int sc) {
		int cnt=0;
		Queue<Integer> q=new ArrayDeque<>();
		Queue<Integer> q2=new ArrayDeque<>();
		q.offer(sr);
		q.offer(sc);
		q2.offer(sr);
		q2.offer(sc);
		visited[sr][sc]=true;
		while(!q.isEmpty()) {
			int r=q.poll();
			int c=q.poll();
			cnt++;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(arr[nr][nc]==1&&!visited[nr][nc]) {
					q.offer(nr);
					q.offer(nc);
					q2.offer(nr);
					q2.offer(nc);
					visited[nr][nc]=true;
				}
			}
		}
		while(!q2.isEmpty()) {
			int r=q2.poll();
			int c=q2.poll();
			groupNumbers[r][c]=groupNumber;
			arr[r][c]=cnt;
		}
	}

	
}
