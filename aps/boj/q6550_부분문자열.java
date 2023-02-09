import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;
        String a,b;
        int i,j,al;
        boolean flag;
        while((input = br.readLine()) != null&&!input.isEmpty()){
            st=new StringTokenizer(input);
            a=st.nextToken();
            b=st.nextToken();
            j=0;
            al=a.length();
            flag=false;
            for(i=0;i<b.length();i++){
                if(b.charAt(i)==a.charAt(j)){
                    j++;
                    if(j==al){
                       flag=true;
                       break;
                    }
                }
            }
            if(flag) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.println(sb);

    }
}
