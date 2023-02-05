package BackTracking;

import java.io.*;
import java.util.*;

public class _1799_Bishop{
	/*
	 * 비숍
	 * 1. n*n크기의  보드 라면 2n-1개에 대각선을 가진다. 양쪽으로 최대 n=10;
	 * 1-1. 놓을 수 있는 1인 경우의 한해서 놓고  안놓고로 만든다 총 경우의수는 2^(n^2)
	 * 1-2. 이미 대각에 있다면 가지치기를 할거니까 괜찮을듯? 
	 * 1-3. max는 2*n-2개
	 * 시간초과 왜나지..?
	 * 1-4. 흑 백 두개로  분리해서 max일 상황 따로 만들자.
	 * 
	 * 
	 */
	static int n;
	static boolean[] v1; // /대각선
	static boolean[] v2; // \대각선
	static List<Integer> list1 =new ArrayList<>();
	static List<Integer> list2 =new ArrayList<>();
	static boolean flag1;
	static boolean flag2;
	static int max1,max2,k1,k2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					if((i+j)%2==0) {
						list1.add(i*n+j);
					}else {
						list2.add(i*n+j);
					}
				}
			}
		}
		v1=new boolean[2*n-1];
		v2=new boolean[2*n-1];
		k1=list1.size();
		k2=list2.size();
		dfs1(0,0);
		dfs2(0,0);
		System.out.println(max1+max2);
	}
	private static void dfs1(int depth, int sum) {
		if(flag1) {
			return;
		}
		if(depth==k1) {
			max1=Math.max(max1, sum);
			if(sum==n-1) {
				flag1=true;
			}
			return;
		}
		
		int r=list1.get(depth)/n;
		int c=list1.get(depth)%n;
		if(!v1[r+c]&&!v2[c-r+n-1]) {
			v1[r+c]=v2[c-r+n-1]=true;
			dfs1(depth+1,sum+1);
			v1[r+c]=v2[c-r+n-1]=false;
			dfs1(depth+1,sum);
		}else {
			dfs1(depth+1,sum);
		}
	}
	private static void dfs2(int depth, int sum) {
		if(flag2) {
			return;
		}
		if(depth==k2) {
			max2=Math.max(max2, sum);
			if(sum==n-1) {
				flag2=true;
			}
			return;
		}
		
		int r=list2.get(depth)/n;
		int c=list2.get(depth)%n;
		if(!v1[r+c]&&!v2[c-r+n-1]) {
			v1[r+c]=v2[c-r+n-1]=true;
			dfs2(depth+1,sum+1);
			v1[r+c]=v2[c-r+n-1]=false;
			dfs2(depth+1,sum);
		}else {
			dfs2(depth+1,sum);
		}
	}
	
}