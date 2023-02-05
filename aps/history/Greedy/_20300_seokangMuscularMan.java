package Greedy;

import java.io.*;
import java.util.*;

public class _20300_seokangMuscularMan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		long[] arr=new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long max=-1;
		if(arr.length%2==0) {//length가 짝수인건 이렇게하는거 OK이야
			for(int i=0;i<arr.length/2;i++) {
				long tmp=arr[i]+arr[arr.length-1-i];
				max=Math.max(max, tmp);
			}
		}else { // 근데 홀수면 얘기가 달라 가장큰거를 혼자 해야해 
			for(int i=0;i<arr.length/2;i++) {
				long tmp=arr[i]+arr[arr.length-2-i]; // 그래서 뒤에서 두번째랑 합해주고
				max=Math.max(max, tmp);
			}
			max=Math.max(max, arr[arr.length-1]); // 마지막에 가장 큰거랑 비교해
		}
		
		System.out.println(max);
	}
}
