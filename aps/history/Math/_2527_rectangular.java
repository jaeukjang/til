package Math;

import java.io.*;
import java.util.*;

public class _2527_rectangular {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			//직사각형 A만들기 
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			//직사각형 B만들기
			int X1=Integer.parseInt(st.nextToken());
			int Y1=Integer.parseInt(st.nextToken());
			int X2=Integer.parseInt(st.nextToken());
			int Y2=Integer.parseInt(st.nextToken());
			
			char result;
			if(X1>x2||Y1>y2||x1>X2||y1>Y2) {
				result='d';
			}else if((x1==X2&&y1==Y2)||(x2==X1&&y2==Y1)||(x1==X2&&y2==Y1)||(x2==X1&&y1==Y2)) {
				result='c';
			}else if((x1==X2)||(x2==X1)||(y1==Y2)||(y2==Y1)) {
				result='b';
			}else {
				result='a';
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
