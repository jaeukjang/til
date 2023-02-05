package BruteForce;

import java.io.*;
import java.util.*;

public class _1969_DNA {
	/*
	 * DNA
	 * A C G T
	 * 1.각 문자열의 위치마다 4개의 배열을만들어서 숫자 넣기
	 * 1-1. 숫자 가장큰거를 제외한거를 합하기. 만약 같은게있다면 앞에거부터.
	 * 2.s 출력은 가장큰거를 char배열에넣어서 for문 돌려서 출력
	 * 2-1. min값은 sum 구한거 출력.
	 */
	static int n,m;
	static int sum;
	static char[] ans;
	static int[][] arr;
	static char[] acgt= {'A','C','G','T'};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[m][4];
		ans=new char[m];
		for(int i=0;i<n;i++) {
			String dna=br.readLine();
			for(int j=0;j<m;j++) {
				char tmp=dna.charAt(j);
				for(int k=0;k<4;k++) {
					if(acgt[k]==tmp) {
						arr[j][k]++;
					}
				}
			}
		}
		for(int i=0;i<m;i++) {
			int max=0; int maxIdx=0; int tmpSum=0;
			//max와 maxIdx 찾기
			for(int j=0;j<4;j++) {
				tmpSum+=arr[i][j];
				if(max<arr[i][j]) {
					max=arr[i][j];
					maxIdx=j;
				}
			}
			ans[i]=acgt[maxIdx];
			sum+=tmpSum-max;
		}
		for(int i=0;i<m;i++) {
			sb.append(ans[i]);
		}
		sb.append("\n"+sum);
		System.out.println(sb);
	}
}
