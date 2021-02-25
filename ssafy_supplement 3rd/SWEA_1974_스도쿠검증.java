package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//HashSet 사용하면 중복 알아서 제거
//그래서 모두 넣고 사이즈가 9가 아니면 오류있는 것.
public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T;t++) {
			
			int[][] sudoku = new int[9][9];
			int check = 1;

			for(int i=0; i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sum =0;
				for(int j=0; j<9;j++) {
					sudoku[i][j]= Integer.parseInt(st.nextToken());					
					//행검사
					sum+=sudoku[i][j];
				}
				if(sum != 45)
					check = 0;
			}
			
			//열검사
			for(int r=0;r<9;r++) {
				int sum = 0;
				for(int c=0;c<9;c++) {
					sum+=sudoku[c][r];
				}
				if(sum != 45)
					check = 0;
			}
			
			//9칸 검사
			for(int i = 0; i < 9; i+=3) {
				for(int j = 0; j < 9; j+=3) {
					int sum = 0;
					for(int k = i; k < i+3; k++) {
						for(int s = j; s < j+3; s++) {
							sum += sudoku[k][s];
						}
					}
					if(sum != 45)
						check = 0;
				}
			}
			sb.append("#"+(t+1)+" "+check+"\n");
		}
		System.out.println(sb);
	}
}