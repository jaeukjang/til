package DataStructure;

import java.util.*;

public class _2164_card2_again {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		boolean beforeOdd=false;
		while(list.size()!=1) {
			int size=list.size();
			if(!beforeOdd) {
				if(size%2==0)
					beforeOdd=false;
				else
					beforeOdd=true;
				for(int i=size-1;i>=0;i--) {
					if(i%2==0)
						list.remove(i);	
				}
			}else {
				if(size%2==0)
					beforeOdd=false;
				else
					beforeOdd=true;
				for(int i=size-1;i>=0;i--) {
					if(i%2!=0)
						list.remove(i);	
				}
			}
		}
		System.out.println(list.peek());
	}
}
