package BackTracking;

import java.io.*;
import java.util.*;

public class _15650_NM2 {
	
	static int n,m;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		check=new boolean[n];
		np(0,0);
		System.out.println(sb);
	}

	private static void np(int cnt,int start) {
		if(cnt==m) {
			for(int i=0;i<n;i++) {
				if(check[i])
					sb.append((i+1)+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<n;i++) {
			if(!check[i]) {
				check[i]=true;
				np(cnt+1,i);
				check[i]=false;
			}
		}
	}
}
