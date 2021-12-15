import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_S3_11659_구간합4 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(in.readLine());
		StringBuilder sb  = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N+1]; // N개의 숫자 저장 배열
		int sum[] = new int[N+1]; // 누적합 저장 배열
		
		// N개의 숫자 입력
		st = new StringTokenizer(in.readLine());
		for(int i=1; i < N+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+num[i];
		}
		
		// M번 출력
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(in.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(sum[j] - sum[i] + num[i] + "\n");
		}
		System.out.println(sb);
	}

}
