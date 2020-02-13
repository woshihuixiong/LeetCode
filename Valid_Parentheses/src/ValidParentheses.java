import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string:");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();
        
        System.out.println(ss.isValid(str));
        
	}

}

class Solution {
    public boolean isValid(String s) {
        if(s.equals("")) return true;
        
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
        		stack.push(s.charAt(i));
        	}
        	
        	if(s.charAt(i)==')') {
        		if(stack.empty() || stack.peek()!='(')  return false;
        		stack.pop();
        		continue;
        	}
        	if(s.charAt(i)==']') {
        		if(stack.empty() || stack.peek()!='[')  return false;
        		stack.pop();
        		continue;
        	}
        	if(s.charAt(i)=='}') {
        		if(stack.empty() || stack.peek()!='{')  return false;
        		stack.pop();
        		continue;
        	}
        }
        
        if(stack.empty()) return true;
        else return false;
    }
}