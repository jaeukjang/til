package BackTracking;

import java.io.*;
import java.util.*;

public class _14712_SquareSquare {
	static int n,m,cnt;
	static boolean[][] check;
	static int[] dr= {-1,-1,0,0};
	static int[] dc= {0,-1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		check=new boolean[n][m];
		
		dfs(0);
		System.out.println(cnt);
	}
	private static void dfs(int idx) {
		if(idx!=0&&nemo(idx-1)) {
			return;
		}
		if(idx==n*m) {
			cnt++;
			return;
		}
		check[idx/m][idx%m]=true;
		dfs(idx+1);
		check[idx/m][idx%m]=false;
		dfs(idx+1);
		
	}
	private static boolean nemo(int idx) {
		int nr= idx/m; int nc=idx%m;
		for(int i=0;i<4;i++) {
			if((nr+dr[i]<0)||(nc+dc[i]<0)) {
				return false;
			}else {
				if(!check[nr+dr[i]][nc+dc[i]])
					return false;
			}
		}
		return true;
	}
}
