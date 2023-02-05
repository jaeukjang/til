package DataStructure;
import java.io.*;
import java.util.*;
public class _2504_braceCalculator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		Stack<Character> bStk=new Stack<>();
		Stack<Integer> nStk=new Stack<>();
		Stack<Integer> nStk2=new Stack<>();
		boolean closed=false;
		boolean flag=true;
		int result=0;
		for(int i=0;i<input.length();i++) {
			char tmp=input.charAt(i);
			if(tmp=='('||tmp=='[') {//openBrace는 그냥 넣고 closed만 false해줘
				bStk.add(tmp);
				closed=false;
			}else if(bStk.isEmpty()) {//닫힌 브레이스인데 아무것도 없으면 탈락
				flag=false;
				break;
			}else if(tmp==')'){ // ')' 닫힘일떄
				if(bStk.peek()!='(') { // 닫는 쌍이 안맞으면 탈락
					flag=false;
					break;
				}else { // 그외에 연산
					bStk.pop();
					if(bStk.isEmpty()) {
						if(closed) {
							int sum=0;
							while(!nStk.isEmpty())
								sum+=nStk.pop();
							nStk2.add(2*sum);
						}else {
							nStk2.add(2);
						}
					}else {
						if(closed) {
							nStk.add(nStk.pop()*2);
						}else {
							nStk.add(2);
						}
					}
					closed=true;
				}
			}else { // ']' 닫힘일때
				if(bStk.peek()!='[') {
					flag=false;
					break;
				}else {
					bStk.pop();
					if(bStk.isEmpty()) {
						if(closed) {
							int sum=0;
							while(!nStk.isEmpty())
								sum+=nStk.pop();
							nStk2.add(3*sum);
						}else {
							nStk2.add(3);
						}
					}else {
						if(closed) {
							nStk.add(nStk.pop()*3);
						}else {
							nStk.add(3);
						}
					}
					closed=true;
				}
			}
		}
		while(!nStk2.isEmpty())
			result+=nStk2.pop();
		
		if(!flag) {
			result=0;
		}
		System.out.println(result);
	}
}


