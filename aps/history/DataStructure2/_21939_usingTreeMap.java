package DataStructure2;

import java.io.*;
import java.util.*;

public class _21939_usingTreeMap {
	static int p,l;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<TreeSet<Integer>> L=new ArrayList<>();
		for(int i=0;i<=100;i++) {
			TreeSet<Integer> tmp=new TreeSet<>();
			L.add(tmp);
		}
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			p=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			L.get(l).add(p); //l난이도 인 리스트 인덱스에 TreeSet안에 p를 넣을거야.
		}
		
		int m=Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp=st.nextToken();
			int tmp2=Integer.parseInt(st.nextToken());
			if(tmp.equals("add")) {
				p=tmp2;
				l=Integer.parseInt(st.nextToken());
				L.get(l).add(p);
			}else if(tmp.equals("recommend")) {
				if(tmp2==1) {//가장어려운거
					for(int j=100;j>=1;j--) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).last()).append("\n");
							break;
						}
					}
				}else {//가장쉬운거
					for(int j=1;j<=100;j++) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).first()).append("\n");
							break;
						}
					}
				}
			}else {//solved
				p=tmp2;
				for(int j=1;j<=100;j++) {
					L.get(j).remove(p);
				}
			}
		}
		
		
		System.out.println(sb);
	}
}
