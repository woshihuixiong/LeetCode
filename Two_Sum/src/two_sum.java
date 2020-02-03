import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class two_sum {
	public static void main(String[] args) {
//        int[] nums=new int[] {2,7,11,15};
//        int target=9;
		
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
        
        System.out.println(Arrays.toString(ss.twoSum(nums,target)));
    }

}

//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++) {
//        	int x=target-nums[i];
//        	for(int j=i+1;j<nums.length;j++) {
//        		if(nums[j]==x) return new int[] {i,j};
//        	}
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);  //不能重复利用，所以后面再放进哈希表
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}