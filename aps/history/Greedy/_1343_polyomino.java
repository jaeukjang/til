package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1343_polyomino {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		s=s.replace("XXXX","AAAA");
		s=s.replace("XX","BB");
		if(s.contains("X"))
			bw.write(-1+"\n");
		else
			bw.write(s);
		
		bw.flush();
		bw.close();
	}
}
