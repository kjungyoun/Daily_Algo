import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programmers_lv1_신규아이디추천 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String new_id = in.readLine(); 
		
			  String answer = "";
		      StringBuilder sb = new StringBuilder();
		        
		        // 1단계
		        new_id = new_id.toLowerCase();
		        
		        // 2단계
		        new_id = new_id.replaceAll("[^\\w[.][-]]","");
		        
		        sb.append(new_id);
		        
		        // 3단계
		        for(int i=0; i<sb.length(); i++){
		            // 첫번째 .일 경우
		            if(sb.charAt(i) == '.'){
		               if(i != sb.length()-1) // 맨 뒤의 .이 아닐때
		                   i++;
		                 while(sb.charAt(i) == '.'){
		                    sb.deleteCharAt(i);
		                    if(i>sb.length()-1) break;
		                }
		            }
		        }
		        
		        // 4단계
		        while(sb.length() !=0 && sb.charAt(0) == '.'){
		            sb.deleteCharAt(0);
		        }
		        while(sb.length() !=0 && sb.charAt(sb.length()-1) == '.'){
		            sb.deleteCharAt(sb.length()-1);
		        }
		        
		        // 5단계
		        if(sb.length() == 0)
		            sb.append("a");
		        
		        // 6단계
		        if(sb.length() > 15){
		             sb = sb.delete(15,sb.length());
		            while(sb.charAt(sb.length()-1) == '.'){
		                sb.deleteCharAt(sb.length()-1);
		            }   
		        }
		        
		        // 7단계
		        if(sb.length()<3){
		            char last = sb.charAt(sb.length()-1);
		            while(sb.length() < 3){
		                sb.append(last);
		            }
		        }
		        
		        answer = sb.toString();
		        
		        System.out.print(answer);

	}

}
