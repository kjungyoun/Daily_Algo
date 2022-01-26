package Ebay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EbayKorea_CodingTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int total = n*m;
		int count = 0;
		
		while(true) {
			total -= m;
			if(total<=0) {
				break;
			}else {
				count++;
				total += 1;
			}
		}
		System.out.println(count);
		
		LinkedList<Integer>list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		

	}

}
