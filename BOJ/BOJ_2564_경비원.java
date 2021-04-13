package ssafy_algo_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//절댓값.........주의...!!!
class dot{
	int x, y;
	public dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BOJ_2564_경비원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		dot[] place = new dot[N+1];
		for(int n=0;n<=N;n++) {
			st = new StringTokenizer(br.readLine());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			place[n] = new dot(px,py);
			
			switch(place[n].x) {
			case 1: place[n].x = 0; break;
			case 2: place[n].x = h; break;
			case 3: 
				place[n].x = place[n].y;
				place[n].y = 0;
				break;
			case 4: 
				place[n].x = place[n].y;
				place[n].y = w;
				break;
			}
		}

		dot dong = new dot(place[N].x,place[N].y);

		int total = 2*(w+h);
		int sum=0;
		for(int n=0;n<N;n++) {
			int tmp = 0;
			if(Math.abs(dong.x-place[n].x)==h) {
				tmp=dong.y + place[n].y+h;
			}else if(Math.abs(dong.y-place[n].y)==w) {
				tmp=dong.x + place[n].x+w;
			}else {
				tmp = Math.abs(dong.x-place[n].x)+Math.abs(dong.y-place[n].y);
			}
			sum+=Math.min(tmp, total-tmp);
		}
		System.out.println(sum);
	}
}
