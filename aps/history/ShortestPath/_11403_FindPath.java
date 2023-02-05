package ShortestPath;

import java.io.*;
import java.util.*;

public class _11403_FindPath {
	/*
	 * 경로 찾기
	 * 1. 인접행렬을 사용해서 갈 수 있으면 1 못가면 0 
	 * 2. 플로이드 워셜로 n^3 경유지 하나 설정해서 되면 1로 바꾸기
	 * 
	 */
	static int[][] adjArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		adjArr=new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				adjArr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//k를 경유지해서.갈 수 있으면 ans는 1
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(adjArr[i][k]==1&&adjArr[k][j]==1)
						adjArr[i][j]=1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(adjArr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
