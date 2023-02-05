package GraphTraversal;

import java.io.*;
import java.util.*;

public class _5547_Illumination{
	/*
	 * 일루미네이션
	 * 1. 총 6가지 방향을 이용한 단지세기 문제랑 비슷해.
	 * 2. 숫자를 더하는 것은 내 주변 0인 갯수 로 더하면 되잖아?
	 * 3. 근데 가운데 텅비어있는거 빼는게 어렵네... ㅜㅜ
	 * 
	 */
	static int[] dr= {-1,-1,1,1,0,0};
	static int[] dc1= {0,1,0,1,-1,1}; // 홀수번째줄
	static int[] dc2= {-1,0,-1,0,-1,1}; // 짝수번째줄
	static int w,h;
	static boolean[] map;
	static boolean[] visited;
	
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		map=new boolean[h*w];
		visited=new boolean[h*w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i*w+j] = (Integer.parseInt(st.nextToken())==1? true : false);
			}
		}
		
		for(int i=0;i<h*w;i++) {//외곽에 있는 0과 이어진 것들 다 빼주기
			int r=i/w;
			int c=i%w;
			if(r==0 ||r==h-1||c==0||c==w-1) {
				if(!map[i]&&!visited[i]) {
					bfs2(i);
				}
			}
		}
		for(int i=0;i<h*w;i++) {//외곽에 있는 0과 이어진 것들 다 빼주기
			int r=i/w;
			int c=i%w;
			if(r==0 ||r==h-1||c==0||c==w-1) continue;
			if(!map[i]&&!visited[i]) {
				bfs3(i);
			}
		}
		
		
		for(int i=0;i<h*w;i++) {//가운데 구멍 인경우 빼주기
		}
		
		for(int i=0;i<h*w;i++) {
			if(map[i]&&!visited[i]) {
				bfs(i);
			}
		}
		System.out.println(sum);
	}
	private static void bfs3(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			sum-=check(cur);
			int r=cur/w;
			int c=cur%w;
			for(int i=0;i<6;i++) {
				int nr=r+dr[i];
				int nc=c+((r%2==0)?dc1[i]:dc2[i]);
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				int tmp=nr*w+nc;
				if(!map[tmp]&&!visited[tmp]) {
					q.offer(tmp);
					visited[tmp]=true;
				}
			}
		}
	}
	private static void bfs2(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			int r=cur/w;
			int c=cur%w;
			for(int i=0;i<6;i++) {
				int nr=r+dr[i];
				int nc=c+((r%2==0)?dc1[i]:dc2[i]);
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				int tmp=nr*w+nc;
				if(!map[tmp]&&!visited[tmp]) {
					q.offer(tmp);
					visited[tmp]=true;
				}
			}
		}
	}
	private static void bfs(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int cur=q.poll();
			sum+=6-check(cur);
			int r=cur/w;
			int c=cur%w;
			for(int i=0;i<6;i++) {
				int nr=r+dr[i];
				int nc=c+((r%2==0)?dc1[i]:dc2[i]);
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				int tmp=nr*w+nc;
				if(map[tmp]&&!visited[tmp]) {
					q.offer(tmp);
					visited[tmp]=true;
				}
			}
		}
		
	}
	
	private static int check(int idx) {//주변이 1이면 올라감
		int r=idx/w;
		int c=idx%w;
		int cnt=0;
		for(int i=0;i<6;i++) {
			int nr=r+dr[i];
			int nc=c+((r%2==0)?dc1[i]:dc2[i]);
			if(nr<0||nc<0||nr>=h||nc>=w) continue;
			if(map[nr*w+nc]) cnt++;
		}
		return cnt;
	}
	
}