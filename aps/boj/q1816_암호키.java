import java.util.ArrayList;
import java.util.Scanner;

public class q1816_암호키 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int limit = 1000001;

        boolean[] prime=new boolean[limit];
        prime[0] = prime[1] = true;
        ArrayList<Integer> primes=new ArrayList<>();
        for(int i=2; i*i<limit; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<limit; j+=i) prime[j] = true;
            }
        }

        // 소수 출력
        for(int i=2; i<limit;i++){
            if(!prime[i]) primes.add(i);
        }


        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            long num=sc.nextLong();
            boolean isKey=true;
            for(int j=0;j<primes.size();j++){
                if(num%primes.get(j)==0){
                    isKey=false;
                    break;
                }
            }
            if(isKey) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
