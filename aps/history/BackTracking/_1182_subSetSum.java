package BackTracking;

import java.io.*;
import java.util.*;

public class _1182_subSetSum{
	static int n,m;
	static Integer[] arr;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if(m>=0) {
			Arrays.sort(arr);
			np(0,0,0);
		}else {
			Arrays.sort(arr,Collections.reverseOrder());
			npN(0,0,0);
		}
		System.out.println(ans);
	}
	private static void np(int cnt,int sum,int start) {
		if(sum>m) {
			return;
		}else if(cnt!=0&&sum==m) {
			ans++;
		}
		for(int i=start;i<n;i++) {
			np(cnt+1,sum+arr[i],i+1);
		}
	}
	private static void npN(int cnt,int sum,int start) {
		if(sum<m) {
			return;
		}else if(sum==m) {
			ans++;
		}
		for(int i=start;i<n;i++) {
			npN(cnt+1,sum+arr[i],i+1);
		}
	}
}