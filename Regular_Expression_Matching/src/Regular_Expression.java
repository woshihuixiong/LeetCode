import java.util.Scanner;

public class Regular_Expression {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string s:");
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        
        System.out.println("Please input the string p:");
        String p;
        p = sc.next();
        sc.close();
        
        System.out.println(ss.isMatch(s, p));
        
	}

}

class Solution {
    public boolean isMatch(String s, String p) {
    	if(s == null || p == null) return false;
    	if(!p.isEmpty() && p.charAt(0) == '*') return false;
    	
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for(int i=0;i<p.length();i++) {
        	if(p.charAt(i)=='*' && dp[0][i-1]) dp[0][i+1]=true;  //这个初始化注意，是隔两个的！
        }
        
        for(int i=0;i<s.length();i++) {
        	for(int j=0;j<p.length();j++) {
        		if(p.charAt(j) == s.charAt(i) || p.charAt(j)=='.') dp[i+1][j+1] = dp[i][j];
        		
        		if(p.charAt(j) == '*') {
        			if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.') dp[i+1][j+1] = dp[i+1][j-1];
        			else dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1]);
        		}
        	}
        }
        
        return dp[s.length()][p.length()];
    }
}