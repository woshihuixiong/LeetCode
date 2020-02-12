import java.util.Scanner;

public class atoi {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		System.out.println("Please input the string:");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();
        
        System.out.println(ss.myAtoi(str));
        
	}

}

class Solution {
    public int myAtoi(String str) {
    	if(str == "") return 0;
    	
    	int INT_MAX=(int) (Math.pow(2, 31)-1);
    	int INT_MIN=(int) (-Math.pow(2, 31));
        int i=0;
        int len=str.length();
        int flag=1;
        int ans=0;
        
        for(i=0;i<len;) {
        	if(str.charAt(i) == ' ') {
        		i++;
        		continue;
        	}
        	else break;
        }
        
        if(i==len) return 0;
        
        if(str.charAt(i) == '+') i++;
        else if(str.charAt(i) == '-') {
        	i++;
        	flag=-1;
        }
        
        if(i==len || str.charAt(i)>'9' || str.charAt(i)<'0') return 0;
        
        while(i<len && str.charAt(i)<='9' && str.charAt(i)>='0') {
        	if(ans>INT_MAX/10 || (ans==INT_MAX/10 && str.charAt(i)-'0'>INT_MAX%10)) return INT_MAX;
        	if(ans<INT_MIN/10 || (ans==INT_MIN/10 && str.charAt(i)-'0'>-(INT_MIN%10))) return INT_MIN;
        	ans = ans*10+flag*(str.charAt(i)-'0');
        	i++;
        }
        
        return ans;
    }
}