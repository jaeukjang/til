package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2668_ChoosingNumbers {
	/*
	 * 숫자고르기
	 * 1.부분집합을 고르는건 안됨. N이 100개 까지라
	 * 2.일단 없는 숫자 다 빼버려. TreeSet에 넣자. 
	 * 3.cycle 찾아서 다 ans에 넣어버리자. ans TreeSet에 
	 */
	static int n;
	
	static TreeMap<Integer,Integer> map=new TreeMap<>();
	static TreeSet<Integer> set=new TreeSet<>();
	static TreeSet<Integer> ans=new TreeSet<>();
	static TreeSet<Integer> cycle=new TreeSet<>();
	static TreeSet<Integer> fail=new TreeSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			int tmp=Integer.parseInt(br.readLine());
			if(i==tmp) {
				ans.add(tmp);
			}
			set.add(tmp);
			map.put(i, tmp);
		}
		for(Integer i:set) {
			if(!ans.contains(i)&&!fail.contains(map.get(i))) {
				cycle.clear();
				cycle.add(i);
				dfs(i,i);
			}
		}
		sb.append(ans.size()+"\n");
		for(Integer i:ans) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int num,int start) {
		
		cycle.add(num);
		int target=map.get(num);
		int tmp=map.get(target);
		if(tmp==start) {//cycle 찾은경우
			for(Integer i:cycle) {
				ans.add(i);
			}
			return;
		}
		if(ans.contains(tmp)||cycle.contains(tmp)) {// 실패지점
			return;
		}
//		System.out.println(start+" "+num+" "+target+" "+tmp);
//		System.out.print("cycle: ");
//		for(Integer i:cycle) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		dfs(tmp,start);
		
	}
}
