package DataStructure;
import java.io.*;
import java.util.*;
public class _H_2504_braceCalculator2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		Stack<Character> stack=new Stack<>();
		int result=0; int val=1;
		for(int i=0;i<input.length();i++) {
			char tmp=input.charAt(i);
			if(tmp=='(') {
				stack.push(tmp);
				val*=2;
			}else if(tmp=='[') {
				stack.push(tmp);
				val*=3;
			}else if(tmp==')') {
				if(stack.isEmpty()||!(stack.peek()=='(')) {
					result=0;
					break;
				}else if(input.charAt(i-1)=='(') {
					result+=val;
				}
				val/=2;
				stack.pop();
			}else {
				if(stack.isEmpty()||!(stack.peek()=='[')) {
					result=0;
					break;
				}else if(input.charAt(i-1)=='[') {
					result+=val;
				}
				val/=3;
				stack.pop();
			}
		}
		if(!stack.isEmpty()) result=0;
		System.out.println(result);
		//패배다..
	}
}


