package Greedy;

import java.io.*;
import java.util.*;

public class _H_11000_classRoomAssignment3 {
	//Array 에서 List로 옮겨감
	static class Time implements Comparable<Time>{
		int start;
		int end;
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			return this.start==o.start? this.end-o.end : this.start-o.start;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<Time> list=new ArrayList<>();
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new Time(start,end));
		}
		Collections.sort(list);
		Queue<Integer> pq=new PriorityQueue<>();
		int endTime=0;
		for(Time t:list) {
			endTime = t.end;
			
			if(!pq.isEmpty() && pq.peek() <= t.start) {
				pq.poll(); 
			}
			pq.add(endTime);
		}
		System.out.println(pq.size());
		
	}
}
