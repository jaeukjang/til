package DataStructure;

import java.io.*;
import java.util.*;

public class _22942_dataChecker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		Set<Integer> set=new HashSet<>();
		Map<Integer, Integer> map= new HashMap<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			set.add(x-r);
			set.add(x+r);
			map.put(x-r, x+r);
		}
		String ans="YES";
		if(set.size()!=n*2) {
			ans="NO";
		}else {
			Integer[] arr=set.toArray(new Integer[0]);
			Arrays.sort(arr);
			Stack<Integer> stk=new Stack<>();
			for(int i=0;i<2*n;i++) {
				int tmp=arr[i];
				if(map.containsKey(tmp)) {
					stk.push(tmp);
				}else {
					if(map.get(stk.pop())!=tmp) {
						ans="NO";
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
