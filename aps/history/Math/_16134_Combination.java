package Math;

import java.io.*;
import java.util.*;

public class _16134_Combination {
	/*
	 * 페르마의 소정리를 이용해서 미친듯이 나눠주기
	 */
	static int m=1000000007;
	static int n,r;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		System.out.println((fact(n)*pow((fact(r)%m*fact(n-r)%m),m-2)%m)%m);
	}
	
	
	private static long fact(long num) {
		long tmp=1;
		for(int i=2;i<=num;i++) {
			tmp=(tmp*i)%m;
		}
		return tmp;
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
