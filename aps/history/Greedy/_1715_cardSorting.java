package Greedy;

import java.io.*;
import java.util.*;

public class _1715_cardSorting {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long sum=0;
		Queue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<n;i++){
			pq.add(Integer.parseInt(br.readLine()));
		}
		for(int i=0;i<n-1;i++) {
			int tmp=pq.poll()+pq.poll();
			sum+=tmp;
			pq.add(tmp);
		}
		System.out.println(sum);
	}
}
