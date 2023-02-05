package Greedy;

import java.io.*;
import java.util.*;

public class _H_1758_partTimerKangho {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long sum=0;
		int cnt=0;
		//오름차순으로 정렬하고 너가 줄 돈이 양수일때만 너를 카운팅한걸로 칠래 안그러면 넘어갈거야
		for(int i=0;i<n;i++) {
			int tmp=arr[i]-cnt;
			if(tmp>0) {
				sum+=tmp;
				cnt++;
			}
		}
		int cnt2=0;
		//내림차순으로 정렬하고 똑같이
		long sum2=0;
		for(int i=n-1;i>=0;i--) {
			int tmp=arr[i]-cnt2;
			if(tmp>0) {
				sum2+=tmp;
				cnt2++;
			}
		}
		int cnt3=0;
		long sum3=0;
		if(cnt>=cnt2) {
			for(int i=n-2;i>=0;i--) {
				int tmp=arr[i]-cnt3;
				if(tmp>0) {
					sum3+=tmp;
					cnt3++;
				}
			}
			sum3+=arr[n-1]-cnt3;
		}
		//그중 큰걸 택할래.
		long max=Math.max(sum, sum2);
		max=Math.max(max, sum3);
		
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
