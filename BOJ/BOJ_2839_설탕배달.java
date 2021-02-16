package ssafy_algo_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result=0;
		int three=0;
		while(N>=0) {
			if(N%5==0) {
				result += N/5;
				System.out.println(result+three);
				return;
			}else {
				N-=3;
				three++;
			}
		}
		System.out.println("-1");
	
	}
}	
