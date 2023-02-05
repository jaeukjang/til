package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _9663_NQueen {
	static int ans;
	static int n;
	static boolean[][] board;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		board= new boolean[n][n];
		nq(0);
		System.out.print(ans);
	}
	private static void nq(int cnt) {
		if(cnt==n) {
			ans++;
			return;
		}
		for(int i=0;i<n;i++) {
			board[cnt][i]=true;
			if(check(cnt,i)) {
				nq(cnt+1);
			}
			board[cnt][i]=false;
		}
	}
	private static boolean check(int row,int col) {
		// TODO Auto-generated method stub
		// 위 체크
		for(int i=0;i<row;i++) {
			if(board[i][col]) return false;
		}
		
		// \체크
		int tmp=col;
		for(int i=row-1;i>=0;i--) {
			tmp--;
			if(tmp>=0&&board[i][tmp]) return false;
		}
		// /체크
		tmp=col;
		for(int i=row-1;i>=0;i--) {
			tmp++;
			if(tmp<n&&board[i][tmp]) return false;
		}
		return true;
	}
}
