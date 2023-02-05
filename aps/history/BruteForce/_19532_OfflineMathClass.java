package BruteForce;

import java.io.*;
import java.util.*;

public class _19532_OfflineMathClass {
	/*
	 * 수학은 비대면강의입니다
	 * 1.그냥  역행렬 곱하면 되잖아
	 * 1-1. x=1/ad-bc *(d*q1-a*q2);
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x,y;
		int[] arr=new int[7];
		for(int i=1;i<=6;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		x=(arr[5]*arr[3]-arr[2]*arr[6])/(arr[1]*arr[5]-arr[2]*arr[4]);
		y=-(arr[4]*arr[3]-arr[1]*arr[6])/(arr[1]*arr[5]-arr[2]*arr[4]);
		System.out.println(x+" "+y);
	}
}
