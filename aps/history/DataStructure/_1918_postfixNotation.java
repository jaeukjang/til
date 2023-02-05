package DataStructure;

import java.io.*;
import java.util.*;

public class _1918_postfixNotation {
	static int precedence(char c) {
		if(c=='(') {
			return 0;
		}else if(c=='*'||c=='/') {
			return 2;
		}else {
			return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input=br.readLine();
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<input.length();i++) {
			char tmp=input.charAt(i);
			
			if(tmp=='(') {
				stack.push(tmp);
			}else if(tmp==')') {
				while(stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}else if(tmp=='*'||tmp=='/') {
				while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(tmp)) {
					sb.append(stack.pop());
				}
				stack.push(tmp);
			}else if(tmp=='+'||tmp=='-') {
				// 이부분 그냥 위랑 합쳐도 될듯? 아니면 피연산자를 아스키코드로 설정해주고 나머지 else로 처리하던가
				while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(tmp)) {
					sb.append(stack.pop());
				}
				stack.push(tmp);
			}else {
				sb.append(tmp);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
