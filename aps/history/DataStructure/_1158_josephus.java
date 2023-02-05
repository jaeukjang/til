package DataStructure;

import java.io.*;
import java.util.*;

public class _1158_josephus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q=new LinkedList<>();
		List<Integer> list=new ArrayList<>();
		int N = sc.nextInt(); //전체 사람의 수 
		int K = sc.nextInt(); //쿵쿵따 같이 건너뛰고 컷 할 위치
		
		for(int i=0;i<N;i++) {
			q.add(i+1);
		}
		
		while(!q.isEmpty()) {
			for(int i=1;i<=K;i++) {
				if(i==K) {
					list.add(q.remove());
				}else {
					q.add(q.remove());
				}
			}
		}
		sb.append("<");
		for(int i=0;i<list.size();i++) {
			if(i==list.size()-1) {
				sb.append(list.get(i));
				break;
			}
			sb.append(list.get(i)+", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}

