package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); //참외 갯수
		StringTokenizer st;
		int[] len = new int[6];
		
		int max = Integer.MIN_VALUE;
		int tmp= 0;
		for(int i=0; i<6;i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			len[i]= Integer.parseInt(st.nextToken());
			if(max<len[i]) {
				max = len[i];
				tmp = i;
			}
		}
		
		//경계값처리
		int idx = tmp-1<0?5:tmp-1;
		int idx2 = tmp+1>5?0:tmp+1;
		
		int area = 0;
		if(len[idx]>len[idx2]) {
			area = len[tmp]*len[idx];
			area -= (len[(idx+3)%6])*(len[(idx+4)%6]);
		}else {
			area = len[tmp]*len[idx2];
			area -= (len[(idx2+2)%6])*(len[(idx2+3)%6]);
		}
		System.out.println(area*K);
	}
}	
