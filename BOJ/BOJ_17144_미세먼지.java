package ssafy_algo_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class fine{
	int r,c,w;
	public fine(int r, int c, int w) {
		this.r=r;
		this.c=c;
		this.w=w;
	}
}
public class BOJ_17144_미세먼지 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};//위, 오, 아, 왼  
	static int[][] dust;
	static int R,C;
	static int machine=0;
	static Queue<fine> dirty = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		dust = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());	
			for(int j=0;j<C;j++) {
				dust[i][j] = Integer.parseInt(st.nextToken());
				if(dust[i][j]==-1) machine = i; //아래 인덱스 저장.
			}
		}
		for(int t=0;t<T;t++) {
			//미세먼지 위치
			find();
			//확산
			//미세먼지가 동시확산, 인접해 있는 미세먼지 어케 처리?>>미세먼지 양도 미리 저장
			diffusion();
			//공기청정기 작동
			move();
			//print();
		}
		//남아있는 미세먼지 양
		int sum =0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=dust[i][j];
			}
		}
		System.out.println(sum+2);//공기청정기 더해주기
	}

	private static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(dust[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void find() {
		dirty.clear();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//공기청정기 아닌 곳, 0이 아닌 곳, 확산 가능한 위치
				if(dust[i][j]>=5) dirty.add(new fine(i,j,dust[i][j]));
			}
		}
	}
	private static void diffusion() {
		while(!dirty.isEmpty()) {
			fine tmp = dirty.poll();
			int cnt = 0;
			for(int d=0;d<4;d++) {
				int nr = tmp.r + dx[d];
				int nc = tmp.c + dy[d];
				if(isRange(nr,nc)&&dust[nr][nc]!=-1) {
					dust[nr][nc] += tmp.w/5;
					cnt++;
				}
			}
			dust[tmp.r][tmp.c]-=(tmp.w/5)*cnt;
		}	
	}
	private static boolean isRange(int x, int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}

	private static void move() {
		//윗부분, 반시계방향
		//아래로
		for(int i=machine-1;i>0;i--) {
			dust[i][0]=dust[i-1][0];
		}
		dust[machine-1][0]=-1;//청정기
		//왼쪽으로
		for(int i=0;i<C-1;i++) {
			dust[0][i]=dust[0][i+1];
		}
		//위로
		for(int i=0;i<machine-1;i++) {
			dust[i][C-1]=dust[i+1][C-1];
		}
		//오른쪽으로
		for(int i=C-1;i>0;i--) {
			dust[machine-1][i]=dust[machine-1][i-1];
		}
		dust[machine-1][1]=0;//정화된 공기
		//시계방향
		//위로
		for(int i=machine;i<R-1;i++) {
			dust[i][0]=dust[i+1][0];
		}
		dust[machine][0]=-1;//청정기
		//왼쪽으로
		for(int i=0;i<C-1;i++) {
			dust[R-1][i]=dust[R-1][i+1];
		}
		//아래로
		for(int i=R-1;i>=machine;i--) {
			dust[i][C-1]=dust[i-1][C-1];
		}	
		//오른쪽으로
		for(int i=C-1;i>0;i--) {
			dust[machine][i]=dust[machine][i-1];//아래 청정기
		}
		dust[machine][1]=0;
	}

}
