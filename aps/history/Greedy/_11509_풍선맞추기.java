package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11509_풍선맞추기 {
	/*
	 * 풍선맞추기
	 * 높은거부터 쏴서 감소하는거 찾기 근데 n이 100만개 까지네? 시간초과인데
	 * cnt 배열 만들고 하나씩 없애기?
	 */
	public static void main(String[] args) throws IOException {
		int[] cnt=new int[1000002];
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp;
		
		for(int i=0;i<n;i++) {
			tmp=Integer.parseInt(st.nextToken());
			if(cnt[tmp+1]>=1) {
				cnt[tmp+1]--;
			}
			cnt[tmp]++;
		}
		int ans=0;
		for(int i=1;i<=1000000;i++) {
			ans+=cnt[i];
		}
		System.out.println(ans);
	}
}
