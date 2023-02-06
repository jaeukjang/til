import java.io.BufferedReader;
import java.util.Scanner;
import java.util.function.BiFunction;

public class q_chinoshock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        char[] emoji=input.toCharArray();
        int ans=emoji.length+2;
        for(int i=1;i<emoji.length-1;i++){
            if(emoji[i]=='_'){
                ans+=5;
            }
        }
        System.out.println(ans);
    }
}
