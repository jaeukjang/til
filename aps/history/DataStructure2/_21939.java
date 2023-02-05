package DataStructure2;

import java.io.*;
import java.util.*;

public class _21939 {
	static PriorityQueue<int[]> minQ=new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[1]==o2[1]? o1[0]-o2[0]:o1[1]-o2
					[1];
		}
	});
	
	static PriorityQueue<int[]> maxQ=new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[1]==o1[1]? o2[0]-o1[0]:o2[1]-o1[1];
		}
	});
	static boolean[] flag;
	static int p,l;
	static void add() {
		int[] tmp= {p,l};
		minQ.add(tmp);
		maxQ.add(tmp);
		flag[p]=true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		flag=new boolean[100001];
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			p=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			add();
		}
		
		int m=Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp=st.nextToken();
			int tmp2=Integer.parseInt(st.nextToken());
			if(tmp.equals("add")) {
				p=tmp2;
				l=Integer.parseInt(st.nextToken());
				add();
			}else if(tmp.equals("recommend")) {
				if(tmp2==1) {//가장어려운거
					while(!maxQ.isEmpty()&&!flag[maxQ.peek()[0]]) maxQ.poll();//trash 값 제거
					flag[maxQ.peek()[0]]=false;
					sb.append(maxQ.poll()[0]).append("\n");
				}else {//가장쉬운거
					while(!minQ.isEmpty()&&!flag[minQ.peek()[0]]) {
						System.out.print(minQ.peek()[0]);
						System.out.println(" "+minQ.peek()[1]);
						
						minQ.poll();//trash 값 제거
					}
					flag[minQ.peek()[0]]=false;
					sb.append(minQ.poll()[0]).append("\n");
				}
			}else {//solved
				p=tmp2;
				flag[p]=false;
				while(!minQ.isEmpty()&&!flag[minQ.peek()[0]]) minQ.poll();
				while(!maxQ.isEmpty()&&!flag[maxQ.peek()[0]]) maxQ.poll();
			}
		}
		
		System.out.println(sb);
	}
}
