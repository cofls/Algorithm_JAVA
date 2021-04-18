package princess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N;
	static ArrayList<Integer>[] com;
	static boolean[] check;
	static int cnt =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		com = new ArrayList[N+1];
		check = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			com[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			com[a].add(b);
			com[b].add(a);
		}
		calc(1);
		System.out.println(cnt-1);
	}
	private static void calc(int n) {
		check[n]=true;
		cnt++;
		for(int i=0;i<com[n].size();i++) {
			if(!check[com[n].get(i)]) {
				calc(com[n].get(i));
			}
		}
	}
}
