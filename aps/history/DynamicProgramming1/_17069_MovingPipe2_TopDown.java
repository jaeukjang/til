package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _17069_MovingPipe2_TopDown {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		memo=new long[n][n][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		long result;
		result=move(0,1,0);
		System.out.println(result);
	}
	static long[][][] memo;
	
	static long move(int r,int c,int pos) {
		if(r==n-1&&c==n-1) {
			return 1;
		}
		long result=0;
		if(memo[r][c][pos]!=0) {
			return memo[r][c][pos];
		}
		if(pos!=1&&c+1<n&&arr[r][c+1]==0) {
			result+=move(r,c+1,0);
		}
		if(pos!=0&&r+1<n&&arr[r+1][c]==0) {
			result+=move(r+1,c,1);
		}
		if(r+1<n&&c+1<n&&arr[r+1][c]==0&&arr[r][c+1]==0&&arr[r+1][c+1]==0) {
			result+=move(r+1,c+1,2);
		}
		memo[r][c][pos]=result;
		return result;
	}
}

