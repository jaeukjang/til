package DataStructure2;

import java.io.*;
import java.util.*;

public class _4358_ecology {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String,Integer> map=new HashMap<>();
		List<String> list=new ArrayList<>();
		String tmp;
		int cnt=0;
		while((tmp=br.readLine())!=null&&!tmp.isEmpty()) {
			if(!map.containsKey(tmp)) {
				map.put(tmp, 1);
				list.add(tmp);
			}else {
				map.put(tmp,map.get(tmp)+1);
			}
			cnt++;
		}
		
		Collections.sort(list);
		for(String s: list) {
			sb.append(s+" ").append(String.format("%.4f", (double)(map.get(s)*100)/cnt)).append("\n");
		}
		System.out.println(sb);
		
	}
}
