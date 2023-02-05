package BackTracking;

import java.io.*;
import java.util.*;

public class _17136_AttatchPaper {
	/*
	 * 색종이 붙이기
	 * 1.위에서부터 차례대로 5 4 3 2 1 크기 색종이 붙이기 (5가지 경우 다 하기).
	 * 1-1. 이러면 최악의경우 5^(n^2).라서 가지치기 필수
	 * 1-2. 문제가 일부로 색종이를 5개씩줌 가지치기  하기 편하게
	 * 1-3. 색종이 5개 넘어가면 가지치고
	 * 1-4. min보다 커져버리면 가지쳐버리기
	 * 
	 */
	static int[][] arr=new int[10][10];
	static int[] cnts=new int[5];
	static int min=Integer.MAX_VALUE;
	static int n;
	static List<Integer> list=new ArrayList<>();
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					list.add(i*10+j);
				}
			}
		}
		n=list.size();
		dfs(0,0);
		if(flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
	}
	private static void dfs(int depth,int sum) {
		for(int i=0;i<5;i++) {
			if(cnts[i]>5) return;
		}
		if(sum>=min) return;
		if(depth==n) {
			min=Math.min(min,sum);
			flag=true;
			return;
		}
		int r=list.get(depth)/10;
		int c=list.get(depth)%10;
		if(arr[r][c]==1) {
			for(int i=5;i>=1;i--) {
				if(r+i<=10&&c+i<=10&&check(i,r,c)) {
					swap(i,r,c);
					cnts[i-1]++;
					dfs(depth+1,sum+1);
					swap(i,r,c);
					cnts[i-1]--;
				}
			}
		}else {
			dfs(depth+1,sum);
		}
		
	}
	private static void swap(int size, int r, int c) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				arr[r+i][c+j]^=1;
			}
		}
	}
	private static boolean check(int size, int r, int c) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(arr[r+i][c+j]==0) {
					return false;
				}
			}
		}
		return true;
	}
}
