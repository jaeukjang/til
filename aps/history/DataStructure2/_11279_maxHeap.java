package DataStructure2;

import java.io.*;
import java.util.*;

public class _11279_maxHeap {
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
        while (cur > 1 && arr[cur] > arr[cur / 2]) {
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
            int max = arr[cur * 2];
            int maxPos = cur * 2;
            if ((cur * 2 + 1) < size) {//오른쪽 노드가 있다면 비교할게
                if (max < arr[cur * 2 + 1]) {
                    max = arr[cur * 2 + 1];
                    maxPos = cur * 2 + 1;
                }
            }
            if (arr[cur] >= max) {//내현재값이 크면 끝내~
                break;
            }
            int tmp = arr[cur]; //아니라면  swap
            arr[cur] = arr[maxPos];
            arr[maxPos] = tmp;
            cur = maxPos;
        }
        size--;
        return n;
    }
}
