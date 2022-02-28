package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_S4_9012_괄호 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(in.readLine());
		
		top:for(int t=0; t<test_case; t++) {
			String input = in.readLine();
			int size = input.length();
			Stack<Character> stack = new Stack<Character>();
			
			for(int i=0; i<size; i++) {
				char cur = input.charAt(i);
				
				if(cur == '(')
					stack.push(cur);
				else {
					if(!stack.isEmpty())
						stack.pop();
					else {
						System.out.println("NO");
						continue top;
					}
				}
			}
			
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");

		}
		}

}
