package DataStructure;

import java.io.*;
import java.util.*;

class Balloon{
	int idx;
	int num;
	public Balloon(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}
public class _2346_poppingBalloons {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());//풍선개수 1~1000
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Balloon> list=new LinkedList<>();
		int cnt=1;
		for(int i=0;i<n;i++) {
			list.add(new Balloon(cnt++,Integer.parseInt(st.nextToken())));
		}
		int idx=0;int cnt2=0;
		while(true) {
			Balloon tmp=list.remove(idx);
			sb.append(tmp.idx).append(" ");
//			System.out.println("sb is : "+sb);
			if(tmp.num>0) {
				idx+=tmp.num-1;
			}else {
				idx+=tmp.num;
			}
			cnt2++;
			if(cnt2==n) {
				break;
			}
			if(idx>=0) {
				while( idx >= list.size() )
					idx -= list.size();
			}else {
				while( idx<0 )
					idx += list.size();
			}
		}
		System.out.println(sb);
	}
}
