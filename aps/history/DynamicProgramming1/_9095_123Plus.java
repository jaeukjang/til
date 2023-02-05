package DynamicProgramming1;

import java.io.*;

public class _9095_123Plus {
	
	static int[] memo=new int[12];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			sb.append(dp(n)+"\n");
		}
		System.out.println(sb);
	}

	private static int dp(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}
		memo[n]=dp(n-3)+dp(n-2)+dp(n-1);
		return memo[n];
		
	}
}
