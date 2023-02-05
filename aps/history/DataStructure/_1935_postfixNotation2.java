package DataStructure;

import java.io.*;
import java.util.*;

public class _1935_postfixNotation2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		double[] arr=new double[n];
		//후위표기식 받아주고
		String input=br.readLine();
		//피연산자에 해당하는 숫자 받아주고
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Stack<Double> stack=new Stack<>();
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='+') {
				double tmp=stack.pop()+stack.pop();
				stack.add(tmp);
			}else if(input.charAt(i)=='-') {
				double tmp=-(stack.pop()-stack.pop());
				stack.add(tmp);
			}else if(input.charAt(i)=='*') {
				double tmp=stack.pop()*stack.pop();
				stack.add(tmp);
			}else if(input.charAt(i)=='/') {
				double a=stack.pop();
				double b=stack.pop();
				double tmp=b/a;
				stack.add(tmp);
			}else {
				stack.add(arr[(int)input.charAt(i)-'A']);
			}
		}
		System.out.printf("%.2f",stack.pop());
		
	}
}
