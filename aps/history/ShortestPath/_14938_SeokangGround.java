package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14938_SeokangGround {
	/*
	 * 서강그라운드
	 * 1.정점이 최대 100개밖에 안되니까 인접행렬로 관리하자
	 * 2.플로이드 워셜로 경유지 거쳐서 가자. 
	 * 
	 */
	static int max=Integer.MAX_VALUE;
	static int[] items;
	static int[][] arr;
	static int n,m,r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());//정점갯수
		m=Integer.parseInt(st.nextToken());//수색범위
		r=Integer.parseInt(st.nextToken());//간선갯수
		
		items=new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			items[i]=Integer.parseInt(st.nextToken());
		}
		
		arr=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(arr[i], max);
		}
		
		int from,to,weight;
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			from=Integer.parseInt(st.nextToken())-1;
			to=Integer.parseInt(st.nextToken())-1;
			weight=Integer.parseInt(st.nextToken());
			arr[from][to]=weight;
			arr[to][from]=weight;
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][k]!=max&&arr[k][j]!=max&&arr[i][j]>(arr[i][k]+arr[k][j])) {
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		int ans=0;
		int sum;
		for(int i=0;i<n;i++) {
			sum=items[i];
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				if(arr[i][j]<=m) {
					sum+=items[j];
				}
			}
			ans=Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}
