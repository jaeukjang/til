package BackTracking;

import java.io.*;
import java.util.*;

public class _10971_TSP2 {
	//Traveling Salesman Problem
	
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			travel(0,0,i,i);
		}
		System.out.println(min);
	}
	private static void travel(int depth, int sum,int before,int starting) {
		if(depth==n) {//끝까지 왔을때 기저조건
			if(min>sum) {
				min=sum;
			}
			return;
		}
		if(min<sum) {//가지치기
			return;
		}
		//!(depth n-1 false &&T)>> T (마지막) i== starting 계산해서 넣어  !(T&&T) >>F  
		for(int i=0;i<n;i++) {
			if(!visited[i]&&arr[before][i]>0&& !(depth<n-1&&i==starting)) {
				visited[i]=true;
				travel(depth+1, sum+arr[before][i],i,starting);
				visited[i]=false;
			}
		}
	}
}
