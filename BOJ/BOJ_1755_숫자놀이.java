package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_1755_숫자놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//입력값 받아옴
		String[] num = br.readLine().split(" ");
		int num1 = Integer.parseInt(num[0]);
		int num2 = Integer.parseInt(num[1]);
		
		//두 입력값을 포함한 그 사이값 크기 만큼의 스트링 배열 생성
		String[] input = new String[num2-num1+1];
		
		//두 입력값 사이 숫자들을 매칭되는 문자로 바꾸어 input배열에 넣어주기
		for(int i=0;i<num2-num1+1;i++) {
			StringBuilder sb = new StringBuilder();
			int tmp = num1+i;
			
			while(true) {
				//십의자리 숫자 매칭
				if(tmp>=10) {
					switch(tmp/10) {
					case 1 : sb.append("one"); break;
					case 2 : sb.append("two"); break;
					case 3 : sb.append("three"); break;
					case 4 : sb.append("four"); break;
					case 5 : sb.append("five"); break;
					case 6 : sb.append("six"); break;
					case 7 : sb.append("seven"); break;
					case 8 : sb.append("eight"); break;
					case 9 : sb.append("nine"); break;
					}
					tmp%=10;
				}else {
					//일의자리숫자 매칭
					switch(tmp) {
					case 0 : sb.append("zero"); break;
					case 1 : sb.append("one"); break;
					case 2 : sb.append("two"); break;
					case 3 : sb.append("three"); break;
					case 4 : sb.append("four"); break;
					case 5 : sb.append("five"); break;
					case 6 : sb.append("six"); break;
					case 7 : sb.append("seven"); break;
					case 8 : sb.append("eight"); break;
					case 9 : sb.append("nine"); break;
					}
					break;
				}
			}
			
			input[i]= sb.toString();
		}
		
		//숫자와 해당 매칭 문자열을 같이 넣어주기 위해 hashamp 사용
		HashMap<String,Integer> map = new HashMap<>();
	      
	    for(int i = 0; i < num2-num1+1;i++) {
	    	map.put(input[i], num1+i);
	    }
	      
	    //문자열로 나타낸 숫자들을 알파벳 순에 맞게 정렬
	    Arrays.sort(input);
	    
	    //10개씩 출력하기 위해 cnt사용
	    int cnt =0;
	    for(String s : input) {
	    	if(cnt<9) {
	    		 bw.write(map.get(s)+" ");
	    		 cnt++;
	    	}else if(cnt==9) {
	    		 bw.write(map.get(s)+"\n");
	    		 cnt=0;
	    	}
	     
	    }
	    
	    bw.flush();
	    bw.close();
	    br.close();   
	}
}
