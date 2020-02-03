import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the x:"); 
        int x = sc.nextInt();
        sc.close();
        
        if(ss.isPalindrome(x)) System.out.println("true");
        else System.out.println("false");
	}

}

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==reverse(x)) return true;
        return false;
        
    }
    
    public int reverse(int x) {
        
        ArrayList<Integer> Vector = new ArrayList<Integer>();
        while(x!=0) {
        	Vector.add(x%10);
        	x=x/10;
        }
        
        int Res=0;
        for(int i=0;i<Vector.size();i++) {
        	if (Res > 2147483647/10) return 0;
        	Res=Res*10+Vector.get(i);
        }
        
        return Res;
    }
}