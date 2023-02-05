package Greedy;

import java.io.*;
import java.util.*;

public class _H_2812_makeBigger2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		String s=br.readLine();
		Stack<Integer> stack =new Stack<>();
		Stack<Integer> result =new Stack<>();
		for(int i=N-1;i>=0;i--) {
			stack.add((int)s.charAt(i)-'0');
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			int tmp=stack.pop();
			while(!result.isEmpty()&&cnt<K&&result.peek()<tmp) {
				result.pop();
				cnt++;
			}
			result.push(tmp);
		}
		
		StringBuilder sb = new StringBuilder();
		int len=N-K;
		int cnt2=0;
		for(Integer i:result) {
			sb.append(i);
			cnt2++;
			if(cnt2==len)
				break;
		}
		System.out.println(sb);
	}
}
