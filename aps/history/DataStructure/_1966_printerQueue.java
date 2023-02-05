package DataStructure;

import java.io.*;
import java.util.*;
class Paper{
	int weight;
	int index;
	
	public Paper(int priority, int index) {
		this.weight = priority;
		this.index = index;
	}
}

public class _1966_printerQueue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());//문서 갯수 최대 100개
			int m=Integer.parseInt(st.nextToken());//target은 몇번째 문서? 0번부터 시작
			st = new StringTokenizer(br.readLine());//문서들 중요도 1~9까지임 그냥 배열 만들자?
			Integer[] arr=new Integer[n];
			
			Queue<Paper> q=new LinkedList<Paper>();
			int index=0;
			for(int j=0;j<n;j++) {
				int weight=Integer.parseInt(st.nextToken());
				arr[j]=weight;
				q.add(new Paper(weight,index++));
			}
			Arrays.sort(arr,Collections.reverseOrder());
			
			int cnt=0;
			while(true) {
				Paper tmp=q.poll();
				if(tmp.weight>=arr[cnt]) {//나보다 큰놈들은 다 빼줘
					cnt++;
					if(tmp.index==m) {
						break;
					}
				}else {
					q.add(tmp);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
