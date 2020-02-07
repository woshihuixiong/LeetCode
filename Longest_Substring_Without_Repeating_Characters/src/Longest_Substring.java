import java.util.HashMap;
import java.util.Scanner;

public class Longest_Substring {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string:");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		System.out.println(ss.lengthOfLongestSubstring(s));
	}

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()==0) return 0;
    	
        int max=0;
        int left=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length();i++) {
        	if(map.containsKey(s.charAt(i))) {
        		left=Math.max(left, map.get(s.charAt(i))+1); //保证left一直右移
        	}
        	
        	map.put(s.charAt(i), i); //已有的键值对会被覆盖
        	max = Math.max(max, i-left+1);
        }
        
        return max;
    }
}