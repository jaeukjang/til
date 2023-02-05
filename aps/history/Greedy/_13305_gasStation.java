package Greedy;

import java.io.*;
import java.util.*;

public class _13305_gasStation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//갯수 입력받기
		int n=Integer.parseInt(br.readLine());
		
		//거리 입력받기
		int[] distance=new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		
		//비용 입력받으면서 min값으로 바꿔주기
		int[] cost=new int[n];
		st = new StringTokenizer(br.readLine());
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
			if(min>cost[i]) {
				min=cost[i];// 받은값이 더작다면 min값 갱신해주기
			}else {
				cost[i]=min;// 나보다 더 작은게 있다면 내 값을 min으로
			}
		}
		
		//비용 sum에다가 거리*비용해주기
		long sum=0;
		for(int i=0;i<n-1;i++) {
			sum=sum+(long)distance[i]*(long)cost[i]; // 곱한값이 21억을 넘어가서 long으로 형변환
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
