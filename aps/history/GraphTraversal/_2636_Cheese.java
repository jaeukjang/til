package GraphTraversal;

import java.io.*;
import java.util.*;

public class _2636_Cheese {
	/*
	 * 치즈
	 * 1.치즈를 애초에 받을때 -1로 받아오기.
	 * 2.bfs로 풀면서 녹인치즈는 day에 넣고 방문처리
	 * 3.새로만난 구멍은 방문처리해주고 day 갱신
	 * 
	 */
	static class Status{
		boolean isCheese;
		boolean visited;
		int day=-1;
		public Status(boolean isCheese) {
			this.isCheese = isCheese;
		}
		
	}
	static int h,w;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static Status[][] pan;
	static Deque<int[]> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		pan=new Status[h][w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				pan[i][j]=new Status(tmp==1?true:false);
			}
		}
		bfsForSurrounding();//바깥에 전부 day를 0으로 먼저 처리해줌.
		bfs();
		int max=0;
		int maxCnt=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(pan[i][j].isCheese) {
					if(max<pan[i][j].day) {
						max=pan[i][j].day;
						maxCnt=1;
					}
					else if(max==pan[i][j].day) {
						maxCnt++;
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(maxCnt);
	}
	private static void bfsForSurrounding() {
		Queue<int[]> q2=new ArrayDeque<>();
		q2.offer(new int[] {0,0});
		pan[0][0].day=0;
		while(!q2.isEmpty()) {
			int r=q2.peek()[0];
			int c=q2.poll()[1];
			
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				if(pan[nr][nc].day==-1&&!pan[nr][nc].isCheese) {
					q2.add(new int[] {nr,nc});
					pan[nr][nc].day=0;
				}else if(!pan[r][c].visited&&pan[nr][nc].isCheese) {
					pan[r][c].visited=true;
					q.add(new int[] {r,c});
				}
				
			}
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int r=q.peek()[0];
			int c=q.poll()[1];
			
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=h||nc>=w) continue;
				if(!pan[nr][nc].visited) {
					if(pan[nr][nc].day==-1&&pan[nr][nc].isCheese) {
						q.add(new int[] {nr,nc});
						pan[nr][nc].day=pan[r][c].day+1;
					}else if(pan[nr][nc].day==-1&&!pan[nr][nc].isCheese) {
						q.addFirst(new int[] {nr,nc});
						pan[nr][nc].day=pan[r][c].day;
					}
					pan[nr][nc].visited=true;
				}
				
			}
		}
		
	}
}
