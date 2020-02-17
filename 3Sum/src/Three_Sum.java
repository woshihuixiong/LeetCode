import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Three_Sum {
	public static void main(String[] args) {
		
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
      
        System.out.println("Please input the nums:");
		String str = sc.next().toString();
		String[] arr  = str.split(",");
		int[] nums = new int[arr.length];
		for(int j = 0; j<nums.length;j++) {
		    nums[j] = Integer.parseInt(arr[j]);
		}
		sc.close();
		
        System.out.println(ss.threeSum(nums));
  }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();   //new
    	int len = nums.length;
    	if(nums==null || len<3) return ans;
    	
    	Arrays.sort(nums);  //new
    	
    	for(int i=0;i<len;i++) {
    		if(nums[i]>0) break;
    		if(i>0 && nums[i]==nums[i-1]) continue;
    		
    		int L=i+1;
    		int R=len-1;
    		
    		while(L<R) {
    			int sum=nums[i]+nums[L]+nums[R];
    			if(sum==0) {
    				ans.add(Arrays.asList(nums[i],nums[L],nums[R]));  //new
    				while(L<R && nums[L]==nums[L+1]) L++;
    				while(L<R && nums[R]==nums[R-1]) R--;
    				L++;
    				R--;
    			}
    			else if(sum<0) L++;
    			else R--;
    		}
    	}
    	return ans;
    }
}