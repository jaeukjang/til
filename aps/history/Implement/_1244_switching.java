package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244_switching {
	static int change(int n) {
		if (n==1) return 0;
		else return 1;
	}
	static int[] swit(int[] arr, int gender, int num) {
		//남자는 배수 만큼 바꾸기
		if(gender==1) {
			for(int i=0;i<arr.length;i++) {
				if((i+1)%num==0) {
					arr[i]=change(arr[i]);
				}
			}
		//여자는 그 번호를 포함한 대칭범위 바꾸기
		}else {
			int target=num-1;
			arr[target]=change(arr[target]);
			for(int i=1;i<arr.length/2;i++) {
				//범위 넘어가면 끝내
				if(target-i<0 || target+i>=arr.length) break;
				//대칭이면 바꾸고 대칭 아니면 끝내
				if(arr[target-i]==arr[target+i]) {
					arr[target-i]=change(arr[target-i]);
					arr[target+i]=change(arr[target+i]);
				}else {
					break;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//입력
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int t=Integer.parseInt(br.readLine());
		//입력받으면서 연산
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			System.arraycopy(swit(arr,gender,num), 0, arr, 0, arr.length);
		}
		
		//출력
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+" ");
			if((i+1)%20==0)
				sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
