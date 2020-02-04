import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Roman_to_Integer {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();
        
        System.out.println(ss.romanToInt(str));
        
	}

}

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        int ans = 0;
        
        for(int i=0;i<s.length();i++) {
        	if((i+1)<s.length() && map.containsKey(s.substring(i,i+2))) {
        		ans+=map.get(s.substring(i,i+2));
        		i++;
        	}
        	else {
        		ans+=map.get(s.substring(i,i+1));
        	}
        }
        
        return ans;
    }
}