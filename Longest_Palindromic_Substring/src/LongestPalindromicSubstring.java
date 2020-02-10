import java.util.Scanner;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string:");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		System.out.println(ss.longestPalindrome(s));
	}

}

class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        String A = s;
        String B = new StringBuffer(s).reverse().toString();
        
        int len = A.length();
        
        int[][] res = new int[len+1][len+1];
        int maxLen = 0;
        int ansEnd = 0;
        
        for(int i=0;i<=len;i++) {
        	for(int j=0;j<=len;j++) {
        		if(i==0 || j==0) res[i][j]=0;
        		else if(A.charAt(i-1) == B.charAt(j-1)) {
        			res[i][j] = res[i-1][j-1]+1;
        			if(res[i][j]>maxLen && i+j-res[i][j]==len) {
        				maxLen=res[i][j];
        				ansEnd=i-1;
        			}
        		}
        		else res[i][j]=0;
        	}
        }
        
        String ansStr = A.substring(ansEnd-maxLen+1,ansEnd+1);
        return ansStr;
    }
}