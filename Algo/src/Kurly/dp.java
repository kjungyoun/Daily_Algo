package Kurly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[b+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		int max = Integer.MIN_VALUE;
		
		for(int i=b; i>0; i--) {
			if(i % 2 == 0) dp[i] = dp[i/2]+1;
			if(i % 2 != 0) dp[i] = dp[(i+1)/3];
		}

	}

}
