package Greedy;

import java.util.*;
import java.io.*;

public class _H_13164_happyKindergarten {
	public static void main(String[] args) throws IOException {
		//조건 check 일단 유치원생 키가 10억이하 자연수, N은 30만개 이미 정렬된 채로 주어짐.
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		List<Integer> diff=new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int tmp=Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			int tmp2=Integer.parseInt(st.nextToken());
			diff.add(tmp2-tmp);
			tmp=tmp2;
		}
		Collections.sort(diff);
		int sum=0;
		for(int i=0;i<N-K;i++) {
			sum+=diff.get(i);
		}
		System.out.println(sum);
	}
}
