package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_G4_1915_가장큰정사각형 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = Integer.MIN_VALUE;
		
		int dp[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				int input = line.charAt(j)-'0'; // 해당 선분 입력
				if(i<1 || j<1) {
					dp[i][j] = input; // i=0 이거나 j=0 이면 input 값 그대로 저장
				}else{
					if(input == 1) { // 해당 선분이 사각형이 되기 위한 조건 만족 시 왼쪽위, 오른쪽위, 왼쪽아래 선분에서 최소값+1 저장
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					}else
						dp[i][j] = 0;
				}
				answer = Math.max(dp[i][j], answer);
			}
		}
		
		System.out.println(answer*answer);

	}

}
