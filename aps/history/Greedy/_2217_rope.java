package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class _2217_rope {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr,Collections.reverseOrder());
		
		//자기 idx +1*자기 자신 무게 중 가장 큰걸 O(n)으로 탐색
		int max=-1;
		for(int i=0;i<n;i++) {
			max=Math.max(max, (i+1)*arr[i]);
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
		
	}
}
