package BackTracking;

import java.io.*;
import java.util.*;

public class _16987_EggBreaking {
	static int n;
	static int max=0;
	static int[][] eggs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		eggs=new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][0]=Integer.parseInt(st.nextToken());
			eggs[i][1]=Integer.parseInt(st.nextToken());
		}
		eggBreaking(0);
		System.out.println(max);
	}
	private static void eggBreaking(int hand) {
		if(hand==n) {
			int cnt=0;
			for(int i=0;i<n;i++) {
				if(eggs[i][0]<=0) cnt++;
			}
			if(cnt>max) {
				max=cnt;
			}
			return;
		}
		if(eggs[hand][0]<=0) {//나 깨져있으면 넘겨
			eggBreaking(hand+1);
		}else {
			for(int i=0;i<n;i++) {
				if(i!=hand &&eggs[i][0]>0) {//다른거중 안깨진게 있으면
					eggs[hand][0]-=eggs[i][1];
					eggs[i][0]-=eggs[hand][1];
					eggBreaking(hand+1);
					eggs[hand][0]+=eggs[i][1];
					eggs[i][0]+=eggs[hand][1];
				}
			}
		}
		//나빼고 다깨져있으면 끝낼래.
		boolean flag=true;
		for(int i=0;i<n;i++) {
			if(i!=hand&&eggs[i][0]>0) flag=false;
		}
		if(flag) {
			int cnt=n-1;
			if(cnt>max) {
				max=cnt;
			}
			return;
		}
	}
}
