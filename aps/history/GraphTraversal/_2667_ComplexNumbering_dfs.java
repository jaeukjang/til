package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2667_ComplexNumbering_dfs {
	/*
	 * 단지번호붙이기
	 * 1.사분면 탐색으로 연결이 되면~ false로 바꿔버리고 cnt+1
	 * 
	 */
	static int n;
	static boolean[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static List<Integer> list=new ArrayList<>();
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		map=new boolean[n][n];
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]= tmp.charAt(j)=='0'?false:true;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]) {
					cnt=0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		sb.append(list.size()+"\n");
		Collections.sort(list);
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int r, int c) {
		cnt++;
		map[r][c]=false;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nc<0||nr>=n||nc>=n) continue;
			if(map[nr][nc]) {
				dfs(nr,nc);
			}
		}
		
	}

}
