import java.util.Scanner;

public class q1052_물병 {
    /**
     *   물병
     *   n<=10^7, k<=1000 n,k는 자연수
     *   흠... 이거 어려운데 뭐지
     *   13 2 가 3인게 이해가 잘 안가
     *   115808은 ?
     *   2^n으로 구성된 숫자를 k개 이하로 만들면 되는거잖아?
     *   그리디 하게 풀어야되는건가 아니면 dfs로 풀어야하나...
     *   2^24 = 1677만 7216 으로 n=천만 k=1인 극한의 상황에서 답이 677만7216이 되버림 답이 없는 -1을 출력하는 상황이 존재 할 수 가 없잖아
     *   n보다 크면서 2^x1+2^x2+2^xk 의 합이 가장 작은걸 구하면돼
     *   how to?
     *   그냥 돌면 되는건가? 최대 677만7216번 돌면되잖아!!!
     *   이게 결국 k개 로 만들 수 있는 최적의 수를 구하는거라 거기에서 k에서 힌트가 있을것 같은데...
     *
     *   18 2 그냥 가져가면 되잖아 .? 작은거부터 무조건 아하.
     */
    static int n,k,min,max;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        int tmp=n;
        int sum=0;
        while(true){
            k--;
            if(tmp<=0) break;
            if(k==0){
                for(int i=0;i<=24;i++){
                    if(tmp<=(1<<i)){
                        sum+=(1<<i);
                        break;
                    }
                }
                break;
            }else {
                for (int i = 0; i <= 24; i++) {
                    if (tmp == (1 << i)) {
                        tmp -= (1 << i);
                        sum += (1 << i);
                        break;
                    } else if (tmp < (1 << i)) {
                        tmp -= (1 << (i - 1));
                        sum += (1 << (i - 1));
                        break;
                    }
                }
            }
        }
        System.out.println(sum-n);
    }
}
