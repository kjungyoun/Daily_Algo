package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_G4_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()); // 도시 개수
		int m = Integer.parseInt(in.readLine()); // 버스 개수
		int D[][] = new int[n+1][n+1];
		final int max = Integer.MAX_VALUE>>1;
		
		for(int i=0; i<n+1; i++) {
			Arrays.fill(D[i], max);
		}
		
		// 입력 저장
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			D[start][end] = Math.min(D[start][end], weight);
		}
		
		// 플로이드-워샬
		for(int mid=1; mid<n+1; mid++) {
			for(int start=1; start<n+1; start++) {
				for(int end=1; end<n+1; end++) {
					D[start][end] = Math.min(D[start][end], D[start][mid]+D[mid][end]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(D[i][j]>=max || i==j)
					sb.append(0+" ");
				else
					sb.append(D[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
