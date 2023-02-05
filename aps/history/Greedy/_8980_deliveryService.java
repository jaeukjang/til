package Greedy;

import java.io.*;
import java.util.*;

public class _8980_deliveryService {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(br.readLine());
		List<Integer[]> list=new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			Integer[] tmp=new Integer[3];
			tmp[0]=Integer.parseInt(st.nextToken());
			tmp[1]=Integer.parseInt(st.nextToken());
			tmp[2]=Integer.parseInt(st.nextToken());
			list.add(tmp);
		}
		//도착순으로 오름차순, 그리고 출발순으로 내림차순
		Collections.sort(list,new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1]==o2[1]? o2[0]-o1[0]:o1[1]-o2[1];
			}
		});
		//지금 cNow는 실려있는 택배물 갯수.
		int[] cNow=new int[n+1];
		int sum=0;
		for(int i=0;i<m;i++) {
			int dep=list.get(i)[0];
			int arv=list.get(i)[1];
			int weight=list.get(i)[2];
			int contents=0;
			int min=10001;
			for(int j=dep;j<arv;j++) {
				min=Math.min(min, c-cNow[j]);
			}
			if(min>0) {//지금 비어있어? check
				if(min>=weight) {
					contents=weight;
				}else {
					contents=min;
				}
				sum+=contents;
				for(int j=dep;j<arv;j++) {//도착지점 전까지 cNow를 채워줘야지.
					cNow[j]+=contents;
				}
			}
		}
		System.out.println(sum);
	}
}
