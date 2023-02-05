package BruteForce;

import java.io.*;
import java.util.*;

public class _2422_ItalyIcecream {
	/*
	 * 한윤정이 이탈리아에  가서 아이스크림을 사먹는데
	 * N: 아이스크림의 종류 갯수 M:피해야할 조합의 갯수
	 * 1.3가지를 선택하고 싶은거니까 nC3 인데 피해야할 조합의 갯수를 제외한.
	 * 1-1. 조합을 만들고 제외하지말고 만들기전에 제외하자.
	 * 2. 피해야할 조합을 sorting해서  key : value :로 만들어서 넣자. value는 list 
	 */
	static boolean[] visited;
	static Map<Integer,List<Integer>> map=new HashMap<>();
	static int n,m,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		//피해야할 조합 받고 map에다가 넣기.
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(a>b) { // sorting 작은게 key로 가게끔
				int tmp=a;
				a=b;
				b=tmp;
			}
			if(map.containsKey(a)) {
				map.get(a).add(b);
			}else {
				List<Integer> tmp=new ArrayList<>();
				tmp.add(b);
				map.put(a, tmp);
			}
		}
		visited=new boolean[n+1];
		dfs(0,1);
		System.out.println(cnt);
	}
	private static void dfs(int depth,int start) {
		if(depth==3) {//3개 다골랐네
			cnt++;
			return;
		}
		
		for(int i=start;i<=n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				if(map.containsKey(i)) {
					List<Integer> list=new ArrayList<>();
					for(Integer x:map.get(i)) {//피해야할 조합들도  전부다 꺼버려
						if(!visited[x]) {
							visited[x]=true;
							list.add(x);
						}
					}
					dfs(depth+1,i+1);
					visited[i]=false;
					for(Integer x:list) {//내가 꺼버린것들만 다시
						visited[x]=false;
					}
				}else {
					dfs(depth+1,i+1);
					visited[i]=false;
				}
			}
		}
		
	}
}
