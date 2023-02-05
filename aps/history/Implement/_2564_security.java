package Implement;

import java.io.*;
import java.util.*;

public class _2564_security {
	public static void main(String[] args) throws IOException {
		//가로 ,세로 100이하 자연수
		//상점의 갯수 100이하 자연수
		//1 블록 북쪽 , 2 블록 남쪽 ,3 블록의 서쪽 , 4 블록의 동쪽  두번째는 왼쪽으로부터 거리  두번쨰는 윗쪽으로부터의 거리
		//마지막이 동근이 위치
		//모든 거리를 원점으로부터의 거리로 만들어버리고 그리고 |내거리-target거리| |내거리+(둘레거리-target거리)| 두개 비교.하면 엄청쉬워짐. 
		
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width=Integer.parseInt(st.nextToken());
		int height=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(br.readLine());
		int[][] shop=new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0]=Integer.parseInt(st.nextToken());
			shop[i][1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dong1=Integer.parseInt(st.nextToken());
		int dong2=Integer.parseInt(st.nextToken());
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=dist(dong1,dong2,shop[i][0],shop[i][1],width,height);
		}
		System.out.println(sum);
	}
	static int dist(int dong1, int dong2, int target1, int target2,int width,int height) {
		int result=-1;
		if(dong1==target1) {//16개중 4개처리 
			result=Math.abs(dong2-target2);
		}else if(dong1==1) {
			if(target1==3) {
				result=dong2+target2;
			}else if(target1==4) {
				result=width-dong2+target2;
			}else {
				result=Math.min(height+dong2+target2,height+width*2-dong2-target2);
			}
		}else if(dong1==2) {
			if(target1==3) {
				result=dong2+height-target2;
			}else if(target1==4) {
				result=width-dong2+height-target2;
			}else {
				result=Math.min(height+dong2+target2,height+width*2-dong2-target2);
			}
		}else if(dong1==3) {
			if(target1==1) {
				result=dong2+target2;
			}else if(target1==2) {
				result=height-dong2+target2;
			}else {
				result=Math.min(width+dong2+target2,width+height*2-dong2-target2);
			}
		}else {
			if(target1==1) {
				result=dong2+width-target2;
			}else if(target1==2) {
				result=height-dong2+width-target2;
			}else {
				result=Math.min(width+dong2+target2,width+height*2-dong2-target2);
			}
		}
		return result;
	}
}
