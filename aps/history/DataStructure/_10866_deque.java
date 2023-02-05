package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10866_deque {
	public static int[] deque = new int[20000];
	public static int front = 10001, back = 10000;
	public static int size = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String command=st.nextToken();
			if(command.equals("push_front")) {
				int data=Integer.parseInt(st.nextToken());
				push_front(data);
			}else if(command.equals("push_back")) {
				int data=Integer.parseInt(st.nextToken());
				push_back(data);
			}else if(command.equals("pop_front")) {
				sb.append(pop_front()+"\n");
			}else if(command.equals("pop_back")) {
				sb.append(pop_back()+"\n");
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
	public static void push_front(int data) {
		//: 정수 X를 덱의 앞에 넣는다.
		deque[--front]=data;
		size++;
	}
	public static void push_back(int data) {
		//: 정수 X를 덱의 뒤에 넣는다.
		deque[++back]=data;
		size++;
	}
	public static int pop_front() {
		//: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(size==0) {
			return -1;
		}else {
			size--;
			return deque[front++];
		}
	}
	public static int pop_back() {
		//: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(size==0) {
			return -1;
		}else {
			size--;
			return deque[back--];
		}
	}
	public static int size() {
		//: 덱에 들어있는 정수의 개수를 출력한다.
		return size;
	}
	public static int empty() {
		//: 덱이 비어있으면 1을, 아니면 0을 출력한다.
		if(size==0)
			return 1;
		else
			return 0;
	}
	public static int front() {
		//: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(size==0)
			return -1;
		else
			return deque[front];
	}
	public static int back() {
		//: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(size==0)
			return -1;
		else
			return deque[back];
	}
}
