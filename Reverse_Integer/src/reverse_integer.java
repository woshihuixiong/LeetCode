import java.util.ArrayList;
import java.util.Scanner;

public class reverse_integer {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
        Scanner sc = new Scanner(System.in);
		System.out.print("Please input the x:"); 
        int x = sc.nextInt();
        
        System.out.println(ss.reverse(x));
	}

}

class Solution {
	public static int INT_MAX = 2147483647;
	public static int INT_MIN = -2147483648;
	
    public int reverse(int x) {
        boolean isPos=true;
        if(x<0) isPos=false;
        x=Math.abs(x);
        
        ArrayList<Integer> Vector = new ArrayList<Integer>();
        while(x!=0) {
        	Vector.add(x%10);
        	x=x/10;
        }
        
        int Res=0;
        for(int i=0;i<Vector.size();i++) {
        	if (Res > INT_MAX/10 || (Res == INT_MAX / 10 && Vector.get(i) > 7)) return 0;
            if (Res < INT_MIN/10 || (Res == INT_MIN / 10 && Vector.get(i) < -8)) return 0;
        	Res=Res*10+Vector.get(i);
        }
        
        if(!isPos) Res=-Res;
        
        return Res;
    }
}
