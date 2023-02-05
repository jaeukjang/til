package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1268_temporaryClassPresident {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//입력
		int t=Integer.parseInt(br.readLine());
		int [][] arr=new int[t][7]; // 0 : idx / 1 2 3 4 5 : 반 / 6 : cnt
		for(int i=0;i<t;i++) {
			arr[i][0]=i; //idx 넣어주기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=5;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//
		for(int i=0;i<t;i++) {
			for(int j=0;j<t;j++) {
				if(arr[i][1]==arr[j][1]||arr[i][2]==arr[j][2]||arr[i][3]==arr[j][3]||arr[i][4]==arr[j][4]||arr[i][5]==arr[j][5]) {
					arr[i][6]++; //i j 같을떄도 cnt 추가되긴하는데 어쩌피 다들어가니까 걍 무시~
				}
			}
		}
		Arrays.sort(arr,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[6]-o1[6];	//내림차순 하고싶어.
			}
		});
		System.out.println(arr[0][0]+1);//idx에 1을 더해줘야 번호가 나와
	}
}
