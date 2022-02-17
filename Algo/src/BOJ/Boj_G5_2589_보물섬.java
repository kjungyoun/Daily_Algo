package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_G5_2589_보물섬 {
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static int n,m,answer;
	static char map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		answer = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			String line = in.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'L')
					bfs(i,j);
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean checked[][] = new boolean[n][m];
		int time=-1;
		checked[x][y] = true;
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			time++;
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int temp[] = queue.poll();
				int r = temp[0];
				int c = temp[1];
				for(int idx=0; idx<4; idx++) {
					int nr = r + dr[idx];
					int nc = c + dc[idx];
					if(nr>-1 && nc>-1 && nr<n&& nc<m && map[nr][nc] == 'L' && !checked[nr][nc]) {
						checked[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		
		answer = Math.max(answer, time);
		
	}

}
