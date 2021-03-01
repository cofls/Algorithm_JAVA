package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO_1205_조커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int zero =0;
		for(int n=0; n<N;n++) {
			arr[n]=Integer.parseInt(st.nextToken());
			if(arr[n]==0)zero++; 
		}
		Arrays.sort(arr);
		if(N==zero) {
			System.out.println(N);
			return;
		}
		
		int result = 0, gap = 0;
		for(int b=zero;b<N;b++) {
			int cnt =1;
			int Z = zero;
			for(int a=b;a<N-1;a++) {
				gap = arr[a+1]-arr[a];
			if(gap==1) {
				cnt++;
				continue;
			}else if(gap>1){
				if(gap-1>Z) {
					cnt+=Z;
					Z=0;
					break;
				}else {
					cnt +=gap;
					Z -= gap-1;
				}
			}
			// gap==0인 경우 : 같은 수 이므로 아무런 처리하지 않음.
			}
			cnt+=Z; //남은 조커의 수 더해줌
			result = Math.max(result, cnt);
		}	
		System.out.println(result);
	}
}
