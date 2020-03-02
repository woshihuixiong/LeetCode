import java.util.Scanner;

public class Remove_Element {
	public static void main(String[] args) {
		
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please input the val:"); 
        int val = sc.nextInt();
      
        System.out.println("Please input the nums:");
		String str = sc.next().toString();
		String[] arr  = str.split(",");
		int[] nums = new int[arr.length];
		for(int j=0; j<nums.length; j++) {
		    nums[j] = Integer.parseInt(arr[j]);
		}
		
		sc.close();
        
		int ans = ss.removeElement(nums, val);
        System.out.printf("%d\n", ans);
        for(int i=0;i<ans;i++) {
        	System.out.printf("%d, ", nums[i]);
        }
  }

}


//class Solution {
//    public int removeElement(int[] nums, int val) {
//    	if(nums.length == 0) return 0;
//    	
//    	int len = nums.length;
//    	int R = len-1;
//    	int count = 0;
//    	
//    	
////    	for(int i=0;i<len;i++) {
////    		if(nums[i] == val) {
////    			while(R > i+1) {
////    				if(nums[R] == val) {
////    					R--;
////    					count++;
////    				}
////    				else break;
////    			}
////    			
////    			int x = nums[i];
////    			nums[i] = nums[R];
////    			nums[R] = x;
////    			count++;
////    			
////    			if(i == R-1) {
////    				if(nums[R] == val) count++;
////    				break;
////    			}
////    			else R--;
////    		}
////    		
////    		
////    	}
//    	
//    	for(int i=0;i<len;i++) {
//    		if(nums[i] == val) {
//    			while(nums[R] == val) {
//    				R--;
//    				if(R == -1 || R == i) break;
//    			}
//    			
//    			if(R == -1) break;
//    			
//    			int x = nums[i];
//    			nums[i] = nums[R];
//    			nums[R] = x;
//    		}
//    		
////    		for(int j=0;j<len;j++) {
////    			System.out.printf("%d, ", nums[j]);
////    		}
////    		System.out.printf("R=%d\n", R);
//    		
//    		if(i >= R-1) break;
//    	}
//    	
//    	for(int i=0;i<len;i++) {
//    		if(nums[i] == val) break;
//    		count++;
//    	}
//    	
//    	return count;
//
//    }
//}

class Solution {
    public int removeElement(int[] nums, int val) {
    	int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}