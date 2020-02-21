import java.util.Scanner;

public class Climbing_Stairs {
	public static void main(String[] args) {
		Solution ss = new Solution();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the height: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println(ss.climbStairs(n));
	}

}

//class Solution {
//	public int ans = 0;
//	
//    public int climbStairs(int n) {
//    	backtrack(0,n);
//    	return ans;
//        
//    }
//    
//    private void backtrack(int sum, int n) {
//    	if(sum == n) {
//    		ans++;
//    		return;
//    	}
//    	
//    	if(sum > n) {
//    		return;
//    	}
//    	
//    	backtrack(++sum, n);
//    	sum++;
//    	
//    	backtrack(sum, n);
//    	sum-=2;
//    	
//    	return;
//    }
//}

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];  //令dp[i]表示能到达第i阶的方法总数
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}