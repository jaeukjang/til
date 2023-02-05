package Greedy;

import java.io.*;
import java.util.*;

public class _18234_당근훔쳐먹기 {
	/*
	 * 당근 훔쳐먹기
	 * 1.p가 큰애는 나중에 먹자~ 끝에서부터 하나씩 채워나가기
	 * 2.아... 없어지면 다시 심는구나 >>는 중요한게 아님 (함정)어쩌피 묵혔다 먹는게 제일이야.
	 * 3.문제의 조건이 w<=p이고, n<=t 이기 때문에 가능한 풀이.
	 * 
	 */
	static int n,t;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		arr=new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {// 영양제 순으로 내림차순 소팅
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1]; // 영양제순으로만 정렬해도 괜찮음
			}
		});
		long ans=0;
		int cnt=0;
		for(int i=t;i>=0;i--) {
			ans+=(long)(i-1)*arr[cnt][1]+arr[cnt][0];// 여기서 헤맴. 곱한거 자체가 int범위를 벗어날 수 있어서 (long)
			if(++cnt==n) break;
		}
		System.out.println(ans);
	}
}
