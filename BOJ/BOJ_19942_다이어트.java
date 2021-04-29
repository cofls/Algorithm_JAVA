package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_19942_다이어트 {
	static int N;
	static int mp,mf,ms,mv;
	static int[][] item;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->o1[1] - o2[1]);
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		item = new int[N][5];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<5;i++){
				item[n][i]=Integer.parseInt(st.nextToken());
			}
		}
		
		generateSubset(1<<N);
		
		ArrayList<String> al = new ArrayList<>();
		if(!pq.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			int[] arr = pq.poll();
			int total = arr[1];
			for(int j=0;j<N;j++) {
				if((arr[0]&1<<j)!=0) {
					sb.append((j+1)+" ");
				}
			}
			al.add(sb.toString());
			//같은게  또 있을 경우 고려
			if(!pq.isEmpty()) {
				int[] narr = pq.poll();
				if(total == narr[1]) {
					do {
						sb = new StringBuilder();
						for(int j=0;j<N;j++) {
							if((narr[0]&1<<j)!=0) {
								sb.append((j+1)+" ");
							}
						}
						al.add(sb.toString());
						if(!pq.isEmpty()) {//더 있는 경우 검사
							narr = pq.poll();
						}else break;
					}while(total == narr[1]);
				}
			}
			Collections.sort(al);
			bw.write(String.valueOf(arr[1])+"\n");
			bw.write(al.get(0));
		}else
			bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void generateSubset(int caseCount) {
		for(int flag=0;flag<caseCount;flag++) {//비트마스크되어 있는 수
			int tp=0,tf=0,ts=0,tv=0,tc=0;
			for(int j=0;j<N;j++) {
				if((flag&1<<j)!=0) {
					tp += item[j][0];
					tf += item[j][1];
					ts += item[j][2];
					tv += item[j][3];
					tc += item[j][4];
				}
				
			}
			if(tp>=mp&&tf>=mf&&ts>=ms&&tv>=mv) {
				int[] tmp = {flag,tc};
				pq.add(tmp);
			}

		}
	}
}
