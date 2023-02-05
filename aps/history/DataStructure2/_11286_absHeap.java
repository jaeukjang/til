package DataStructure2;

import java.io.*;
import java.util.*;

public class _11286_absHeap {
	static int[] arr;
	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		arr=new int[n+1];
		for(int i=0;i<n;i++) {
			int tmp=Integer.parseInt(br.readLine());
			if(tmp==0) {
				sb.append(remove()).append("\n");
			}else {
				add(tmp);
			}
		}
		System.out.println(sb);
	}
	static void add(int n) {
        arr[++size] = n;
        int cur = size;
        while (cur > 1 &&( Math.abs(arr[cur]) < Math.abs(arr[cur / 2]) || Math.abs(arr[cur]) == Math.abs(arr[cur / 2])&&(arr[cur]<arr[cur / 2]))) {
        	//부모보다 절댓값이 작거나 같고 만약 같다면 그냥 작을때까지 그리고 바꿀게
            int tmp = arr[cur];
            arr[cur] = arr[cur / 2];
            arr[cur / 2] = tmp;
            cur /= 2;
        }
    }

    static int remove() {
        if (size == 0)
            return 0;
        int n = arr[1];
        arr[1] = arr[size];
        arr[size] = 0;
        int cur = 1;
        while ((cur * 2) < size) {//왼쪽 노드도 없으면 종료할거야
            int absMin = Math.abs(arr[cur * 2]);
            int min = arr[cur*2];
            int minPos = cur * 2;
            if ((cur * 2 + 1) < size) {//오른쪽 노드가 있다면 비교할게
                if (absMin > Math.abs(arr[cur * 2 + 1])||( absMin==Math.abs(arr[cur*2+1]) && min>arr[cur*2+1])) {
                    absMin = Math.abs(arr[cur * 2 + 1]);
                    min=arr[cur*2+1];
                    minPos = cur * 2 + 1;
                }
            }
            if (Math.abs(arr[cur]) < absMin ||(Math.abs(arr[cur]) == absMin && arr[cur]<min)) {//내현재값의 절댓값이 작거나 같은데 작으면
                break;
            }
            int tmp = arr[cur]; //아니라면  swap
            arr[cur] = arr[minPos];
            arr[minPos] = tmp;
            cur = minPos;
        }
        size--;
        return n;
    }
}
