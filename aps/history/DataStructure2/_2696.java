package DataStructure2;

import java.io.*;
import java.util.*;

public class _2696 {
	static int[] arr;
	static int[] ans;
	//내림차순큐 오름차순 큐를 받아서 두개 사이즈합한게 n+1개이게 관리하면 되는거 아닌가? >> 둘다 peek mid값이게 하고싶었거든요?
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			int m=Integer.parseInt(br.readLine());
			arr=new int[m];
			int cnt=0;
			//숫자 입력받기... 10개씩  끊어서 까다롭네
			for(int i=0;i<m/10;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<10;j++) {
					arr[cnt++]=Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m%10;i++) {
				arr[cnt++]=Integer.parseInt(st.nextToken());
			}
			
			//ans 만들고 연산
			ans=new int[m/2+1];
			sb.append(m/2+1).append("\n");
			
			PriorityQueue<Integer> minQ =new PriorityQueue<>();
			PriorityQueue<Integer> maxQ =new PriorityQueue<>(Collections.reverseOrder());
			int mid=arr[0];
			minQ.add(arr[0]);
			maxQ.add(arr[0]);
			ans[0]=arr[0];
			for(int i=1;i<m;i++) {
				minQ.add(arr[i]);
				maxQ.add(arr[i]);
				if(i%2==0) {
					minQ.poll();
					maxQ.poll();
					if(mid>arr[i-1]&&mid>arr[i]) {
						mid=maxQ.peek();
						minQ.poll();
						minQ.add(mid);
					}else if(mid<arr[i-1]&&mid<arr[i]){
						mid=minQ.peek();
						maxQ.poll();
						maxQ.add(mid);
					}else {
						mid=maxQ.peek();
					}
					ans[i/2]=mid;
				}
			}
			
			//출력부
			cnt=0;
			for(int i=0;i<ans.length/10;i++) {
				for(int j=0;j<10;j++) {
					sb.append(ans[cnt++]+" ");
				}
				sb.append("\n");
			}
			for(int i=0;i<ans.length%10;i++) {
				sb.append(ans[cnt++]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
