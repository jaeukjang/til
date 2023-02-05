package DynamicProgramming1;

import java.io.*;
import java.math.BigInteger;

public class _11726_2xnTiling {
	
	static BigInteger[] memo=new BigInteger[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		memo[0]=BigInteger.ONE;
		memo[1]=BigInteger.ONE;
		for(int i=2;i<1001;i++) {
			memo[i]=memo[i-1].add(memo[i-2]);
		}
		int n=Integer.parseInt(br.readLine());
		System.out.println(memo[n].mod(BigInteger.valueOf(10007)));
	}

}
