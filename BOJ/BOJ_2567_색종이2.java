package ssafy_algo_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	       
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[102][102];
		int cnt = 0;
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for(int j=x;j<x+10;j++) {
				for(int i=y; i<y+10;i++) {
					paper[j][i]=1;
				}				
			}
		}
		
		//x축, y축 방향으로 스캔하듯 값의 변화 확인
		//0>1, 1>0으로 바뀌는 경계 순간을 카운트
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(Math.abs(paper[i][j]-paper[i][j+1])==1) cnt++;
				if(Math.abs(paper[j][i]-paper[j+1][i])==1) cnt++;
			}
		}
		System.out.println(cnt);
		br.close();	
	}
}
