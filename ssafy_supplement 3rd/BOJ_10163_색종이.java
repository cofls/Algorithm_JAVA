package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	       
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[101][101];
		int[] cnt = new int[N+1];
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); //가로
			int h = Integer.parseInt(st.nextToken()); //세로

			for(int j=x;j<w+x;j++) {
				for(int i=y; i<h+y;i++) {
					paper[j][i]=n+1;
				}				
			}
			
		}
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				cnt[paper[i][j]]++;
			}
		}
		for(int i=1;i<=N;i++) {
			sb.append(cnt[i]+"\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
