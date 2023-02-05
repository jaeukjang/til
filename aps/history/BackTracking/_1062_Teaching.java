package BackTracking;

import java.io.*;
import java.util.*;

public class _1062_Teaching {
	/*
	 * 가르침
	 * 1. 알파벳 개수 중 k개만 고른 배열을 조합으로 생성한다 (dfs)
	 * 1-1. depth==k 되버리면 n개 단어에 readble 체크후 max와 비교
	 *  
	 */
	static int max,n,k;
	static String[] words;
	static Set<Character> set=new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		words=new String[n];
		for(int i=0;i<n;i++) {
			words[i]=br.readLine();
		}
		if(k<5) {
			System.out.println(0);
		}else {
			set.add('a');
			set.add('n');
			set.add('t');
			set.add('i');
			set.add('c');
			dfs(0,1);
			System.out.println(max);
		}
	}
	
	private static void dfs(int depth,int start) {
		if(depth==k-5) {
			int cnt=0;
			for(int i=0;i<words.length;i++) {
				if(readable(words[i])) cnt++;
			}
			max=Math.max(max, cnt);
			return;
		}
		
		for(int i=start;i<26;i++) {
			if(i==2||i==8||i==13||i==19) // c n i t 제외 
				continue;
			char tmp=(char)('a'+i);
			set.add(tmp);
			dfs(depth+1,i+1);
			set.remove(tmp);
		}
	}
	private static boolean readable(String word) {
		for(int i=4;i<word.length()-4;i++) { // anta tica는 미리 제외하자.
			if(!set.contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}	
