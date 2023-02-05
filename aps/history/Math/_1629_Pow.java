package Math;

import java.io.*;
import java.util.*;

public class _1629_Pow {
	/*
	 * 페르마의 소정리를 이용해서 미친듯이 나눠주기
	 */
	static int a,b,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		System.out.println(pow(a,b)%m);
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
