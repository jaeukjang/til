package BruteForce;

import java.io.*;
import java.util.*;

public class _16937_TwoSticker {
	/*
	 * 두 스티커
	 * h w n 100이하  n개중 2개 골라서 붙일수 있을때 붙이는것
	 * 1.h <=w 인상태로만들기 스티커도  r<=c 인상태로 만들기
	 * 2. nC2 조합 만들기 
	 * 3.첫번째꺼  붙이기 돌리기로 2가지 > 옆에 붙이거나 아래붙이거나 2가지 > 돌려붙이기 2가지 총 8가지네..??
	 * 
	 * 
	 */
	static int h,w,n,r1,c1,r2,c2,max;
	static int[][] stickers;
	static boolean[] visited;
	static int[] arr=new int[2]; //조합으로 고른 스티커의 idx들어갈 곳
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(br.readLine());
		stickers=new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			stickers[i][0]=a;
			stickers[i][1]=b;
		}
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int depth,int start) {
		if(depth==2) {
			r1=stickers[arr[0]][0];
			c1=stickers[arr[0]][1];
			r2=stickers[arr[1]][0];
			c2=stickers[arr[1]][1];
			if(arr[0]==arr[1]) {
				return; //하나 밖에 없는거
			}
			if(check()) {
				max=Math.max(max, r1*c1+r2*c2);
			}
			return;
		}
		for(int i=start;i<n;i++) {
			arr[depth]=i;
			dfs(depth+1,start+1);
		}
	}
	private static boolean check() {
		if(h>=(r1+r2)&&w>=c1&&w>=c2) {//밑으로 붙이기
			return true;
		}else if(h>=(r1+c2)&&w>=c1&&w>=r2) {//밑으로 붙이기 2번째꺼 돌림
			return true;
		}else if(h>=(c1+r2)&&w>=r1&&w>=c2) {//밑 1
			return true;
		}else if(h>=(c1+c2)&&w>=r1&&w>=r2) {//밑 1,2
			return true;
		}else if(w>=(r1+r2)&&h>=c1&&h>=c2) {//옆 
			return true;
		}else if(w>=(r1+c2)&&h>=c1&&h>=r2) {//옆 2
			return true;
		}else if(w>=(c1+r2)&&h>=r1&&h>=c2) {//옆 1
			return true;
		}else if(w>=(c1+c2)&&h>=r1&&h>=r2) {//옆 1,2
			return true;
		}
		return false;
	}
}
