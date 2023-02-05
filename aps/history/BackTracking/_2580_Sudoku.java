package BackTracking;

import java.io.*;
import java.util.*;

public class _2580_Sudoku {
	/*
	 * 스도쿠
	 * 1. 시간제한 1초고 총 9*9 81개 칸을 채우기...
	 * 1-1. 총 갯수를 0인 값의 index를  채워두고 그걸로 visited 아니 할필요없이 순서대로 하면되지.
	 * 1-2. 총 9^0의 갯수..? 이러면 너무많은데 그러면 줄여서
	 * 1-3. rowcheck colcheck boxcheck 해서 안되는경우의수 바로 가지치기
	 * 2.마지막에 출력
	 * 
	 */
	static StringBuilder sb = new StringBuilder();
	static int[][] arr=new int[9][9];
	static List<Integer> list=new ArrayList<>();
	static int n;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) list.add(i*9+j);// idx 저장해두기.
			}
		}
		n=list.size();
		dfs(0);
		System.out.println(sb);
	}
	private static void dfs(int depth) {
		if(flag) {//하나  찾았으면 재귀 멈추게하고싶어
			return;
		}
		if(depth==n) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
			flag=true;
			return;
		}
		int r=list.get(depth)/9;
		int c=list.get(depth)%9;
		for(int i=1;i<=9;i++) {
			if(colcheck(c,i)&&rowcheck(r,i)&&boxcheck(r,c,i)) {
				arr[r][c]=i;
				dfs(depth+1);
				arr[r][c]=0;
			}
		}
		
	}
	private static boolean boxcheck(int r, int c, int i) {
		
		int br=r/3;
		int bc=c/3;
		
		for(int j=0;j<9;j++) {
			if(arr[br*3+j/3][bc*3+j%3]==i) {
				return false;
			}
		}
		return true;
	}
	private static boolean rowcheck(int r, int i) {
		for(int j=0;j<9;j++) {
			if(arr[r][j]==i) {
				return false;
			}
		}
		return true;
	}
	private static boolean colcheck(int c, int i) {
		for(int j=0;j<9;j++) {
			if(arr[j][c]==i) {
				return false;
			}
		}
		return true;
	}
}