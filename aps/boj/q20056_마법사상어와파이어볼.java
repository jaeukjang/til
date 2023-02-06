import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q20056_마법사상어와파이어볼 {

    /*
        k번 시뮬레이션 돌리면 되는거 아닌가 ? 한번 돌고 여러개 겹친곳만 다시 쏘기

     */
    static int[] dr={-1,-1,0,1,1,1,0,-1};
    static int[] dc={0,1,1,1,0,-1,-1,-1};
    static int N,M,K;
    // r,c,m,s,d  r행 c렬 m질량,s속력,d방향
    static class FireBall {
        int r,c,m,s,d,move;
        //move는 움직인 횟수
        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Stack<FireBall> stk=new Stack<>();
        ArrayList<FireBall>[][] arr=new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=new ArrayList<FireBall>();
            }
        }
        int r,c,m,s,d;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            r=Integer.parseInt(st.nextToken())-1;
            c=Integer.parseInt(st.nextToken())-1;
            m=Integer.parseInt(st.nextToken());
            s=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            stk.add(new FireBall(r,c,m,s,d));
        }
        FireBall now;
        for(int i=0;i<K;i++){
            while(!stk.isEmpty()){//이동하려고 하는것만
                now=stk.pop();
                now.r=now.r+dr[now.d]*now.s;
                now.c=now.c+dc[now.d]*now.s;
                while(now.r<0){
                    now.r+=N;
                }
                while(now.c<0){
                    now.c+=N;
                }
                now.r%=N;
                now.c%=N;
                arr[now.r][now.c].add(now);
            }
            //이제 arr돌면서 Stk에 다시 넣어줘야돼
            int sumOfMass,sumOfSpeed,oddCount,evenCount;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(arr[j][k].size()>1){
                        sumOfMass=0;
                        sumOfSpeed=0;
                        oddCount=0;
                        evenCount=0;
                        for(int l=0;l<arr[j][k].size();l++){
                            sumOfMass+=arr[j][k].get(l).m;
                            sumOfSpeed+=arr[j][k].get(l).s;
                            if(arr[j][k].get(l).d%2==0){
                                evenCount++;
                            }else{
                                oddCount++;
                            }
                        }
                        if((sumOfMass/5)>0){//합쳐진 질량이 5보단 크거나 같아야지.
                            if(oddCount==0||evenCount==0){//모두 홀수나 짝수니까 0,2,4,6
                                for(int t=0;t<=6;t+=2){
                                    stk.add(new FireBall(j,k,sumOfMass/5,sumOfSpeed/arr[j][k].size(),t));
                                }
                            }else {
                                for(int t=1;t<=7;t+=2){
                                    stk.add(new FireBall(j,k,sumOfMass/5,sumOfSpeed/arr[j][k].size(),t));
                                }
                            }
                        }
                    }else if(arr[j][k].size()==1){
                        stk.add(arr[j][k].get(0));
                    }
                    arr[j][k].clear();
                }
            }
        }
        int sum=0;
        while(!stk.isEmpty()){
            sum+=stk.pop().m;

        }
        System.out.println(sum);
    }
}
