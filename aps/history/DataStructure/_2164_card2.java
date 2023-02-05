package DataStructure;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _2164_card2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		Queue<Integer> q=new ConcurrentLinkedQueue<>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		int cnt=0;
		while(cnt!=n-1) {
			q.poll();
			cnt++;
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}
}
