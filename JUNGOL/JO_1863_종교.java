package etc;

import java.io.*;
import java.util.*;

public class JO_1863_종교 {
	    static int N;
	    static int parents[];
	     
	    static void make() {// 크기가 1인 단위집합을 만든다.
	        for (int i = 1; i <= N; i++) {
	            parents[i] = i;
	        }
	    }
	     
	    static int findSet(int a) {//a 포함하는 집합 찾기, 대표자
	        if(parents[a]==a) return a; 
	        return parents[a] = findSet(parents[a]);
	    }
	     
	    static boolean union(int a,int b) {//랭크와 path압축 같이하는 코드는 어려움 > 없음
	        int aRoot = findSet(a);
	        int bRoot = findSet(b);
	        if(aRoot == bRoot) return false; //이미 같은 조직, 합치지 x
	         
	        parents[bRoot] = aRoot;
	        return true;
	    }
	     
	    public static void main(String[] args) throws IOException {
	 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	         
	        N = Integer.parseInt(st.nextToken()); // 사람 수
	        int M = Integer.parseInt(st.nextToken()); // 쌍의 수
	         
	        parents = new int[N+1];
	         
	        make();
	         
	        for(int m=0; m<M;m++ ) {
	            st = new StringTokenizer(br.readLine());
	             
	            union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	             
	        }
	        
	        //루트 갯수 세기
	        int cnt =0;
	        for(int m=1; m<=N;m++ ) {
	            if(parents[m]==m)
	            	cnt++;
	        }
	        System.out.println(cnt);
	    }
}