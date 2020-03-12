import java.util.Arrays;
import java.util.Scanner;

public class Next_Permutation {
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
		
		ss.nextPermutation(nums);
      
        for(int i=0;i<nums.length;i++) {
        	System.out.printf("%d,", nums[i]);
        }
  }

}


class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i;
        
        if(nums == null || len == 0 || len == 1) return;
        
        for(i=len-2; i>=0; i--) {
        	if(nums[i] < nums[i+1]) {
        		int min = 2147483647;
        		int t = i+1;
        		
        		for(int j=i+1;j<len;j++) {
        			if(nums[j] < min && nums[j] > nums[i]) {
        				min = nums[j];
        				t = j;
        			}
        		}
        		
        		int k = nums[i];
        		nums[i] = nums[t];
        		nums[t] = k;
        		
//        		这里我进行了排序，其实根本没必要，只需要翻转即可，时间复杂度可以去到O(n)
        		for(int m = i+1; m < len-1; m++){
       	          for(int n = i+1; n < len-1-m+i+1; n++){
       	             if(nums[n] > nums[n+1]){
       	                 int temp = nums[n];
       	                 nums[n] = nums[n+1];
       	                 nums[n+1] = temp;
       	             }
       	          }
       	       } 
        		
        		break;
        	}
        	else continue;
        }
        
        if(i == -1) {
        	for(int j=0;j<len/2;j++) {
        		int k = nums[j];
        		nums[j] = nums[len-j-1];
        		nums[len-j-1] = k;
        	}
        }
        
        return;

    }
    
}