package Math;

import java.io.*;
import java.util.*;

public class _18291_BiYoTTE {
	static int m=1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			if(n<=2) {
				sb.append(1+"\n");
			}else {
				sb.append(pow(2,n-2)%m+"\n");
			}
		}
		System.out.println(sb);
	}
	
	
	private static long pow(long a, long b) {
		if(b==1) {
			return a;
		}
		long tmp=pow(a,b/2);
		if(b%2==0) {
			return tmp%m*tmp%m;
		}else {
			return tmp%m*tmp%m*a%m;
		}
	}
}
