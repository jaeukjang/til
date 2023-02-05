package GraphTraversal;

	import java.io.*;
	import java.util.*;
	
	public class _2606_Virus {
		/*
		 * 바이러스
		 * 1.1번 을 첫 정점으로 cnt ++ 출력
		 * 2.DFS 사용
		 */
		static int n,k,cnt;
		static boolean[][] arr;
		static boolean[] visited;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			n=Integer.parseInt(br.readLine());
			k=Integer.parseInt(br.readLine());
			arr=new boolean[n+1][n+1];
			visited=new boolean[n+1];
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				arr[from][to]=arr[to][from]=true;
			}
			
			dfs(1);
			System.out.println(cnt);
		}
		private static void dfs(int from) {
			
			visited[from]=true;
			
			for(int i=1;i<=n;i++) {
				if(arr[from][i]&&!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
		}
	}
