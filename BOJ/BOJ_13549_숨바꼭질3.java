package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	static int[] arr = new int[100001];
	static int K;
	static int min; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println("0");
			return;
		}else {
			move(N);
		}
	}
	private static void move(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		Arrays.fill(arr, -1);
		arr[n] = 0;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tmp==K) {
				System.out.println(arr[K]);
				return;
			}
			int idx = tmp*2;
			while(idx<=100000&&arr[idx]<0) {
				arr[idx] = arr[tmp];
				q.add(idx);
				idx*=2;//계속 2배는 순간이동가능하니까ㄱㄱ
			}
			
			for(int i=0;i<2;i++) {
				int next;
				if(i==0) next = tmp-1;
				else next = tmp+1;
				
				if(next>=0 && next<100001 &&(arr[next]<0)) {
					q.add(next);
					arr[next]=arr[tmp]+1;
				}
			}
		}
	}
}
