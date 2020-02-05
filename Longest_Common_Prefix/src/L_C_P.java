import java.util.Scanner;

public class L_C_P {
	public static void main(String[] args) {
        Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
        
        System.out.println("Please input the strs:");
		String str = sc.next().toString();
		String[] strs  = str.split(",");
		
		System.out.println(ss.longestCommonPrefix(strs));
	}

}

class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
    	
        String ans = "";
        for(int i=0;i<strs[0].length();i++) {
        	char c=strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++) {
        		if(strs[j].length() == i || strs[j].charAt(i)!=c) {
        			return ans;
        		}
        		
        	}
        	ans+=c;
        }
        return ans;
    }
}