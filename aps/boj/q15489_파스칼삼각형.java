import java.math.BigInteger;
import java.util.Scanner;

public class q15489_파스칼삼각형 {


    /**
     * 파스칼 삼각형
     * 조합을 반복하면 되지않을까
     * rCc 를 시작으로 r+1Cc ~ 쭈루룩 다 구해서 더하면 되는거아닌가?
     * */
    static int r,c,w; //r번째줄 c번째부터 w변의 길이를 갖는 삼각형

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt()-1;
        c=sc.nextInt()-1;
        w=sc.nextInt();
        BigInteger sum=BigInteger.ZERO;
        BigInteger tmp;
        //r이 0일때 어케하더라..
        for(int i=0;i<w;i++){
            for(int j=0;j<=i;j++){
                tmp=num(r+i,c+j);
                sum=sum.add(tmp);
            }
        }
        System.out.println(sum);
    }

    private static BigInteger num(int n, int m) {
        BigInteger a,b,c,result;
        a=fact(n);
        b=fact(m);
        c=fact(n-m);
        result=a.divide(b).divide(c);
        return result;
    }

    static BigInteger fact(int a) {
        BigInteger num= BigInteger.ONE;
        for(int i=2;i<=a;i++) {
            num=num.multiply(BigInteger.valueOf(i));
        }
        return num;
    }
}
