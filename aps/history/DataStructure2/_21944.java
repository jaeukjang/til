package DataStructure2;

import java.io.*;
import java.util.*;

public class _21944 {
	static int p,l,g;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<TreeMap<Integer,Integer>> L=new ArrayList<>();
		for(int i=0;i<=100;i++) {
			TreeMap<Integer,Integer> tmp=new TreeMap<>();
			L.add(tmp);
		}
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			p=Integer.parseInt(st.nextToken());//문제번호
			l=Integer.parseInt(st.nextToken());//난이도
			g=Integer.parseInt(st.nextToken());//분류번호
			L.get(l).put(p,g); //l난이도 인 리스트 인덱스에 TreeSet안에 p를 넣을거야.
		}
			
		int m=Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp=st.nextToken();
			if(tmp.equals("add")) {
				p=Integer.parseInt(st.nextToken());
				l=Integer.parseInt(st.nextToken());
				g=Integer.parseInt(st.nextToken());
				L.get(l).put(p,g);
			}else if(tmp.equals("recommend")) {//G중에서 ~
				g=Integer.parseInt(st.nextToken());
				int num=Integer.parseInt(st.nextToken());
				if(num==1) {//가장어려운거
					loop:
					for(int j=100;j>=1;j--) {
						if(!L.get(j).isEmpty()&&L.get(j).containsValue(g) ){
							for(int key : L.get(j).descendingKeySet()) {
								if(L.get(j).get(key)==g) {
									sb.append(key+"\n");
									break loop;
								}
							}
						}
					}
				}else {//가장쉬운거
					loop2:
					for(int j=1;j<=100;j++) {
						if(!L.get(j).isEmpty()&&L.get(j).containsValue(g) ){
							for(int key : L.get(j).keySet()) {
								if(L.get(j).get(key)==g) {
									sb.append(key+"\n");
									break loop2;
								}
							}
						}
					}
				}
			}else if(tmp.equals("recommend2")){
				int num=Integer.parseInt(st.nextToken());
				if(num==1) {//가장어려운거
					for(int j=100;j>=1;j--) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).lastKey()).append("\n");
							break;
						}
					}
				}else {//가장쉬운거
					for(int j=1;j<=100;j++) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).firstKey()).append("\n");
							break;
						}
					}
				}
			}else if(tmp.equals("recommend3")) {
				int num=Integer.parseInt(st.nextToken());
				l=Integer.parseInt(st.nextToken());
				if(num==1) {//l보다 크거나 같은것중 가장 쉬운거
					boolean flag=true;
					for(int j=l;j<=100;j++) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).firstKey()).append("\n");
							flag=false;
							break;
						}
					}
					if(flag) sb.append(-1+"\n");
				}else {//l보다 작은것중 가장 어려운거.
					boolean flag=true;
					for(int j=l-1;j>=0;j--) {
						if(!L.get(j).isEmpty()) {
							sb.append(L.get(j).lastKey()).append("\n");
							flag=false;
							break;
						}
					}
					if(flag) sb.append(-1+"\n");
				}
			}else {//solved
				p=Integer.parseInt(st.nextToken());
				for(int j=1;j<=100;j++) {
					L.get(j).remove(p);
				}
			}
		}
		
		System.out.println(sb);
	}
}
