package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _14916_change {
	static int change(int n) {
		if(n==1||n==3)
			return -1;
		int cnt=0;
		int result=0;
		while(true) {
			int tmp=n-5*cnt; //일단 n에다가 5를 뺄지말지
			int tmp2=n%5+5*cnt; // 뺏다면 이제 2를 나눌때 다시 더해줘야지
			if(tmp2%2!=0) { //아니네? cnt 늘리고 다시! 근데 사실 cnt 최댓값은 1이야.
				cnt++;
				continue;
			}
			return tmp/5+tmp2/2; //아 이제 다돌렸네? return해
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//입력
		int n=Integer.parseInt(br.readLine());
		//출력 &연산
		bw.write(change(n)+"\n");
		bw.flush();
		bw.close();
	}
}
