package BruteForce;

import java.io.*;
import java.util.*;

public class _9079_CoinGame {
	/*
	 * 동전뒤집기
	 * 1.3*3 H T 로 이루어짐 행 열 대각선 뒤집어서 같은면만  보이게 해야함.
	 * 1-1. 간단하게 생각해서 T는 0 H는 1  %2로 나누어  떨어지면 T 안되면  H
	 * 1-2. 그냥 계속 ^=해버리기 대각을 더하든~ 총 8개 케이스니까 그 past만 안하는걸로 하면 8*7*6*5.. ...이렇게 될듯?
	 * 1-3. 이방법은 불가능한 케이스를 어떻게 거르지?
	 * 1-4. 아 12번부터는 불가능한 케이스네. 의미없잖아 왔다갔다 하는건
	 * 2. 8개에 대한 경우의 수를 조합으로 만들고  모든 경우에 수 다하기
	 */
	static int[][] arr;
	static int min;
	static boolean flag;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			arr=new int[3][3];
			min=9;
			flag=false;
			visited=new boolean[8];
			//입력
			for(int j=0;j<3;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<3;k++) {
					if(st.nextToken().charAt(0)=='H') {
						arr[j][k]=1;
					}else {
						arr[j][k]=0;
					}
				}
			}
			
			bf(0);
			if(flag) {
				System.out.println(min);
			}else {
				System.out.println(-1);
			}
		}
	}
	private static void bf(int depth) {
		if(min<depth) {
			return;
		}
		if(check()) {
			flag=true;
			min=Math.min(min, depth);
		}
		for(int i=0;i<8;i++) {
			if(!visited[i]) {
				visited[i]=true;
				flip(i);
				bf(depth+1);
				visited[i]=false;
				flip(i);
			}
		}
	}
	private static void flip(int i) {
		if(i<3) {//행 뒤집기
			for(int j=0;j<3;j++) {
				arr[i][j]^=1;
			}
		}else if(i<6) {//열 뒤집기
			for(int j=0;j<3;j++) {
				arr[j][i-3]^=1;
			}
		}else if(i==6){// \대각 뒤집기
			for(int j=0;j<3;j++) {
				arr[j][j]^=1;
			}
		}else {// /대각 뒤집기
			for(int j=0;j<3;j++) {
				arr[j][2-j]^=1;
			}
		}
		
	}
	private static boolean check() {
		int start=arr[0][0];
		for(int i=1;i<9;i++) {
			if(arr[i/3][i%3]!=start)
				return false;
		}
		return true;
	}
}
