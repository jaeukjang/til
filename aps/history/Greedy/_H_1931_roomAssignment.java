package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _H_1931_roomAssignment {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Long[][] arr=new Long[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Long.parseLong(st.nextToken());
			arr[i][1]=Long.parseLong(st.nextToken());
		}
		//sorting 할건데 시작시간 먼저 sorting 그후에 끝나는 시간 sorting
		Arrays.sort(arr,new Comparator<Long[]>() {
			@Override
			public int compare(Long[] o1, Long[] o2) {
				if(o1[0]==o2[0]) {
					if(o1[1]>o2[1]) {
						return 1;
					}else if(o1[1]==o2[1]){
						return 0;
					}else {
						return -1;
					}
				}else {
					if(o1[0]>o2[0]) {
						return 1;
					}else if(o1[0]==o2[0]){
						return 0;
					}else {
						return -1;
					}
				}
			}
		});
		//일단 시작시간 같고 끝나는시간 뒤에꺼는 skip
		List<Long[]> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(i==0) {
				list.add(arr[i]);
				continue;
			}
			if(arr[i][0]==arr[i-1][0]) continue;
			list.add(arr[i]);
		}
		//list에 안겹치게 넣었고
		//이제.. 회의 끝나는 시간순서대로 sorting 한다.
		Collections.sort(list,new Comparator<Long[]>(){
			@Override
			public int compare(Long[] o1, Long[] o2) {
				if(o1[1]>o2[1]) {
					return 1;
				}else if(o1[1]==o2[1]){
					return 0;
				}else {
					return -1;
				}
			}
		});
		int cnt=1;
		long end;
		end=list.get(0)[1];
		//다음 회의시작시간이 전에 회의 끝나는시간과 같거나 크면 cnt추가하고 새로운 끝나는 시간으로 받아줘.
		for(int i=1;i<list.size();i++) {
			if(list.get(i)[0]>=end) {
				cnt++;
				end=list.get(i)[1];
			}
		}
		System.out.println(cnt);
	}
}
