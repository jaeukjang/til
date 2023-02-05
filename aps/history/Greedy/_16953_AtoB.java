package Greedy;

import java.util.Scanner;

public class _16953_AtoB {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int cnt=1;
		while(true) {
			System.out.printf("b is %d\n",b);
			if(a>b) {
				cnt=-1;
				break;
			}else if(a==b) {
				break;
			}
			if(b%2==0) {
				cnt++;
				b/=2;
				continue;
			}else if(b%10==1) {
				cnt++;
				b/=10;
			}else {
				cnt=-1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
