package Greedy;

import java.io.*;
import java.util.*;

public class _2812_makeBigger {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		String s=br.readLine();
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			list.add((int)s.charAt(i)-'0');
		}
		int start=K;
		int end=0;int cnt=0;int cnt2=0;
		while(true) {
			int max=-1;
			if(start==N-1) {
				for(int i=start;i>=end;i--) {
					max=Math.max(list.get(i), max);
				}
				boolean flag=true;
				for(int i=start;i>=end;i--) {
					if(list.get(i)==max&&flag) {
						flag=false;
					}else {
						list.remove(i);
					}
				}
				break;
			}
			for(int i=start;i>=end;i--) {
				if(max<=list.get(i)) {
					if(i==start)
						cnt2--;
					max=list.get(i);
					cnt2++;
				}else {
					list.remove(i);
					cnt++;
					if(cnt==K)
						break;
				}
			}
			if(cnt==K)
				break;
			start=cnt2+K-cnt;
			end=cnt2;
			System.out.println("start is "+start);
			System.out.println("end is "+end);
		}
		StringBuilder sb = new StringBuilder();
		for(Integer i: list) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
