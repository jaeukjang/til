package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21314_MKnumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //최댓값
		StringBuilder sb2 = new StringBuilder(); //최솟값
		String input=br.readLine();
		if(!input.contains("M")) {
			for(int i=0;i<input.length();i++) {
				sb.append(5);
				sb2.append(5);
			}
			System.out.println(sb);
			System.out.println(sb2);
			System.exit(0);
		}
		String[] tmp=input.split("K");
		for(int i=0;i<tmp.length;i++) {
			//K가 아예없다면..
			if(!input.contains("K")) {
				sb.append(1);
				sb2.append(1);
				for(int j=0;j<input.length()-1;j++) {
					sb.append(1);
					sb2.append(0);
				}
				break;
			}
			String s=tmp[i];
			//마지막번째케이스에서 만약 끝문자가 M이었다면 마지막엔 K가 없으니..
			int mCnt=s.length();
			if(i==tmp.length-1 &&input.charAt(input.length()-1)=='M') {
				sb.append("1");
				sb2.append("1");
				for(int j=0;j<mCnt-1;j++) {
					sb.append(1);
					sb2.append(0);
				}
				break;
			}
			sb.append(5);
			if(mCnt!=0)
				sb2.append(1);
			for(int j=0;j<mCnt;j++) {
				sb.append(0);
				if(j==0) continue;
				sb2.append(0);
			}
			sb2.append(5);
		}
		//출력
		System.out.println(sb);
		System.out.println(sb2);
	}
}
