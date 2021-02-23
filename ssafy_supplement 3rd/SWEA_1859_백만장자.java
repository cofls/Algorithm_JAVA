package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자{
	static int max;
	static int idx = 0;
	static int[] p;
	static int N;
	static long result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0;t<T;t++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			p = new int[N];

			st = new StringTokenizer(br.readLine());

			for(int n=0; n<N;n++) {
				p[n]= Integer.parseInt(st.nextToken());

			}
			max = p[N-1];
			
			//뒤에서부터 값을 비교하는 것이 포인트
			//값을 비교하면서 기준 max값보다 작으면 차이값을 더하고
			//기준max값보다 크다면 값 갱신
			for(int i=N-2;i>=0;i--) {
				if(max>p[i])
					result += max-p[i];
				else 
					max = Math.max(max, p[i]);
			}

			sb.append("#"+(t+1)+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
}
