package BackTracking;

import java.io.*;
import java.util.*;

public class _1174_DescendingNum {
	/*	줄어드는수
	 * 
	 * 1. 0부터 9까지 for문  돌리는 재귀.
	 * 1-1. 재귀로 돌려서 중복된수 power set 만들기 *10하면서 num에 추가...depth는 10까지
	 * 2. 가지치기 해야되는데... 10^10을 할순없으니
	 * 2-1. 받아온 num%10이 나보다 크면 가지치기! 
	 * 3. 순서대로 list에 add하고 list.get(n)으로 답출력 if else 문으로 size 넘어갔으면 -1
	 */
	
	static List<Long> list=new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dfs(0,0);	
		Collections.sort(list);
		if(n<=list.size()) {
			System.out.println(list.get(n-1));
		}else {
			System.out.println(-1);
		}
	}

	private static void dfs(int depth, long num) {
		if(depth==10) {
			list.add(num);
			return;
		}
		for(int i=0;i<10;i++) {
			if(depth==0||num%10>i) {
				dfs(depth+1,num*10+i);
			}else {
				dfs(10,num);
				break;
			}
		}
	}
}
