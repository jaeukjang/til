package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import Greedy._H_11000_classRoomAssignment3.Time;

public class _19598_minRoomAssignment{
	static class Time implements Comparable<Time>{
		long start;
		long end;
		public Time(long start, long end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			if(this.start==o.start) {
				if(this.end>o.end) {
					return 1;
				}else if(this.end==o.end){
					return 0;
				}else {
					return -1;
				}
			}else {
				if(this.start>o.start) {
					return 1;
				}else {
					return -1;
				}
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<Time> list=new ArrayList<>();
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			long start=Long.parseLong(st.nextToken());
			long end=Long.parseLong(st.nextToken());
			list.add(new Time(start,end));
		}
		Collections.sort(list);
		Queue<Long> pq=new PriorityQueue<>();
		long endTime=0;
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
