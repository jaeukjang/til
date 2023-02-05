package GraphTraversal;
import java.io.*;
import java.util.*;

public class _22948_CircleTraversal_2 {
	/*
	 * 원 이동하기 2
	 * 1.원 이동하기 1이랑 거의  같은줄 알았는데 다른문제다...
	 * 2.쉬운문제였구나
	 * 
	 */
	static class Node{
		int num;
		Node prev;
		public Node(int num, Node prev) {
			this.num = num;
			this.prev = prev;
		}
	}
	static int n;
	static int[][] circles;
	static Node[] nodes;
	static int s,e,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		circles=new int[n+1][3]; //0 에는 index k 1에는 x 2에는 r
		circles[0][2]=Integer.MAX_VALUE;//가장 큰 좌표평면 원 만들어주기
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			circles[0][0]=Integer.parseInt(st.nextToken());
			circles[0][1]=Integer.parseInt(st.nextToken());
			circles[0][2]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(circles,new Comparator<int[]>() {// 지름으로 오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		for(int i=0;i<n;i++) {
			
		}
		
		
	}
}
