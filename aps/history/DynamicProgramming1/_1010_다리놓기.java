package DynamicProgramming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	/*
	 * 다리놓기
	 * N개 M개 겹칠수 없다. mCn인데?...
	 */
	static int n,m;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		dp=new long[30][30];
		for(int i=0;i<30;i++) {
			dp[i][0]=1;
			dp[i][i]=1;
		}
		for(int i=2;i<30;i++) {
			for(int j=1;j<i;j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			sb.append(dp[m][n]+"\n");
		}
		System.out.println(sb);
	}
}
