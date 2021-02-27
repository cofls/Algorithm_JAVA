package ssafy_algo_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> tmp = new ArrayList<>();
		boolean open = false;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='<') {
				open = true;
				Collections.reverse(tmp);
				for(Character a : tmp) {
					sb.append(a);
				}
				sb.append("<");
				tmp.clear();
				continue;
			}else if(str.charAt(i)=='>') {
				open = false;
				sb.append(str.charAt(i));
				continue;
			}
			if(open)
				sb.append(str.charAt(i));
			else {
				if(str.charAt(i)==' ') {
					Collections.reverse(tmp);
					for(Character a : tmp) {
						sb.append(a);
					}
					sb.append(" ");
					tmp.clear();
				}else {
					tmp.add(str.charAt(i));
					if(i==str.length()-1) {
						Collections.reverse(tmp);
						for(Character a : tmp) {
							sb.append(a);
						}
						tmp.clear();
					}
				}
			}
		}
		System.out.println(sb);
		br.close();	
	}
}
