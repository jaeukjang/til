package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _H_21314_MKnumber2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //최댓값
		StringBuilder sb2 = new StringBuilder(); //최솟값
		String input=br.readLine();
		char[] arr=input.toCharArray();
		int mcnt=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='M') {
				mcnt++;
			}else {
				if(mcnt==0) {
					sb.append(5);
					sb2.append(5);
				}else {
					sb.append(5);
					sb2.append(1);
					for(int j=0;j<mcnt;j++) {
						sb.append(0);
						if(j==0) continue;
						sb2.append(0);
					}
					sb2.append(5);
					mcnt=0;
				}
			}
			if(mcnt>0&&i==arr.length-1) {
				sb.append(1);
				sb2.append(1);
				for(int j=0;j<mcnt-1;j++) {
					sb.append(1);
					sb2.append(0);
				}
			}
		}
		System.out.println(sb);
		System.out.println(sb2);
	}
}
