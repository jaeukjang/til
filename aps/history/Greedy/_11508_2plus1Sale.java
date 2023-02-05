package Greedy;

import java.io.*;
import java.util.*;

public class _11508_2plus1Sale {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[] cost=new int[n];
		for(int i=0;i<n;i++) {
			cost[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(cost);
		int cnt=0;
		int sum=0;
		for(int i=n-1;i>=0;i--) {
			if(++cnt%3==0) continue;
			sum+=cost[i];
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		
	}
}
