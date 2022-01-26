package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_S2_2529_부등호_flag {
	
	static String input[];
	static int k;
	static long min, max;
	static String min_str, max_str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(in.readLine());
		input = new String[k]; // 입력 문자열 길이
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i < k; i++) { // 입력 배열에 저장
			input[i] = st.nextToken();
		}
		
		
		permutation(0,"", 0);
		System.out.println(max_str);
		System.out.println(min_str);

	}
	
	public static void permutation(int cnt, String sb, int flag) {
		if(cnt == k+1) {
			long num = Long.parseLong(sb); // 만든 수 문자열을 int형으로
			
			if(max < num) {
				max = num;
				max_str = sb;
			}
			
			if(min > num) {
				min = num;
				min_str = sb;
			}
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(cnt == 0) { // 첫번째 숫자일 경우
				permutation(cnt+1, sb+i, flag | 1<<i);
			}
			else if((1<<i & flag) !=0) continue; // 이미 사용했을 경우
			else if(input[cnt-1].equals("<")) {
				if(sb.charAt(cnt-1)-'0' < i) {
					permutation(cnt+1, sb+i, flag | 1<<i);
				}else {
					continue;
				}
			}else if(input[cnt-1].equals(">")) {
				if(sb.charAt(cnt-1)-'0' > i) {
					permutation(cnt+1, sb+i, flag | 1<<i);
				}else
					continue;
			}
		}
	}

}
