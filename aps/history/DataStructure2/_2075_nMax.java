package DataStructure2;

import java.io.*;
import java.util.*;

public class _2075_nMax{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][n];
		int[] idx=new int[n];
		Arrays.fill(idx, n-1);
		
		//입력받고
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		int ans=0;
		while(cnt!=n) {
			int max=Integer.MIN_VALUE;
			int maxIdx=0;
			for(int i=0;i<n;i++) {
				if(max<arr[idx[i]][i]) {
					max=arr[idx[i]][i];
					maxIdx=i;
				}
			}
			cnt++;
			idx[maxIdx]--;
			if(cnt==n) {
				ans=max;
			}
		}
		System.out.println(ans);
	}
}