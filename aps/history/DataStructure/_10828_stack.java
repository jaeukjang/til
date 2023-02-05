package DataStructure;

import java.io.*;
import java.util.*;

public class _10828_stack {
	static int[] stack=new int[10000];
	static int top=-1;
	static int size=0;
	public static void push(int data) {
		stack[++top]=data;
		size++;
	}
	public static int pop() {
		if(top==-1) {
			return -1;
		}else {
			size--;
			return stack[top--];
		}
	}
	public static int empty() {
		if(top>=0) {
			return 0;
		}else {
			return 1;
		}
	}
	public static int mTop() {
		if(top==-1) {
			return -1;
		}else {
			return stack[top];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String command=st.nextToken();
			if(command.equals("push")) {
				int data=Integer.parseInt(st.nextToken());
				push(data);
			}else if(command.equals("pop")) {
				System.out.println(pop());
			}else if(command.equals("size")) {
				System.out.println(size);
			}else if(command.equals("empty")) {
				System.out.println(empty());
			}else if(command.equals("top")) {
				System.out.println(mTop());
			}
		}
	}
}
