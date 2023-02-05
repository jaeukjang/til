package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력받고  sorting
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//누적합 시켜주기
		for(int i=1;i<n;i++) {
			arr[i]+=arr[i-1];
		}
		//누적합 한것을 또 누적합하기.
		for(int i=1;i<n;i++) {
			arr[i]+=arr[i-1];
		}
		//출력
		bw.write(arr[n-1]+"\n");
		bw.flush();
		bw.close();
	}
}
