package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541_lostBracket {
	public static void main(String[] args) throws IOException {
		//입력은 숫자 + - 세가지 
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int result=0;
		//-가 있을때랑 없을때랑 분리해줘 있다면
		if(s.contains("-")) {
			//이걸 - 기준으로 분리해 
			String[] tmp1=s.split("-");
			
			//처음이면 더할거고 처음이 아니면 다 뺼거야 근데 중간에 +가 있다면 그걸 또 분리해서 더해주기만하면됨
			boolean first=true;
			for(String t: tmp1) {
				int tmp=0;
				if(t.contains("+")) {
					String[] tmp2=t.split("\\+"); // 이부분이 에러 남 그냥 "+"쓰면안되고 escape 해줘야돼... java regex확인할것
					for(String t1:tmp2) {
						tmp+=Integer.parseInt(t1);
					}
				}else {
					tmp+=Integer.parseInt(t);
				}
				
				if(first) {
					first=false;
					result+=tmp;
				}else {
					result-=tmp;
				}
			}
		}else {
			int tmp=0;
			if(s.contains("+")) {
				String[] tmp2=s.split("\\+");
				for(String t1:tmp2) {
					tmp+=Integer.parseInt(t1);
				}
			}else {
				tmp+=Integer.parseInt(s);
			}
			result+=tmp;
		}
		System.out.println(result);
	}
}
