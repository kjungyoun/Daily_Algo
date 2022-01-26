package Kurly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int n = Integer.parseInt(st.nextToken());
		
		int eat[] = new int[n];
		int heat[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			eat[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			heat[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		
		for (int i = 0; i < n; i++) {
			time += heat[i];
			
			
			
		}
	}

}
