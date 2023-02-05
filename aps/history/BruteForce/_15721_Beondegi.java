package BruteForce;

import java.io.*;
import java.util.*;

public class _15721_Beondegi {
	/*
	 * 번데기
	 * 뻔은 0 데기는 1 A명 T번째 0or 1  T번째 0 or 1 외친사람 구하기
	 * 1.depth와 cnt 두개 관리하면서 dfs 쓰자. 원이니까 모듈러 쓰면서
	 * 1-1. cnt=1 일때 4+4*1 cnt=2일떄 4+4*2 ...
	 */
	static int a,t,target;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		a=Integer.parseInt(br.readLine());
		t=Integer.parseInt(br.readLine());
		target=Integer.parseInt(br.readLine());
		int cnt=0;int tmp=t;
		while(tmp-(cnt+4)>0) {
			tmp-=++cnt+3;
		}
		int sum=0;
		for(int i=1;i<=cnt;i++) {
			sum+=4+(i+1)*2;
		}
		if(target==0) {//뻔
			if(tmp<=2) {//뻔 데기 뻔 데기
				sum+=(tmp-1)*2;
			}else {//뻔 뻔 뻔 ...
				sum+=tmp+1;
			}
		}else {//데기
			if(tmp<=2) {//뻔 데기 뻔 데기
				sum+=(tmp-1)*2+1;
			}else {//데기 데기 데기 ...
				sum+=tmp+1+cnt+2;
			}
		}
		System.out.println(sum%a);
	}
}
