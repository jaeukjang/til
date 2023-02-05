package Greedy;

import java.io.*;
import java.util.*;

public class _H_1092_ship {
	public static void main(String[] args) throws IOException {
		//크레인은 50개보다 작거나 같고 박스는 10000개보다 작거나 같음. 크레인과 박스의 무게는 100만보다 작거나 같아
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] crane=new Integer[N];
		for(int i=0;i<N;i++) {
			crane[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane,Collections.reverseOrder());
		
		int M=Integer.parseInt(br.readLine());
		List<Integer> box=new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box,Collections.reverseOrder());
		int result=0;
		boolean flag=true;
		if(box.get(0)>crane[0]) {
			result=-1;
			flag=false;
		}
		while(flag) {
			int bi=0;
			for(int i=0;i<N;) {
				if(bi==box.size()) {
					break;
				}else if(box.get(bi)<=crane[i]) {
					box.remove(bi);
					i++;
				}else {
					bi++;
				}
			}
			result++;
			if(box.isEmpty()) {
				break;
			}
		}
		System.out.println(result);
		
	}
}
