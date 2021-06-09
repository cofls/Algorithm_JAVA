package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질1 {
	static int[] arr = new int[100001];
	static int K;
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
		arr[n] = 0;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0;i<3;i++) {
				int next;
				if(i==0) next = tmp+1;
				else if(i==1) next = tmp-1;
				else next = tmp*2;
			
				if(next>=0 && next<100001 && arr[next]==0) {
					q.add(next);
					arr[next]=arr[tmp]+1;//1초 움직임
					
					if(next==K) {
						System.out.println(arr[K]);
						return;
					}
				}
			}
		}
	}
}
