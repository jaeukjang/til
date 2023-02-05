package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21758_honeyPicking {
	public static void main(String[] args) throws IOException {
		//N 10만개 , 각 꿀은 10000이하 자연수 10만 *10000 *2는 20억이므로 int사용
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr=new int[n]; //
		int sum=0;
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		int[] sum2=new int[n];
		System.arraycopy(arr, 0, sum2, 0, arr.length);
		//누적합 반대로
		for(int i=n-1;i>=1;i--) {
			sum2[i-1]+=sum2[i];
		}
		int max=-1;
		for(int i=1;i<n-1;i++) {
			max=Math.max(max, (sum+sum2[i]-arr[0]-(2*arr[i])));
		}
		//예외 1 n이 3이라 꿀통이 가운데
		int max2=-1;
		if(n==3) {
			max2=2*arr[1];
		}
		//예외 2 n이 4인데 1번값이 너무커서 꿀통이 가운데
		int max3=-1;
		if(n==4) {
			max3=2*arr[1]+arr[0];
		}
		//예외 3 n이 4보다큰데 0번값 or 1번값이 너무커서 꿀통이 0번에 있어야할 경우
		int[] sum3=new int[n];
		System.arraycopy(arr, 0, sum3, 0, arr.length);
		//누적합 순서대로
		for(int i=1;i<n;i++) {
			sum3[i]+=sum3[i-1];
		}
		int max4=-1;
		for(int i=1;i<n-1;i++) {
			max4=Math.max(max4, (sum+sum3[i]-arr[n-1]-(2*arr[i])));
		}
		
		
		//진짜진짜 최종 max 구하기
		int realMax=-1;
		realMax=Math.max(max, max2);
		realMax=Math.max(realMax, max3);
		realMax=Math.max(realMax, max4);
		
		System.out.println(realMax);
	}
}
