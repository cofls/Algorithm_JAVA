package fifth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int p;
	int d;
	public Node(int p, int d) {
		super();
		this.p = p;
		this.d = d;
	}
}
public class SWEA_1238 {
	static ArrayList<Integer>[] call;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=0;t<10;t++) {
			//초기화
			call = new ArrayList[101];
			for(int i=1;i<101;i++) {
				call[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N/2;n++) {
				int s =  Integer.parseInt(st.nextToken());
				int d =  Integer.parseInt(st.nextToken());
				
				call[s].add(d);
			}

			sb.append("#"+(t+1)+" "+find(start)+"\n");			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static int find(int start) {
		boolean[] visited = new boolean[101];
		Queue<Node> next = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		int maxN[] = new int[101];
		
		next.add(new Node(start,1));
		visited[start]=true;
		
		while(!next.isEmpty()) {
			int n = next.peek().p;
			int dep = next.poll().d;
			int len = call[n].size();
			
			if(max==dep) {
				maxN[max]=Math.max(maxN[max], n);
			}
			
			for(int l =0; l<len;l++) {
				Node tmp = new Node(call[n].get(l),dep+1);
				if(!visited[tmp.p]) {
					next.add(new Node(tmp.p,tmp.d));
					visited[tmp.p]=true;
					max = Math.max(dep+1, max);
				}
			}
		}
		return maxN[max];
	}
}
