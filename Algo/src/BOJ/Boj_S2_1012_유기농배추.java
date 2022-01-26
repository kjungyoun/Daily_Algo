package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_S2_1012_유기농배추 {
	static int n,m,k;
	static boolean checked[][];
	static int map[][];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for(int testCase = 0; testCase<t; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			checked = new boolean[n][m];
			int count = 0;
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r= Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 1 && !checked[i][j]) {
						count++;
						checking(i,j);
					}
				}
			}
			System.out.println(count);
		}

	}
	
	public static void checking(int r, int c) {
		checked[r][c] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int row = tmp[0];
			int col = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if(nr>-1 && nr<n && nc>-1 && nc<m && map[nr][nc] == 1 && !checked[nr][nc]) {
					checked[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}

}
