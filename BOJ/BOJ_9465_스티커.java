package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://fbtmdwhd33.tistory.com/76
public class BOJ_9465_스티커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N+1];
			int[][] dp = new int[2][N+1];
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int n=1;n<=N;n++) {
					sticker[i][n]= Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1]= sticker[0][1];
			dp[1][1]= sticker[1][1];

			for(int i=2;i<=N;i++) {
				dp[0][i]=Math.max(dp[1][i-1], dp[1][i-2])+sticker[0][i];
				dp[1][i]=Math.max(dp[0][i-1], dp[0][i-2])+sticker[1][i];
			}
			sb.append(Math.max(dp[0][N], dp[1][N])+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
