package BackTracking;

import java.io.*;
import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class _14888_InsertOperator {
	//연산자 끼워넣기
	/*
	 * 1. 브루트포스로 식 만들기
	 * 	1-1. visited 써서 안 넣었으면 배열에 추가
	 * 2. 계산해서 min max값 찾기
	 * 	2-1. 어떻게 할까 템플릿 리터럴은 안되고, 후위표기식은 아닌거 같은데 if문?
	 * 	2-2. 띠용 자바스크립트 불러서 하면되네?
	 * 3. N이 11이하니까 최대 10! 어쩌피 360만개라 그냥 ㄱ
	 */
	
	static int n;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	
	static int[] arr;
	static char[] opers;
	static char[] ansOpers;
	static boolean[] visited;
	static ScriptEngineManager s=new ScriptEngineManager();
	static ScriptEngine engine=s.getEngineByName("JavaScript");
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException, ScriptException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//		int num=(int)engine.eval(str);
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr=new int[n];
		opers=new char[n-1];
		ansOpers=new char[n-1];
		visited=new boolean[n-1];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		char[] oper= {'+','-','*','/'};
		int cnt=0;
		for(int i=0;i<4;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			for(int j=0;j<tmp;j++) {
				opers[cnt++]=oper[i];
			}
		}
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int depth) throws ScriptException {
		if(depth==n-1) {
			int num=arr[0];
			for(int i=0;i<n-1;i++) {
				switch(ansOpers[i]) {
				case '+':
					num+=arr[i+1];
					break;
				case '-':
					num-=arr[i+1];
					break;
				case '*':
					num*=arr[i+1];
					break;
				case '/':
					num/=arr[i+1];
					break;
				}
			}
			if(num>max) {
				max=num;
			}
			if(num<min) {
				min=num;
			}
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				ansOpers[depth]=opers[i];
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}
