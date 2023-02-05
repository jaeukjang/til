package BruteForce;

import java.io.*;
import java.util.*;

public class _18312_Time {
	/*
	 * 시각
	 * 1. 0부터 (N+1)*3600 전까지 세면되는거네
	 * 1-1. 좀더 최적화 할려면 분단위, 10분단위, 시각에 들어가있으면 통째로 날릴수 있음.
	 */
	static int cnt,n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<(n+1)*3600;i++) {
			int hh=i/3600;
			int mm=(i%3600)/60;
			int ss=(i%60);
			if(hh/10==k||hh%10==k||mm/10==k||mm%10==k||ss/10==k||ss%10==k)
				cnt++;
		}
		System.out.println(cnt);
	}
}
