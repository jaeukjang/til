package DataStructure;

import java.io.*;
import java.util.*;

public class _18258_queue2 {
	public static int[] queue = new int[2000000];
	public static int front = 0, back = -1;
	public static int size = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String command=st.nextToken();
			if(command.equals("push")) {
				int data=Integer.parseInt(st.nextToken());
				push(data);
			}else if(command.equals("pop")) {
				sb.append(pop()+"\n");
			}else if(command.equals("size")) {
				sb.append(size+"\n");
			}else if(command.equals("empty")) {
				sb.append(empty()+"\n");
			}else if(command.equals("front")) {
				sb.append(front()+"\n");
			}else if(command.equals("back")) {
				sb.append(back()+"\n");
			}
		}
		System.out.println(sb);
	}

	public static void push(int data) {
		queue[++back]=data;
		size++;
	}
	public static int pop() {
		if(size==0) {
			return -1;
		}else {
			size--;
			return queue[front++];
		}
	}
	public static int empty() {
		if(size==0)
			return 1;
		else
			return 0;
	}
	public static int front() {
		if(size==0)
			return -1;
		else
			return queue[front];
	}
	public static int back() {
		if(size==0)
			return -1;
		else
			return queue[back];
	}
	
}
