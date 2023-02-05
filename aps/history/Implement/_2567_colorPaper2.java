package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2567_colorPaper2 {
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
		System.out.println(circum());
		
	}
	static void checker(int x,int y) {
		for(int i=x;i<x+10;i++) {
			for(int j=y;j<y+10;j++) {
				paper[i][j]=true;
			}
		}
	}
	static int circum() {
		int result=0;
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]) {
					int r=i; int c=j;int cnt=4;
					for(int k=0;k<4;k++) {
						int nr=r+dr[k];
						int nc=c+dc[k];
						if(nr<0||nc<0||nr>=100||nc>=100) continue;
						if(paper[nr][nc]) cnt--;
					}
					if(cnt==1) result++;
					else if(cnt==2) result+=2;
				}
			}
		}
		return result;
	}
}
