package GraphTraversal;

import java.io.*;
import java.util.*;

public class _9466_TermProject {
	/*
	 * 텀 프로젝트
	 * 1.숫자고르기 2668 문제와 비슷하다. 싸이클을 돌 수 있는 경우는 지워버리고 싸이클을 못도는 쩌리들 cnt
	 * 2.갯수가 하도 많아서 끝도없이 갈 거 같으니... 좀 잘라야 되는데 어떻게하지?
	 * 3.우선 1부터 시작해서 지워버리지 않은것들 중 queue에 넣어 cycle을 만들면 queue에서 꺼내어 지우거나  cycle을 못만드는 경우에는 그 숫자만 지우고 cnt+1
	 * 4.또는 참조하는게 이미 지워버린거면 그것도 지우면서 cnt+1
	 * 5.근데 만약 cycle 이룰애들이 true가 안된상태면.? 어케하지
	 * 
	 * --- 시간초과 해결방법
	 * 1.눈치 없이 끼어든 숫자일 경우 다 check해주면서 cycle이 아니었던 숫자만 cnt++
	 * 2.눈치 없이 끼어들다 이미 싸이클인 경우를 발견했을 경우 이제까지 왔던 경로 전부다 check해주고 갯수만큼 cnt++
	 * 
	 */
	static int cnt;
	static int n;
	
	static int[] arr;
	static boolean[] check;
	
	static Queue<Integer> q=new ArrayDeque<>();
	static Set<Integer> set=new HashSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			cnt=0;
			n=Integer.parseInt(br.readLine());
			arr=new int[n+1];
			check=new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(i==arr[i]) {//혼자 팀인 애들 미리 넣어둬.
					check[i]=true;
				}
			}
			for(int i=1;i<=n;i++) {
				if(!check[i]) {
					set.clear();
					q.clear();
					dfs(i,i);
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int num,int start) {
		if(!q.isEmpty()&&num==start) {//시작도 아닌데 start와 같아지면 cycle이네
			while(!q.isEmpty()) {
				check[q.poll()]=true;
			}
			return;
		}
		if(set.contains(num)) {//넣기전에 내가있으면 눈치없이 cycle에 낀수야 내가.
			//start를 포함해서 check해줘 cnt추가하고.
			//이부분이 잘못됐구나 눈치없는건 나만아니고 다른애도 눈치없을수도 있어...
			//😊수정부
			boolean flag=true;
			while(!q.isEmpty()) {
				int tmp=q.poll();
				if(num==tmp) flag=false; //여기서부터 싸이클이야!
				if(flag) {
					cnt++;
				}
				check[tmp]=true;
			}
			return;
		}
		q.add(num);//q에 넣자.
		set.add(num);
		int target=arr[num];//그다음 수 
		if(check[target]) {//실패가능성 미리 확인
			//😊수정부 시간초과
			while(!q.isEmpty()) {
				check[q.poll()]=true;
				cnt++;
			}
			return;
		}
		dfs(target,start);
	}
}
