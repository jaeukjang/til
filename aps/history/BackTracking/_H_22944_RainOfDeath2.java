package BackTracking;

import java.io.*;
import java.util.*;

public class _H_22944_RainOfDeath2 {
	/*
	 * 죽음의  비
	 * 4<=N<=500 N*N격자
	 * 0<=K<10 우산갯수
	 * 1<=H<=10000 체력
	 * 1<=D<=5000 모든 우산의 체력
	 * 최소이동의 횟수출력 이동불가시 -1   입력은 N H D 그리고 격자
	 * S는 현재위치(시작점) U는 우산 E는 안전지대(도착점)
	 * 
	 * 1.S를 시작으로 사방탐색 시작? 내체력과 우산의 내구도는 따로 관리하기  
	 * 1-1. 일단 우산과 E 사이의 거리가 D+남은 체력 H 보다는 작아야하는데 그걸 미리 계산하는건 어려울것 같아...
	 * 1-2. 사방탐색을 하고 >> visited로 왔던길 안가게 관리하면서 죽어버릴때 가지치기하자.
	 * 2. 이동횟수가 min값보다  더 커질때도 가지치기 하자.
	 * 사분면탐색 폐기
	 * 
	 * 1.지금 위치에서 E로 갈수있으면 go
	 * 1-1. 못가면 갈 수 있는 우산으로 가 총 10! 360만개 경우의수임. 가지치기하면 더적어
	 */
	static int n,k,d;
	static int min=Integer.MAX_VALUE;
	static int sr,sc,er,ec; 
	static char[][] map;
	static List<Integer[]> list= new ArrayList<>();
	static boolean[] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		map=new char[n][n];
		sr=sc=er=ec=0;
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			map[i]=tmp.toCharArray();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='U') {
					Integer[] tmp= {i,j};
					list.add(tmp);
				}else if(map[i][j]=='E') {
					er=i;
					ec=j;
				}else if(map[i][j]=='S') {
					sr=i;
					sc=j;
				}
			}
		}
		k=list.size();
		visited=new boolean[k];
		dfs(0,sr,sc,h,0);
		if(flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
	}
	private static void dfs(int length, int nr, int nc, int h,int uh) {
		if(length>=min) {//min값보다 크면 안해
			return;
		}
		if(len(nr,nc,er,ec)<=h+uh) {
			min=Math.min(min, length+len(nr,nc,er,ec));
			flag=true;
			return;
		}
		for(int i=0;i<k;i++) {
			if(!visited[i]) {
				int tmp=len(nr,nc,list.get(i)[0],list.get(i)[1]);
				if(tmp<=uh) {//들고있는 우산체력과 내체력합보다 작을때만 가능
					visited[i]=true;
					dfs(length+tmp,list.get(i)[0],list.get(i)[1],h,d-1);
				}else if(tmp<=(h+uh)) {
					visited[i]=true;
					dfs(length+tmp,list.get(i)[0],list.get(i)[1],h+uh+1-tmp,d-1);//+1은 거기가서 교체한 우산으로 써서 uh는 d-1이고
				}
				visited[i]=false;
			}
		}
	}
	private static int len(int nr, int nc, int tr, int tc) {
		return Math.abs(nr-tr)+Math.abs(nc-tc);
	}
}
