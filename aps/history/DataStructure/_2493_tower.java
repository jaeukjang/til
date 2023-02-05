package DataStructure;

import java.io.*;
import java.util.*;

public class _2493_tower {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer[]> stack=new Stack<>();
		int n=Integer.parseInt(br.readLine());//50만 이하
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			Integer[] tmpArr= {tmp,i+1};
			if(stack.isEmpty()) {
				stack.push(tmpArr);
				sb.append(0).append(" ");
			}else {
				while(!stack.isEmpty()&&stack.peek()[0]<tmp) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					sb.append(0).append(" ");
				}else {
					sb.append(stack.peek()[1]).append(" ");
				}
				stack.push(tmpArr);
			}
		}
		System.out.println(sb);
	}
}
