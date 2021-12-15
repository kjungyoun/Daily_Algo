import java.util.Scanner;

public class Boj_S2_11729_하노이탑이동순서 {
	
	static StringBuilder sb;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuilder();
		
		hanoi(n,1,2,3);
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int from, int tmp, int to) {
		if(n == 0) return;
		
		// 횟수 카운트
		cnt++;
		
		// N-1번째까지의 원판 tmp로 이동
		hanoi(n-1, from, to, tmp);
		
		// N번째 원판 목적지까지 이동
		sb.append(from + " " + to + "\n");
		
		// N-1번째까지의 원판 tmp에서 목적지로 이동
		hanoi(n-1, tmp, from, to);
	}

}
