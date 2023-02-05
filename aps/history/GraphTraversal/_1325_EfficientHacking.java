package GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325_EfficientHacking {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr=new ArrayList[n+1];
		for(int i=1;i<=n;i++) arr[i]=new ArrayList<Integer>();
		int[] trusted=new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		boolean[] visited;
		int max=0;
		for(int i=1;i<=n;i++) {
			visited=new boolean[n+1];
			Queue<Integer> q=new ArrayDeque<>();
			q.offer(i);
			visited[i]=true;
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(int j=0;j<arr[cur].size();j++) {
					int tmp=arr[cur].get(j);
					if(!visited[tmp]) {
						trusted[tmp]++;
						visited[tmp]=true;
						q.offer(tmp);
					}
				}
			}
			
		}
		for(int i=1;i<=n;i++) {
			if(max<trusted[i]) max=trusted[i];
		}
		for(int i=1;i<=n;i++) {
			if(trusted[i]==max) {
				sb.append(i+" ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

