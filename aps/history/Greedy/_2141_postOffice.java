package Greedy;

import java.io.*;
import java.util.*;

class Village{
	int loca;
	int pnum;
	public Village(int loca, int pnum) {
		this.loca = loca;
		this.pnum = pnum;
	}
}

public class _2141_postOffice {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<Village> list=new ArrayList<>();
		StringTokenizer st = null;
		long sum=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int loca=Integer.parseInt(st.nextToken());
			int pnum=Integer.parseInt(st.nextToken());
			sum+=pnum;
			list.add(new Village(loca,pnum));
		}
		Collections.sort(list,new Comparator<Village>() {
			@Override
			public int compare(Village o1, Village o2) {
				return o1.loca-o2.loca;
			}
		});
		int result=-1;
		long sum2=0;
		for(Village v : list) {
			sum2+=v.pnum;
			if((double)sum/sum2<=2) {
				result=v.loca;
				break;
			}
		}
		System.out.println(result);
	}
}
