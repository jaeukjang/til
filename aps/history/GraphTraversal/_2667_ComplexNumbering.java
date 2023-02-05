package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2667_ComplexNumbering {
	/*
	 * 단지번호붙이기
	 * 1.사분면 탐색으로 연결이 되면~ false로 바꿔버리고 cnt+1
	 * 
	 */
	static int n;
	static boolean[] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		map=new boolean[n*n];
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<n;j++) {
				map[i*n+j]= tmp.charAt(j)=='0'?false:true;
			}
		}
		
		for(int i=0;i<n*n;i++) {
			if(map[i]) {
				bfs(i);
			}
		}
		
		sb.append(list.size()+"\n");
		Collections.sort(list);
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int idx) {
		Queue<Integer> q=new ArrayDeque<>();
		
		q.offer(idx);
		map[idx]=false;
		int cnt=1;
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/n;
			int c=cur%n;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=n||nc>=n) continue;
				
				if(map[nr*n+nc]) {
					q.offer(nr*n+nc);
					map[nr*n+nc]=false;
					cnt++;
				}
			}
		}
		list.add(cnt);
		
	}
}
