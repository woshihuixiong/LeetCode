import java.util.Scanner;

public class LongestValidParentheses {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string:");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();
        
        System.out.println(ss.longestValidParentheses(str));
        
	}

}

class Solution {
    public int longestValidParentheses(String s) {
    	if(s == null || s.length()==0 || s.length()==1) return 0;
    	
        int ans = 0;
        int[] dp = new int[s.length()];
        
        dp[0] = 0;
        if(s.charAt(0)=='(' && s.charAt(1)==')') {
        	dp[1] = 2;
        	ans = 2;
        }
        else dp[1] = 0;
        
        for(int i=2;i<s.length();i++) {
        	if(s.charAt(i) == '(') dp[i]=0;
        	else {
        		if(s.charAt(i-1) == '(') dp[i]=dp[i-2]+2;
        		else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '(') {
        			if(i-dp[i-1]-2 >= 0) dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
        			else dp[i]=dp[i-1]+2;
        		}
        	}
        	ans = Math.max(ans, dp[i]);
        }
        
        return ans;

    }
}