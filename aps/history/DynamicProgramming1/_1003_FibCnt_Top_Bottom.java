package DynamicProgramming1;

import java.io.*;

public class _1003_FibCnt_Top_Bottom {
	/*
	 * 피보나치 함수 _ 하향식
	 * 1.ZeroCnt랑 OneCnt를 부르고 싶다는건데 0을 제외한 케이스는 fib[n-1], fib[n] 을 호출하는거랑 같다.
	 * 2.시간제한이 빡빡하니까 메모이제이션한  fib로 처리해버리기.
	 */
	static int zeroCnt;
	static int oneCnt;
	static int[] dp=new int[41];
	static int fib(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(dp[n]==0) {
			dp[n]=fib(n-2)+fib(n-1);
		}
		return dp[n];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t=Integer.parseInt(br.readLine());
		fib(40);
		dp[1]=1;
		int n;
		for(int i=0;i<t;i++) {
			n=Integer.parseInt(br.readLine());
			if(n==0) {
				sb.append(1+" "+0+"\n");
			}else {
				sb.append(dp[n-1]+" "+dp[n]+"\n");
			}
		}
		
		System.out.println(sb);
	}
}
