import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3067_Coins {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		int n;//최대 20가지 1~10000
		int[] coins;
		int[][] dp;
		int m;//최대 10000
		for(int tc=0;tc<t;tc++) {
			n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			coins=new int[n];
			for(int i=0;i<n;i++) {
				coins[i]=Integer.parseInt(st.nextToken());
			}
			m=Integer.parseInt(br.readLine());
			dp=new int[n][m+1];
			for(int i=0;i<n;i++){
				for(int j=1;j<=m;j++) {
					if(i==0) {
						if(j%coins[i]==0)
							dp[i][j]=1;
					}else {
						if(j==coins[i])
							dp[i][j]=1;
						dp[i][j]+=dp[i-1][j];
						if(j<coins[i]) continue;
						dp[i][j]+=dp[i][j-coins[i]];
					}
				}
			}
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			sb.append(dp[n-1][m]+"\n");
		}
		System.out.println(sb);
	}

}
