package Greedy;

import java.io.*;
import java.util.*;

public class _2212_sensor {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//센서갯수 N 1~10000개 ,집중국 갯수 K 1~1000개, 좌표는 절댓값이 100만 이하 정수.
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		Integer[] arr=set.toArray(new Integer[0]);
		Arrays.sort(arr);
		int[] diff=new int[arr.length-1];
		for(int i=1;i<arr.length;i++) {
			diff[i-1]=arr[i]-arr[i-1];
		}
		Arrays.sort(diff);
		int sum=0;
		for(int i=0;i<diff.length-(K-1);i++) {
			sum+=diff[i];
		}
		System.out.println(sum);
	}
}
