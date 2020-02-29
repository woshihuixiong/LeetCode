import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Generate_Parentheses {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the n:"); 
        int n = sc.nextInt();
        sc.close();
        
        System.out.print(ss.generateParenthesis(n));
	}

}

class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<String>();
    	if(n == 0) return ans;
    	
    	backtrack(ans, new StringBuilder(), n);
    	
    	return ans;

    }
    
    private Stack<Character> stack=new Stack<Character>();
    private int count = 0;     //左括号数目
    
    private void backtrack(List<String> ans, StringBuilder str, int n) {
    	if(stack.empty() && str.length() == n*2) {     //栈空且str长度到达2n
    		ans.add(str.toString());
    		return;
    	}
    	
    	if(stack.empty() && str.length() < n*2) {     //栈空且还需要插入括号，只能插入左括号
    		stack.push('(');
    		str.append('(');
    		count++;
    		backtrack(ans, str, n);
    		count--;
    		str.deleteCharAt(str.length()-1);
    		stack.pop();
    		return;
    	}
    	
    	if(count == n) {      //左括号够了，只能插入右括号
    		stack.pop();
    		str.append(')');
    		backtrack(ans, str, n);
    		str.deleteCharAt(str.length()-1);
    		stack.push('(');
    		return;
    	}
    	
    	//其他情况左右括号都可以插入
    	
    	stack.push('(');
		str.append('(');
		count++;
		backtrack(ans, str, n);
		count--;
		str.deleteCharAt(str.length()-1);
		stack.pop();
		
		stack.pop();
		str.append(')');
		backtrack(ans, str, n);
		str.deleteCharAt(str.length()-1);
		stack.push('(');
		return;
    }
}