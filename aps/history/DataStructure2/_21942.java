package DataStructure2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class _21942 {
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	static long rptom(String rp) {
		rp=rp.replace("/", "");
		rp=rp.replace(":", "");
		int p=Integer.parseInt(rp);
		long sum=0;
		sum+=(p/10000)*24*60;
		p%=10000;
		sum+=(p/100)*60;
		sum+=p%100;
		return sum;
	}
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<String,Long> map=new TreeMap<>();
		TreeMap<String,Long> ans=new TreeMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String rp =st.nextToken();
		long p=rptom(rp);
		int f=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append(" ").append(st.nextToken());
			String tmpDate=sb.toString();
			sb.setLength(0);
			sb.append(st.nextToken()).append(" ").append(st.nextToken());
			String user=sb.toString();
			sb.setLength(0);
			Date date=new Date();
			date=format.parse(tmpDate);
			long min=date.getTime()/60000;
			if(!map.containsKey(user)) {
				map.put(user, min+p);
			}else {
				if(map.get(user)<min) {
					String[] tmp=user.split(" ");
					ans.put(tmp[1], ans.getOrDefault(tmp[1], (long)0)+(min-map.get(user))*f);
				}
				map.remove(user);
			}
		}
		
		//출력부
		if(ans.isEmpty()) {
			sb.append("-1");
		}else {
			for(String key:ans.keySet()) {
				sb.append(key+" "+ans.get(key)+"\n");
			}
		}
		System.out.println(sb);
	}
}
