package GraphTraversal;

import java.io.*;
import java.util.*;

public class _22946_CircleTraversal_1 {
	/*
	 * 원 이동하기 1
	 * 1.원이 겹치는경우를 인접해있다고 보고 그래프 이동으로 풀기. 양방향 간선이라고 볼 수 있긴한데... inner인지 outer인지 구분해주기.
	 * 2.까다로운건 이 node에 outer가 없을때는 좌표평면으로도 이동가능함.
	 * 3.inner는 여러개 있을 수 있어서 list로 관리하고 outer는 무조건 하나니까 배열로 관리하기.
	 * 4.그래서 모든 원에서 시작해보고 outer로 가거나 inner로 가거나 둘중하나. visted로 관리하면됨.
	 * 5.outer circle 이 없을때 0이라고 관리하고 그러면 0을 visited하고 그후에 0에서 갈 수 있는 inner 가기. 0을 가장 큰 outer로 보는거야.
	 * 6.한 노드에서 시작해서 가장 큰 depth를 max와 비교.
	 * 
	 * ----
	 * 원과 원사이의 거리를 이용
	 * 1. 중심 사이의 거리가 큰 반지름 보다 작다면 큰 반지름원이 outer inner에 작은 원
	 * 2. 중심 사이의 거리가 두 반지름 합보다 크다면 둘은 not 인접
	 * 이렇게만 나누면 될 거 같아 주어진 문제상황에서는 (내접 외접의 경우가 없고 서로 교점을 가지지를 않음)
	 *  
	 */
	static int n;
	static int[][] circles;
	static List<Integer>[] inner;
	static int[] outer;
	static boolean[] visited;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		circles=new int[n+1][3];
		outer=new int[n+1];
		inner=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			inner[i]=new ArrayList<>();
		}
		//circles 정보 담아두기
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			circles[i][0]=Integer.parseInt(st.nextToken());//x
			circles[i][1]=Integer.parseInt(st.nextToken());//y
			circles[i][2]=Integer.parseInt(st.nextToken());//r
		}
		Arrays.sort(circles,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
			
		});
		
		//inner or outer 체크
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				check(i,j); //inner에 넣을지 outer에 넣을지 아니면 관계없는지 확인
			}
		}
		for(int i=1;i<=n;i++) {//좌표평면에 바로 인접해있는 원들 담아주기.
			if(outer[i]==0) {
				inner[0].add(i);
			}
		}
		for(int i=0;i<=n;i++) {//원에서 시작해서 갈 수 있는데까지 가기
			visited=new boolean[n+1];
			dfs(i,0);
		}
		
		
		//잘 들어왔는지 확인
//		for(int i=0;i<=n;i++) {
//			System.out.print(outer[i]+" ");
//		}
//		System.out.println();
//		System.out.println("YES");
//		for(int i=1;i<=n;i++) {
//			System.out.print("in circle "+i+": ");
//			for(Integer x:inner[i]) {
//				System.out.print(x+" ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(max);
	}


	private static void dfs(int num,int depth) {
		
		visited[num]=true;
		max=Math.max(max, depth);
		if(!visited[outer[num]]) {
			dfs(outer[num],depth+1);
		}
		for(Integer i:inner[num]) {
			if(!visited[i]) {
				dfs(i,depth+1);
			}
		}
		
	}

	
	private static void check(int c1, int c2) {
		int x1=circles[c1][0];
		int y1=circles[c1][1];
		int r1=circles[c1][2];
		int x2=circles[c2][0];
		int y2=circles[c2][1];
		int r2=circles[c2][2];
		double dist=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
		if(dist<r1+r2) {
			if(r1>r2) {
				if(outer[c2]==0) {
					outer[c2]=c1;
					inner[c1].add(c2);
				}
			}else {
				if(outer[c1]==0) {
					outer[c1]=c2;
					inner[c2].add(c1);
				}
			}
		}
	}
}
