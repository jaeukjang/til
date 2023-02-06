import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q1034_램프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String tmp;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            tmp=br.readLine();
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp));
            }else{
                map.put(tmp,1);
            }
        }
        int K=Integer.parseInt(br.readLine());




    }
}
