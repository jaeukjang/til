package DataStructure2;

import java.io.*;
import java.util.*;

public class _7662_doublyPriorityQueue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			TreeMap<Integer,Integer> map=new TreeMap<>();
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				char c=st.nextToken().charAt(0);
				int num=Integer.parseInt(st.nextToken());
				if(c=='I') {//값 넣기
					map.put(num, map.getOrDefault(num, 0)+1);
				}else {//값 빼기
					if(map.size()==0) {
						continue;
					}
					if(num==-1) {//최솟값 빼기
						int tmp=map.firstKey();
						if(map.get(tmp)==1) {
							map.remove(tmp);
						}else {
							map.put(tmp,map.get(tmp)-1);
						}
					}else {//최댓값 빼기
						int tmp=map.lastKey();
						if(map.get(tmp)==1) {
							map.remove(tmp);
						}else {
							map.put(tmp,map.get(tmp)-1);
						}
					}
				}
			}
			if(map.size()==0) {
				sb.append("EMPTY"+"\n");
			}else {
				sb.append(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		System.out.println(sb);
	}
}
