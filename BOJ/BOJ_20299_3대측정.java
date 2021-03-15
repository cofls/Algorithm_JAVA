package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class person{
	int x1;
	int x2;
	int x3;
	public person(int x1, int x2, int x3) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
	}
}
public class BOJ_20299_3대측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());
			int sum = one+two+three;
			if(one>=L&&two>=L&&three>=L&&sum>=K) {
				cnt++;
				sb.append(one+" "+two+" "+three+" ");
			}
		}	
		bw.write(String.valueOf(cnt)+"\n"+sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
