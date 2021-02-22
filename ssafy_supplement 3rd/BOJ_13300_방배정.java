package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] state = new int[7][2];
		int N = Integer.parseInt(st.nextToken()); //학생 수
		int K = Integer.parseInt(st.nextToken()); //최대 인원수
		
		for(int n =0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			state[Y][S]++;
		}
		
		int cnt =0;
		for(int i=1;i<=6;i++) {
			for(int j=0;j<=1;j++) {
				cnt +=  state[i][j]/K;
				if(state[i][j]%K!=0)cnt++;
			}
		}
		System.out.println(cnt);
	}
}
