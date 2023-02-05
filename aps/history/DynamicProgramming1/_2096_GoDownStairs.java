package DynamicProgramming1;

import java.io.*;
import java.util.*;

public class _2096_GoDownStairs {
	/*
	 * 계단내려가기
	 * 1.RGB거리 문제 / 비트박스 문제랑 비슷 최대,최소 둘다 구하는 버전.
	 * 2.근데 메모리제한이 4mb네? N은 10만이다.
	 * 3.dp 올리기 쓰자. 시간복잡도를 올리고 공간복잡도를 줄이기
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int a,b,c;
		int[][] maxDp=new int[2][3];
		int[][] minDp=new int[2][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(i==0) {
				maxDp[0][0]=minDp[0][0]=a;
				maxDp[0][1]=minDp[0][1]=b;
				maxDp[0][2]=minDp[0][2]=c;
				for(int j=0;j<3;j++) {
					maxDp[1][j]=maxDp[0][j];
					minDp[1][j]=minDp[0][j];
				}
			}else {
				maxDp[1][0]=Math.max(maxDp[0][0], maxDp[0][1])+a;
				maxDp[1][1]=Math.max(Math.max(maxDp[0][0], maxDp[0][1]),maxDp[0][2])+b;
				maxDp[1][2]=Math.max(maxDp[0][1], maxDp[0][2])+c;
				minDp[1][0]=Math.min(minDp[0][0], minDp[0][1])+a;
				minDp[1][1]=Math.min(Math.min(minDp[0][0], minDp[0][1]),minDp[0][2])+b;
				minDp[1][2]=Math.min(minDp[0][1], minDp[0][2])+c;
				for(int j=0;j<3;j++) {
					maxDp[0][j]=maxDp[1][j];
					minDp[0][j]=minDp[1][j];
				}
			}
		}
		
		int max,min;
		max=Math.max(Math.max(maxDp[1][0], maxDp[1][1]),maxDp[1][2]);
		min=Math.min(Math.min(minDp[1][0], minDp[1][1]),minDp[1][2]);
		System.out.println(max+" "+min);
	}
}
