package BackTracking;

import java.io.*;
import java.util.*;

public class _15651_NM3 {
	
	static int n,m;
	static boolean[] check;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		check=new boolean[n];
		arr=new int[m];
		np(0);
		System.out.println(sb);
	}

	private static void np(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			arr[cnt]=i+1;
			np(cnt+1);
		}
	}
}
