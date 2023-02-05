package BruteForce;

import java.io.*;
import java.util.*;

public class _22864_Fatigue {
	/*
	 * 피로도
	 * 한시간 일하면 피로도는 A만큼 쌓이고 일은 B만큼
	 * 한시간을 쉬면 C만큼 피로도 회복 최저는 0
	 * 피로도를 M을 넘기고 싶지않음
	 * 하루동안 할수 있는 최대 일의 양은? 
	 * 1.dfs 돌리고 가지치기 ... 이거 그냥 백트래킹 아닌가?
	 * 
	 */
	static int a,b,c,m,max;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		dfs(0,0,0);
		System.out.println(max);
	}

	private static void dfs(int hour, int fatigue, int work) {
		if(fatigue>m) {
			return;
		}
		if(hour==24) {
			max=Math.max(max, work);
			return;
		}
		dfs(hour+1,fatigue+a,work+b);
		dfs(hour+1,fatigue-c<=0?0:fatigue-c,work);
		
	}
}
