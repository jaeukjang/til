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

public class _H_1931_roomAssignment2 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Long[][] arr=new Long[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Long.parseLong(st.nextToken());
			arr[i][1]=Long.parseLong(st.nextToken());
		}
		//sorting 할건데 끝나는 시간먼저 sorting 후 그다음 시작시간 sorting
		Arrays.sort(arr,new Comparator<Long[]>() {
			@Override
			public int compare(Long[] o1, Long[] o2) {
				if(o1[1]==o2[1]) {
					if(o1[0]>o2[0]) {
						return 1;
					}else if(o1[0]==o2[0]){
						return 0;
					}else {
						return -1;
					}
				}else {
					if(o1[1]>o2[1]) {
						return 1;
					}else if(o1[1]==o2[1]){
						return 0;
					}else {
						return -1;
					}
				}
			}
		});
		int cnt=1;
		long end=arr[0][1];
		for(int i=1;i<arr.length;i++) {
			if(end<=arr[i][0]) {
				end=arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
