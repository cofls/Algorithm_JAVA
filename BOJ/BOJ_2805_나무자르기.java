package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		  
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int N = Integer.parseInt(st.nextToken());
	      int M = Integer.parseInt(st.nextToken());
	      long sum=0;
	      
	      int[] tree = new int[N];
	      st = new StringTokenizer(br.readLine());
	      for(int i=0;i<N;i++) {
	    	  tree[i]=Integer.parseInt(st.nextToken());
	      }
	      Arrays.sort(tree);
        
	      int min = 1;
	      int max = tree[N-1];
	      int mid = 0;
	      
	      while(min<=max) {
	    	  sum=0;
	    	  mid = (min+max)/2;
	    	  for(int i=0;i<N;i++) {
	  			if(sum>M) break;
	  			if(tree[i]>mid) {
	  				sum+=(tree[i]-mid);
	  			}
	  		  }
	    	  
	    	  if(sum>=M) {
	  			min = mid+1;
	  		  }else {
	  			max = mid-1;
	  		  }
	      }
	      //System.out.println(max);
	      bw.write(String.valueOf(max));
	      
	      bw.flush();
	      bw.close();
	      br.close();
	}
}