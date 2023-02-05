package DataStructure;

import java.io.*;
import java.util.*;

public class _H_10799_ironBar {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		int sum=0; int openCnt=0;
		for(int i=0;i<input.length();i++) {
			char tmp=input.charAt(i);
			if(tmp==')') {
				if(input.charAt(i-1)=='(') {//레이저
					openCnt--;
					sum+=openCnt;
				}else {//not laser
					sum++;
					openCnt--;
				}
					
			}else {
				openCnt++;
			}
		}
		System.out.println(sum);
	}
}
