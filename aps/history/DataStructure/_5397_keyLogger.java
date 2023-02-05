package DataStructure;

import java.io.*;
import java.util.*;
public class _5397_keyLogger {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			String in=br.readLine();
			Deque<Character> d=new LinkedList<>();
			Deque<Character> tmp=new LinkedList<>();
			int cursor=0; int size=0;
			
			for(int j=0;j<in.length();j++) {
				char c=in.charAt(j);
				if(c=='<') {
					if(cursor>0) {
						cursor--;
						tmp.push(d.pop());
					}
				}else if(c=='>') {
					if(cursor<size) {
						cursor++;
						d.push(tmp.pop());
					}
				}else if(c=='-') {
					if(cursor>0) {
						d.pop();
						size--;
						cursor--;
					}
				}else {
					d.push(c);
					cursor++;
					size++;
				}
			}
			while(!tmp.isEmpty()) {
				d.push(tmp.pop());
			}
			while(!d.isEmpty()) {
				sb.append(d.pollLast());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
