import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class q2257_화학식량 {
    /*
        스택써서 해결하면 되는건가 ? 괄호 열릴때마다 닫힐때까지 넣어서 더하기
        어케하더라..?
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input=sc.next();
        //H는 1 C 12 O 16
        Stack<Integer> num=new Stack<>();
        char c;
        int tmp,sum;
        for(int i=0;i<input.length();i++){
            c=input.charAt(i);
            if(c=='('){
                num.add(0);
            }else if(c=='H'){
                num.add(1);
            }else if(c=='C'){
                num.add(12);
            }else if(c=='O'){
                num.add(16);
            }else if(c==')'){//다 더해주기
                sum=0;
                while(true){
                    tmp=num.pop();
                    if(tmp==0){
                        num.add(sum);
                        break;
                    }else{
                        sum+=tmp;
                    }
                }
            }else{//숫자일때
                num.add(num.pop()*(c-'0'));
            }
        }
        int ans=0;
        while(!num.isEmpty()){
            ans+=num.pop();
        }
        System.out.println(ans);

    }
}
