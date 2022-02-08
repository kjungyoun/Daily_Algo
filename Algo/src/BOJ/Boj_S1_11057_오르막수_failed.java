package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_S1_11057_오르막수_failed {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dp[][] = new int[n+1][10];
		
		// dp 배열 초기화
		for(int i=0; i<10; i++) {
			dp[1][i] = i+1;
		}
		
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<10; j++) {
				if(j==0)
					dp[i][j] = dp[i-1][9];
				else {
					dp[i][j] = (dp[i][j-1] + (dp[i][0] - dp[i-1][j-1]))%10007;
				}
			}
		}
		
		System.out.println(dp[n][9]%10007);
		
		

	}

}
