package Greedy;

import java.io.*;
import java.util.*;

public class _13975_fileMerging3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			long sum=0;
			Queue<Long> pq=new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				pq.add(Long.parseLong(st.nextToken()));
			}
			int cnt=0;
			while(cnt<n-1) {
				long tmp=pq.poll()+pq.poll();
				sum+=tmp;
				pq.add(tmp);
				cnt++;
			}
			System.out.println(sum);
		}
	}
}
