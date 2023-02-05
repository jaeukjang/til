import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2156_포도주시식 {
    /*
        포도주시식
        3잔을 연속으로 마실순 없는데 최대로 많이 먹고싶다.
        dp로 접근하면 될 것 같은데?
        두개중에 비교해야지 2번째 전꺼 vs 그전꺼+나
     */
    static int n;
    static int[] arr;
    static int[] dp; //무조건 자기를 넣는것
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        dp=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            if(i==0){
                dp[i]=arr[i];
            }else if(i==1){
                dp[i]=dp[i-1]+arr[i];
            }else if(i==2){
                dp[i]=Math.max(dp[i-2],arr[i-1])+arr[i];
            }else if(i==3){
                //전전꺼 건너뛰기 vs 전꺼 건너뛰기
                dp[i]=Math.max(dp[i-3]+arr[i-1],dp[i-2])+arr[i];
            }else {
                //전전,전 건너뛰기
                dp[i]=Math.max(Math.max(dp[i-3]+arr[i-1],dp[i-2]),dp[i-4]+arr[i-1])+arr[i];
            }
        }
        int ans;
        if(n==1){
            ans=arr[0];
        }else if(n==2){
            ans=arr[0]+arr[1];
        }else{
            ans=Math.max(dp[n-1],dp[n-2]);
        }
        System.out.println(ans);
    }
}