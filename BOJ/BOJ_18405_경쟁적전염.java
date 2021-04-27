package ssafy_algo_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Spot implements Comparable<Spot>{
	int x,y,num;
	public Spot(int x, int y,int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
	
	@Override
	public int compareTo(Spot o) {
		return this.num-o.num;
	}
}
public class BOJ_18405_경쟁적전염 {
	static int[][] virus;
	static boolean[][] check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,S;
	static Queue<Spot> q= new LinkedList<>();
	static PriorityQueue<Spot> pq= new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		virus = new int[N][N];
		check = new boolean[N][N];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<N;m++) {
				virus[n][m] = Integer.parseInt(st.nextToken());
				if(virus[n][m]!=0) {
					check[n][m] = true;
					pq.add(new Spot(n,m,virus[n][m]));
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int s = pq.size();
		for(int i=0;i<s;i++) {
			Spot tmp = pq.poll();
			q.add(new Spot(tmp.x,tmp.y,tmp.num));

		}
		bfs();
		System.out.println(virus[X-1][Y-1]);
	}

	private static void bfs() {
		while(!q.isEmpty()&&S-->0) {
			int size = q.size();
			for(int j=0;j<size;j++) {
				Spot tmp = q.poll();
				for(int i=0;i<4;i++) {
					int nx = tmp.x+dx[i];
					int ny = tmp.y+dy[i];
					if(isRange(nx,ny)&&!check[nx][ny]) {
						virus[nx][ny] = tmp.num;
						check[nx][ny] = true;
						q.add(new Spot(nx,ny,tmp.num));
					}
				}
			}
			
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx>=0&&nx<N&&ny>=0&&ny<N;
	}
}
