package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20365_blog2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		String s=br.readLine();
		
		//Blue 블럭 찾기
		boolean flag=false;
		int cnt=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='R') {
				flag=false;
			}else if(!flag && s.charAt(i)=='B') {
				cnt++;
				flag=true;
			}else {
				
			}
		}
		//Red 블럭 찾기
		flag=false;
		int cnt2=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='B') {
				flag=false;
			}else if(!flag && s.charAt(i)=='R') {
				cnt2++;
				flag=true;
			}else {
				
			}
		}
		int min=Math.min(cnt, cnt2);
		System.out.println(min+1);
		
	}
}
