package DataStructure;

import java.io.*;
import java.util.*;

public class _1874_stackSeries {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		boolean flag=true;
		//우선 입력
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack=new Stack<>();
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			if(arr[i]<cnt) {
				if(stack.peek()==arr[i]) {
					stack.pop();
					sb.append("-"+"\n");
				}else {
					flag=false;
					break;
				}
			}else {
				while(cnt<arr[i]) {
					stack.add(++cnt);
					sb.append("+"+"\n");
				}
				stack.pop();
				sb.append("-"+"\n");
			}
		}
		if(flag)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
