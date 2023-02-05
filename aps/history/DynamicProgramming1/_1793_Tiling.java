package DynamicProgramming1;

import java.io.*;
import java.math.BigInteger;

public class _1793_Tiling {
	
	static BigInteger[] memo=new BigInteger[251];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		memo[0]=BigInteger.ONE;
		memo[1]=BigInteger.ONE;
		for(int i=2;i<251;i++) {
			memo[i]=memo[i-1].add(memo[i-2].multiply(BigInteger.valueOf(2)));
		}
		while((input=br.readLine())!=null&&!input.isEmpty()){
			int n=Integer.parseInt(input);
			sb.append(memo[n]+"\n");
		}
		System.out.println(sb);
	}

}
