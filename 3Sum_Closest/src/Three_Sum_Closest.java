import java.util.Arrays;
import java.util.Scanner;

public class Three_Sum_Closest {
	public static void main(String[] args) {
		
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please input the target:"); 
        int target = sc.nextInt();
      
        System.out.println("Please input the nums:");
		String str = sc.next().toString();
		String[] arr  = str.split(",");
		int[] nums = new int[arr.length];
		for(int j = 0; j<nums.length;j++) {
		    nums[j] = Integer.parseInt(arr[j]);
		}
		
		sc.close();
      
        System.out.println(ss.threeSumClosest(nums, target));
  }

}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	if(nums==null || nums.length<3) return target;
    	int ans = 2147483647;
    	int flag=1;
    	
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++) {
    		int L=i+1;
    		int R=nums.length-1;
    		
    		while(L<R) {
    			int sum = nums[i]+nums[L]+nums[R]-target;
    			if(sum == 0) return target;
    			else if(sum > 0) {
    				if(sum<ans) {
    					ans=sum;
    					flag=1;
    				}
    				R--;
    			}
    			else {
    				if(-sum<ans) {
    					ans=-sum;
    					flag=-1;
    				}
    				L++;
    			}
    		}
    	}
    	return ans*flag+target;
    }
}