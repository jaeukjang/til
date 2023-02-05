package GraphTraversal;

import java.io.*;
import java.util.*;

public class _1967_TreeDiameter {
	/*
	 * 트리의 지름
	 * 1. 노드 하나 골라서 깊이 내려가기 바닥까지 그렇게 더한 길이를 max1 max2은 노드마다 초기화 관리
	 * 2. 두개를 더한걸 전체 max로 관리 하면서 모든 노드 다돌기? 많진 않은거 같은데.
	 * ---폐기
	 * 
	 * 1. 문제 조건이 1이 루트노드인 트리이다. 유향 그래프로 탐색하자. 앞에께 부모노드 뒤에께 자식노드 이니까
	 * 2. 끝에서부터 max를 저장해두고 그거를 더하자.
	 */
	static int n,max,max1,max2,maxLevel;
	
	static TreeMap<Integer,Integer>[] list;
	static int[] arr;
	static int[] level;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		list=new TreeMap[n+1];
		arr=new int[n+1];
		level=new int[n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new TreeMap<>();
		}
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[a].put(b, c);
		}
		dfsForLevel(1,0);
		for(int i=maxLevel;i>=0;i--) {
			for(int j=1;j<=n;j++) {
				if(level[j]==i&&list[j].size()>0) {
					max1=0;max2=0;
					dfs(j,0,0);
					max=Math.max(max, max1+max2);
				}
			}
		}
		System.out.println(max);
	}
	private static void dfsForLevel(int num,int depth) {
		
		for(Integer key : list[num].keySet()) {// 내자식노드들 순회.
			level[key]=depth+1;
			maxLevel=Math.max(maxLevel, depth+1);
			dfsForLevel(key,depth+1);
		}
	}
	private static void dfs(int num,int depth,int sum) {
		if(depth==1) {
			compare(sum);
			return;
		}
		for(Integer key : list[num].keySet()) {// 내자식노드들 순회.
			dfs(key,depth+1,sum+list[num].get(key)+arr[key]);
		}
		arr[num]=Math.max(max1, max2);
		
	}
	private static void compare(int num) {
		if(max1<num) {
			max2=max1;
			max1=num;
		}else if(max2<num) {
			max2=num;
		}
	}
	
	
}
