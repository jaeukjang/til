package DataStructure;

import java.io.*;
import java.util.*;

public class _1158_josephus3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N,K가 입력
		int N = sc.nextInt();
		int K = sc.nextInt();
		//K-1번째 친구를 리스트에서 삭제.
		//마지막 삭제했던 위치에서 K-1번째 친구를 또 삭제.
		// 그런데 리스트의 크기보다 더 넘어간다면, list의 size만큼 뒤로 돌아오자
		//리스트가 다 비어져 없어질때까지 시행
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		int idx = 0; //화살표 역할을 할 위치변수
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while( !list.isEmpty() ) {
			idx += K-1; //왜 -1이냐면 이래야 지우고나서도 idx를 생각하니까 
			while( idx >= list.size() ) //이부분이 젤어렵네.
				idx -= list.size();
			sb.append(list.remove(idx)).append(", ");
		}
		//꺽새 닫는거 추가해줘야되는데,, 마지막 엘리먼트에 ,공백이 쓸데없이 껴있음
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
	}
}
