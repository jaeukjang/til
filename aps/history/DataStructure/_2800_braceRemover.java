package DataStructure;

import java.io.*;
import java.util.*;

public class _2800_braceRemover {
	static List<Integer[]> list;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();
	static int cnt;
	static String s;
	
	public static void printer(int num,boolean[] bArr) {
		if(num>=cnt) return;
		printer(num+1,bArr);
		bArr[list.get(num)[0]]=true;
		bArr[list.get(num)[1]]=true;
		for(int i=0;i<s.length();i++) {
			if(!bArr[i])
				sb.append(s.charAt(i));
		}
		boolean[] bArr2=bArr.clone();
		bArr[list.get(num)[0]]=false;
		bArr[list.get(num)[1]]=false;
		set.add(sb.toString());
		sb.setLength(0);
		printer(num+1,bArr2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> ob=new Stack<>();
		Stack<Integer> cb=new Stack<>();
		list=new ArrayList<>();
		s=br.readLine();
		boolean[] bArr=new boolean[s.length()];
		cnt=0;
		for(int i=0;i<s.length();i++) {
			char tmp=s.charAt(i);
			if(tmp=='(') {
				ob.push(i);
				cnt++;
			}else if(tmp==')') {
				cb.push(ob.pop());
				cb.push(i);
			}
			
		}
		for(int i=cnt;i>0;i--) {
			int tmp2=cb.pop();
			int tmp1=cb.pop();
			Integer[] tmp= {tmp1,tmp2};
			list.add(tmp);
		}
		Collections.sort(list,new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0]-o2[0];
			}
		});
		printer(0,bArr);
		List<String> result=new ArrayList<String>();
		for(String st :set) {
			result.add(st);
		}
		Collections.sort(result);
		sb.setLength(0);
		for(String st:result) {
			sb.append(st+"\n");
		}
		System.out.println(sb);
	}
}
