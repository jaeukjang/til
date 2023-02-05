package DataStructure;

import java.io.*;
import java.util.*;

public class _1158_josephus2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 전체 사람의 수
		int K = sc.nextInt(); // 쿵쿵따 같이 건너뛰고 컷 할 위치
		boolean[] arr = new boolean[N + 1];
		int[] result=new int[N];
		Arrays.fill(arr, true);
		arr[0] = false;
		int i=1;int cnt = 0;int cnt2=0;
		while(cnt2!=N) {
			if (arr[i] && ++cnt % K == 0) {
				arr[i] = false;
				result[cnt2++]=i;
			}
			i++;//i 추가
			if(i>N) i=1; //i 초기화
		}
		sb.append("<");
		for(int j=0;j<N;j++) {
			if(j==N-1) {
				sb.append(result[j]);
				break;
			}
			sb.append(result[j]+", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}
