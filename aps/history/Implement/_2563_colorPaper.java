package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563_colorPaper {
	static boolean[][] paper=new boolean[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			checker(x,y);
		}
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	static void checker(int x,int y) {
		for(int i=x;i<x+10;i++) {
			for(int j=y;j<y+10;j++) {
				paper[i][j]=true;
			}
		}
	}
}
