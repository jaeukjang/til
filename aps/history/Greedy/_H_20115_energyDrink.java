package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;


public class _H_20115_energyDrink {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long sum=0;
		//그냥 이걸 long 으로 하는게 중요했구나.
		int max=-1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			max=Math.max(max, tmp);
			sum+=tmp;
		}
		double result=0;
		result+=max+(double)(sum-max)/2;
		System.out.println(result);
	}
}
