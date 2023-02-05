package Greedy;

import java.io.*;
import java.util.*;

public class _1461_Library {
	/*
	 * 도서관
	 * 1.우선 정렬하고 양수 먼거 부터 채워나가기
	 * 2.그다음 음수 먼부분 채워나가기
	 * 3.1,2 반복
	 * 
	 */
	static int n,m;
	static List<Integer> minus=new ArrayList<>();
	static List<Integer> plus=new ArrayList<>();
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int mCnt=0;
		int pCnt=0;
		for(int i=0;i<n;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			min=Math.min(min, tmp);
			max=Math.max(max, tmp);
			if(tmp>0) {
				plus.add(tmp);
				pCnt++;
			}else {
				minus.add(tmp);
				mCnt++;
			}
		}
		//plus는 내림차순
		//minus는 오름차순
		//양수 큰값의 절댓값이 더 크다면 마지막을 여기로
		Collections.sort(plus,Collections.reverseOrder());
		Collections.sort(minus);
		int ans=0;
		if(mCnt==0) {
//			System.out.println("1");
			int cnt=0;
			while(cnt!=(n-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans+=plus.get(0);
				}else {
					ans+=2*plus.get(pick);
				}
				cnt++;
			}
		}else if(pCnt==0) {
//			System.out.println("2");
			int cnt=0;
			while(cnt!=(n-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans-=minus.get(0);
				}else {
					ans-=2*minus.get(pick);
				}
				cnt++;
			}
		}else if(Math.abs(min)>Math.abs(max)) {
//			System.out.println("3");
			int cnt=0;
			while(cnt!=(mCnt-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans-=minus.get(0);
				}else {
					if(pick<mCnt-1) {
						ans-=2*minus.get(pick);
					}else {
						ans-=2*minus.get(mCnt-1);
					}
				}
				cnt++;
			}
			cnt=0;
			while(cnt!=(pCnt-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans+=2*plus.get(0);
				}else {
					if(pick<pCnt-1) {
						ans+=2*plus.get(pick);
					}else {
						ans+=2*plus.get(pCnt-1);
					}
				}
				cnt++;
			}
		}else {
//			System.out.println("4");
			int cnt=0;
			while(cnt!=(pCnt-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans+=plus.get(0);
				}else {
					if(pick<pCnt-1) {
						ans+=2*plus.get(pick);
					}else {
						ans+=2*plus.get(pCnt-1);
					}
				}
				cnt++;
			}
			cnt=0;
			while(cnt!=(mCnt-1)/m+1) {
				int pick=m*cnt;
				if(cnt==0) {
					ans-=2*minus.get(0);
				}else {
					if(pick<mCnt-1) {
						ans-=2*minus.get(pick);
					}else {
						ans-=2*minus.get(mCnt-1);
					}
				}
				cnt++;
			}
		}
		
		
		System.out.println(ans);
			
		
	}
}
