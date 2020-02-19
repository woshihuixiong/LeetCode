import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
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
      
        System.out.println(ss.permute(nums));
  }

}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(ans, nums, new ArrayList<Integer>(), visited);  //new
        return ans;
    }
    
    private void backtrack(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tmp, int[] visited) {
    	if(tmp.size() == nums.length) {      //到达根节点，返回
    		ans.add(new ArrayList<>(tmp));   //new
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++) {   //寻找下一节点
    		if(visited[i]==1) continue;  //这相当于剪枝
    		
    		visited[i]=1;   //找到下一个节点，加入tmp
    		tmp.add(nums[i]);
    		
    		backtrack(ans, nums, tmp, visited);  //继续深度优先搜索
    		
    		visited[i]=0;   //回到上个根节点
    		tmp.remove(tmp.size()-1);
    	}
    }
}