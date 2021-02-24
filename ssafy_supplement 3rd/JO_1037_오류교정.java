package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_1037_오류교정 {
	static int[][] parity;
	static ArrayList<Integer> row = new ArrayList<>();
	static ArrayList<Integer> col = new ArrayList<>();
	static boolean pR = true;
	static boolean pC = true;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		parity = new int[N][N];
		
		int sum = 0;
		for(int n=0; n<N;n++) {
			sum = 0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				parity[n][j]= Integer.parseInt(st.nextToken());			
				sum+=parity[n][j];
			}
			if(sum%2!=0) {
				pR = false;
				row.add(n+1);
			}
		}
		
		check();
		
	}
	private static void check() {
		int sum =0;
		for(int n=0;n<N;n++) {
			sum=0;
			for(int j=0;j<N;j++) {
				sum+=parity[j][n];
			}
			if(sum%2!=0) {
				pC = false;
				col.add(n+1);
			}
		}
		
		if(pC==true && pR==true) {
			System.out.println("OK");
			return;
		}
		if(pC==false && pR==false &&row.size()==1 && col.size()==1) {
			System.out.println("Change bit ("+ row.get(0)+","+col.get(0)+")");
			return;
		}else {
			System.out.println("Corrupt");
			return;
		}
	}
}
