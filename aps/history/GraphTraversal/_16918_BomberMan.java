package GraphTraversal;

import java.io.*;
import java.util.*;

public class _16918_BomberMan {
	/*
	 * 봄버맨
	 * 1.총 경우의수는 3가지 N을 4으로 나눴을때 나머지의 경우의수로 나뉜다.
	 */
	static int R,C,N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		char[][] input=new char[R][C];
		char[][] input2=new char[R][C];
		for(int i=0;i<R;i++) {
			String tmp=br.readLine();
			input[i]=tmp.toCharArray();
		}
		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		}else if(N==1) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append(input[i][j]);
				}
				sb.append("\n");
			}
		}else if(N%4==3) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append(check(input,i,j));
				}
				sb.append("\n");
			}
		}else {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					input2[i][j]=check(input,i,j);
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append(check(input2,i,j));
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static char check(char[][] arr,int r, int c) {
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		if(arr[r][c]=='O') {
			return '.';
		}else {
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=R||nc>=C) continue;
				if(arr[nr][nc]=='O') {
					return '.';
				}
			}
		}
		
		return 'O';
	}
}
