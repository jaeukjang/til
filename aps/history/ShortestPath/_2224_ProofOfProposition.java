package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2224_ProofOfProposition {
	/*
	 * 명제증명
	 * 1.플로이드 워셜로 생각하자 경유지 거쳐서 갈 수 있으면 다 갱신해버리고.
	 * 2.boolean 인접행렬로 만들어버리고 어쩌피 정점이 총 52개이긴한데 걍 메모리 별로 안먹으니까 0부터122까지 123개 만들어버리자.
	 * 3.ascii값과 소문자 대문자 변환이 좀 귀찮을 것 같아..
	 */
	static boolean[][] edge=new boolean[123][123];
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println((int)'a');
//		System.out.println((int)'A');
//		System.out.println((int)'z');
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		String tmp;
		int a,b;
		for(int i=0;i<n;i++) {
			tmp=br.readLine();
			a=(int)tmp.charAt(0);
			b=(int)tmp.charAt(5);
			edge[a][b]=true;
		}
		for(int k=65;k<=122;k++) {
			for(int i=65;i<=122;i++) {
				for(int j=65;j<=122;j++) {
					if(edge[i][k]&&edge[k][j]) edge[i][j]=true;
				}
			}
		}
		int cnt=0;
		for(int i=65;i<=122;i++) {
			for(int j=65;j<=122;j++) {
				if(edge[i][j]&&i!=j) {
					sb.append((char)i+" => "+(char)j+"\n");
					cnt++;
				}
			}
		}
		sb.insert(0,cnt+"\n");
		System.out.println(sb);
		
	}
	
}
