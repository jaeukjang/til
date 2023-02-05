package DataStructure2;

import java.io.*;
import java.util.*;

public class _7662_dualPQ2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			PriorityQueue<int[]> minQ=new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]<=o2[0]? -1:1;
				}
			});
			
			PriorityQueue<int[]> maxQ=new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0]<=o1[0]? -1:1;
				}
			});
			
			boolean[] flag=new boolean[n];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				char c=st.nextToken().charAt(0);
				int num=Integer.parseInt(st.nextToken());
				
				switch(c) {
					case 'I':
						int[] tmp= {num,j};
						flag[j]=true;
						minQ.add(tmp);
						maxQ.add(tmp);
						break;
					case 'D':
						switch(num) {
							case -1:
								while(!minQ.isEmpty() && !flag[minQ.peek()[1]]) 
									minQ.poll();
								if(!minQ.isEmpty()) {
									flag[minQ.peek()[1]]=false;
									minQ.poll();
								}
								break;
							case 1:
								while(!maxQ.isEmpty() && !flag[maxQ.peek()[1]]) 
									maxQ.poll();
								if(!maxQ.isEmpty()) {
									flag[maxQ.peek()[1]]=false;
									maxQ.poll();
								}
						}
				}
			}
			//찌꺼기 처리
			while(!minQ.isEmpty() && !flag[minQ.peek()[1]]) 
				minQ.poll();
			while(!maxQ.isEmpty() && !flag[maxQ.peek()[1]]) 
				maxQ.poll();
			//이제 남은건 flag가 true인 것만 + false 인데 우선순위가 낮은애들 (상관없음)
			if(minQ.isEmpty()){
				sb.append("EMPTY\n");
			}else {
				sb.append(maxQ.poll()[0]+" "+minQ.poll()[0]+"\n");
			}
		}
		System.out.println(sb);
	}
}
