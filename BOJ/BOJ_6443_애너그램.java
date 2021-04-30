package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_6443_애너그램 {
	static int N;
	static ArrayList<String> arr;
	static char[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int n=0;n<num;n++) {
			arr= new ArrayList<>();
			input = br.readLine().toCharArray();
			Arrays.sort(input);
			N = input.length;
			do {
				arr.add(String.copyValueOf(input));
			}while(np());
			
			Collections.sort(arr);
			
			for(String s: arr) {
				bw.write(s+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
		private static boolean np() {

		int i=N-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		
		if(i==0) return false;
		
		int j=N-1;
		while(input[i-1]>=input[j])	--j;
		
		swap(i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(i++,k--);			
		}
		return true;
	}
	
	private static void swap(int i,int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}