package swea;

import java.io.*;
import java.util.*;

public class SWEA_1949_등산로조성 {
	static int[][] map;
	static boolean[][] visited;
	static int N, K;
	static int cnt=0;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};//위, 오, 아래, 왼
	static boolean one = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			cnt=0;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int x=0;x<N;x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0;y<N;y++) {
					map[x][y]=Integer.parseInt(st.nextToken());
					max = Math.max(map[x][y], max);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==max) {
						one = false;
						find(max, i,j,1);
					}
				}
			}
			sb.append("#"+(t+1)+" "+cnt+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void find(int tmp, int ni, int nj,int c) {
		visited[ni][nj]=true;
		cnt = Math.max(cnt, c);
		
		for(int d=0;d<4;d++) {
			int nextX = ni+dx[d];
			int nextY = nj+dy[d];
			if(isRange(nextX,nextY)&&!visited[nextX][nextY]) {
				if(map[nextX][nextY]<tmp) {
					find(map[nextX][nextY],nextX,nextY,c+1);
				}else if(map[nextX][nextY]-tmp<=K-1&&!one) {
					one = true;
					//K-=(map[nextX][nextY]-tmp+1);
					find(tmp-1,nextX,nextY,c+1);
					//K+=(map[nextX][nextY]-tmp+1);
					one = false;
				}else continue;
			}
		}
		visited[ni][nj]=false;
	}
	
	private static boolean isRange(int x, int y) {
		return x>=0 &&x<N &&y>=0&&y<N;
	}
}
