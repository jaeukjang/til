package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2879_코딩은예쁘게{
	/*
	 * 코딩은예쁘게
	 * 무조건 연결된것만~ 올리면되네
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] diff=new int[n];
		int start,end;
		for(int i=0;i<n;i++) {
			start=Integer.parseInt(st1.nextToken());
			end=Integer.parseInt(st2.nextToken());
			diff[i]=end-start;
		}
		int ans=0;
		boolean flag=false;
		for(int i=0;i<=80;i++) {
			boolean before=false;
			for(int j=0;j<n;j++) {
				if(diff[j]>0) {
					flag=true;
					diff[j]--;
					if(!before) ans++;
					before=true;
				}else {
					before=false;
				}
			}
			if(!flag) break;
		}
		flag=false;
		for(int i=0;i<=80;i++) {
			boolean before=false;
			for(int j=0;j<n;j++) {
				if(diff[j]<0) {
					diff[j]++;
					if(!before) ans++;
					before=true;
				}else {
					before=false;
				}
			}
		}
		System.out.println(ans);
	}
}