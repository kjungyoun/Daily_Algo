package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_S1_11057_오르막수_success {
	static int dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dp[][] = new int[n+1][10];
		
		// dp 배열 초기화
		for(int i=0; i<10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<10; j++) {
				for(int k=j; k<10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum%10007);
	}

}
