package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407_Combination {
	/*
	 * 조합
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		BigInteger a;
		BigInteger b;
		BigInteger c;
		a=fact(n);
		b=fact(m);
		c=fact(n-m);
		System.out.println(a.divide(b).divide(c));
	}
	static BigInteger fact(int a) {
		BigInteger num= BigInteger.ONE;
		for(int i=2;i<=a;i++) {
			num=num.multiply(BigInteger.valueOf(i));
		}
		return num;
	}
}
