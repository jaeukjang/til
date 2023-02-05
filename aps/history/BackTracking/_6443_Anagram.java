package BackTracking;

import java.io.*;
import java.util.*;

public class _6443_Anagram {
	
	/*
	 * 애너그램
	 * 
	 * 1.String 받아서 char배열로바꾸고 sorting 한후 재귀돌리기
	 * 1-1. 중복제거해줘야되서 past 사용. 글자수는 20이하이고 애너그램의 수가 10만개 이하인 단어만 입력이므로
	 * 1-2. 시간초과는 안될 것 같다.
	 * 2. ans char배열에 단어 담아두고 마지막에 for문으로 sb에 담아서 출력.
	 * 
	 */
	static StringBuilder sb = new StringBuilder();
	static char[] chars;
	static char[] ans;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String input=br.readLine();
			n=input.length();
			chars=input.toCharArray();
			ans=new char[n];
			visited=new boolean[n];
			Arrays.sort(chars);
			dfs(0);
		}
		System.out.println(sb);
	}
	private static void dfs(int depth) {
		if(depth==n) {
			for(int i=0;i<n;i++) {
				sb.append(ans[i]);
			}
			sb.append("\n");
			return;
		}
		char past='\0';
		for(int i=0;i<n;i++) {
			if(!visited[i]&&past!=chars[i]) {
				visited[i]=true;
				ans[depth]=chars[i];
				past=chars[i];
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}







