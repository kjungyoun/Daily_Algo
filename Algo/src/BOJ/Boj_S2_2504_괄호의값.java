package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_S2_2504_괄호의값 {
	
	public static class Info{
		int sum = 0;
		int idx = 0;
	}
	
	static int size;
	static String input;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		input = in.readLine();
		size = input.length();
		Info info = doing(0,0);
		
		System.out.println(info.sum);
		
	}
	
	public static Info doing(int idx, int depth) {
		int sum =0;
		Stack<Character> stack = new Stack<Character>();
		Info info = new Info();
		
		for(int i=idx; i<size; i++) {
			char cur = input.charAt(i);
			
			if(cur == '(' || cur == '[') {
				if(stack.isEmpty())
					stack.push(cur);
				else {
					Info info_tmp = doing(i, depth+1);
					int tmp = info_tmp.sum;
					if(tmp != 0) {
						cur = input.charAt(info_tmp.idx);
						char pre = stack.pop();
						if(pre =='(' && cur == ')') {
							sum += tmp * 2;
							i = info_tmp.idx;
						}
						else if(pre == '[' && cur == ']') {
							sum += tmp * 3;
							i = info_tmp.idx;
						}
						else {
							info.sum = 0;
							return info;
						}
					}else
						return info_tmp;
				}
			}else {
				if(stack.isEmpty()) {
					if(depth == 0) {
						info.sum = 0;
						return info;
					}else {
						info.sum = sum;
						info.idx = i;
						return info;						
					}
				}else {
					char pre = stack.pop();
					if(pre =='(' && cur == ')')
						sum += 2;
					else if(pre == '[' && cur == ']')
						sum += 3;
					else
					{
						info.sum = 0;
						return info;
					}
				}
			}
		}
		if(stack.isEmpty()) {
			info.sum = sum;
			return info;
		}else{
			info.sum = 0;
			return info;
		}
	}

}
