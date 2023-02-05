package GraphTraversal;

import java.io.*;
import java.util.*;

public class _16954_MovingMaze {
	/*
	 * 움직이는 미로
	 * 1. 지금 그리고 1초후에 있을 벽을 고려하면서 내가 9개중에 살아남을 수 있는지. 총 8번만 살아나면 okay
	 */
	static char[][] arr;
	static int[] dr= {-1,-1,-1,0,0,0,1,1,1};
	static int[] dc= {-1,0,1,-1,0,1,-1,0,1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		arr=new char[8][8];
		for(int i=0;i<8;i++) {
			String tmp=br.readLine();
			arr[i]=tmp.toCharArray();
		}
		dfs(0,7,0);
		System.out.println(flag?1:0);
	}
	private static void dfs(int depth, int r, int c) {
		if(depth==8) {
			flag=true;
			return;
		}
		for(int i=0;i<9;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nc<0||nr>=8||nc>=8) continue;
			if(check(nr,nc,depth)) {
				dfs(depth+1,nr,nc);
			}
		}
		
	}
	private static boolean check(int nr, int nc, int depth) {
		if(nr-depth>=0&&arr[nr-depth][nc]=='#') return false;
		if(nr-depth-1>=0&&arr[nr-depth-1][nc]=='#') return false;
		else return true;
	}
}
