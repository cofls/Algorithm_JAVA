package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int N;
	static int[][] team;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		StringTokenizer st;
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				team[n][i]=Integer.parseInt(st.nextToken());
			}
		}
		makeCombination(0, new int[N/2+1], 0);
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void makeCombination(int toSelect, int[] selected, int startIdx) {
		if(toSelect == N/2) {
			int n1 =0;
			int n2 =0;
			int sum1 = 0;
			int sum2 = 0;
			int[] t1 = new int[N/2];
			int[] t2 = new int[N/2];
			for(int i=0;i<N;i++) {
				if(i==selected[n1]) {
					t1[n1++]=i;
				}else {
					t2[n2++]=i;
				}
			}
			for(int i=0; i<N/2; i++){
                for(int j=i+1; j<N/2; j++){
                	sum1+=(team[t1[i]][t1[j]]+team[t1[j]][t1[i]]);
                	sum2+=(team[t2[i]][t2[j]]+team[t2[j]][t2[i]]);
                }
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		for(int i=startIdx; i<N; i++) {
			selected[toSelect]=i;
			makeCombination(toSelect+1, selected, i+1);
		}
	}
}
