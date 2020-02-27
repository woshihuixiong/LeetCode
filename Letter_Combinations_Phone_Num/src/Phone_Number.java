import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone_Number {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.print("Input the phone number: ");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();
        
        System.out.println(ss.letterCombinations(str));
        
	}

}

class Solution {
	private char[] Two = {'a','b','c'};
	private char[] Three = {'d','e','f'};
	private char[] Four = {'g','h','i'};
	private char[] Five = {'j','k','l'};
	private char[] Six = {'m','n','o'};
	private char[] Seven = {'p','q','r','s'};
	private char[] Eight = {'t','u','v'};
	private char[] Nine = {'w','x','y','z'};
	
    public List<String> letterCombinations(String digits) {
    	
    	List<String> ans = new ArrayList<String>();
    	
    	if(digits.equals(""))
            return ans;
        
    	backtrack(0, digits, new String(), ans);
    	return ans;
    	

    }
    
    private void backtrack(int i, String digits, String str, List<String> ans) {
    	
    	if(i == digits.length()) {
    		ans.add(str);
    		return;
    	}
    	
    	switch(digits.charAt(i)) {
		case '2':
			for(int j=0;j<Two.length;j++) {
				str += Two[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '3':
			for(int j=0;j<Three.length;j++) {
				str += Three[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '4':
			for(int j=0;j<Four.length;j++) {
				str += Four[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '5':
			for(int j=0;j<Five.length;j++) {
				str += Five[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '6':
			for(int j=0;j<Six.length;j++) {
				str += Six[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '7':
			for(int j=0;j<Seven.length;j++) {
				str += Seven[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '8':
			for(int j=0;j<Eight.length;j++) {
				str += Eight[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
			
		case '9':
			for(int j=0;j<Nine.length;j++) {
				str += Nine[j];
				backtrack(i+1,digits,str,ans);
				str = str.substring(0, str.length() - 1);
			}
			break;
    	
    }
    }
}