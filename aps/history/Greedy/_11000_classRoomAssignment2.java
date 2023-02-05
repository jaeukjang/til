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

public class _11000_classRoomAssignment2 {
	//Array 에서 List로 옮겨감
	public static void main(String[] args) throws IOException {
		//N이 20만개 끝나는시간과 시작시간이 10억이하라 int 사용해도 될듯.
		//회의실 배정과 비슷한데... 거기서 이제 처리안한 것들을 다시 처리하기..? 남지 않을때까지
		//20만개 sorting하는건 Arrays.sort 사용해도 될듯
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//입력
		int n=Integer.parseInt(br.readLine());
		List<Integer[]> list=new ArrayList<>();//0번 1번은 입력 2번은 cnt해주자. 나중에 cnt==0인 애들만 다시 check하면 될듯
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			Integer[] arr=new Integer[3];
			arr[0]=Integer.parseInt(st.nextToken());
			arr[1]=Integer.parseInt(st.nextToken());
			arr[2]=0;
			list.add(arr);
		}
		//끝나는시간 기준으로 먼저 정렬 후 xx 걍 메모리
		//카운팅 정렬해줄까? 메모리 넉넉하니까...
		Collections.sort(list,new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0]==o2[0]? o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		int end=list.get(0)[1];
		int result=1; int cnt=1; list.get(0)[2]=1;
		while(cnt<n) {
			for(int i=0;i<n;i++) {
				if(end<=list.get(i)[0]&&list.get(i)[2]==0) {
					end=list.get(i)[1];
					list.get(i)[2]++;
					cnt++;
				}
			}
			//다음 end를 찾아줘야 되는데...
			for(int i=0;i<n;i++) {
				if(list.get(i)[2]==0) {
					end=list.get(i)[1];
					list.get(i)[2]++;
					cnt++;
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
