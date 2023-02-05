package DisjointSet;

import java.io.*;
import java.util.Arrays;

public class _10775_AirPort {
	/*
	 * 공항
	 * 1.이거를 분리집합으로...?
	 * 2.흠... 가장 큰수부터 하나씩 내려가면 1초를 무조건 넘길거 같다 최대 n이 10만이니까
	 * 
	 */
	static int[] root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int g=Integer.parseInt(br.readLine());
		int p=Integer.parseInt(br.readLine());
		root=new int[g+1];
		for(int i=1;i<=g;i++) {
			root[i]=i;
		}
		int[] ap=new int[p];
		for(int i=0;i<p;i++) {
			ap[i]=Integer.parseInt(br.readLine());
		}
		int cnt=0;
		for(int i=0;i<p;i++) {
			if(union(ap[i])==-1) {
				break;
			}else {
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(root));
		System.out.println(cnt);
	}
	private static int union(int i) {
		if(root[i]==i) {
			return --root[i];
		}
		return root[i]=union(root[i]);
	}
}
