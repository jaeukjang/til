package BackTracking;

import java.io.*;
import java.util.*;

public class _15663_NM9 {
	static int n,m;
	static boolean[] check;
	static int[] arr;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set=new LinkedHashSet<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input=new int[n];
		for(int i=0;i<n;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		check=new boolean[n];
		arr=new int[m];
		np(0);
		for(String s:set) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}

	private static void np(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			set.add(sb.toString());
			sb.setLength(0);
			return;
		}
		for(int i=0;i<n;i++) {
			if(!check[i]) {
				check[i]=true;
				arr[cnt]=input[i];
				np(cnt+1);
				check[i]=false;
			}
		}
	}
}