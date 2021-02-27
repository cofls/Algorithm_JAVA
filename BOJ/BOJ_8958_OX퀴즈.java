package ssafy_algo_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean cont = false;
		int cnt = 0;
		int result =0;
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T;t++) {
			result = 0;
			cont = false;
			String str = br.readLine();
			for(int s =0; s<str.length();s++) {
				if(str.charAt(s)=='O') {
					if(cont) cnt++;	
					else {
						cont = true;
						cnt=1;
					}	
				}else {
					cont = false;
					continue;
				}
				if(cont) result +=cnt;
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
/*
 * 간단한 코드...
for(int t=0; t<T;t++) {
	result = 0;
	cnt = 0;
	String str = br.readLine();
		
	for(int s =0; s<str.length();s++) {
		if(str.charAt(s)=='O') {
			result += ++cnt;
		}else {
			cnt = 0;
		}
	}
	sb.append(result+"\n");
}
*/
