import java.util.Scanner;

public class Container {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
      
        System.out.println("Please input the heights:");
		String str = sc.next().toString();
		String[] arr  = str.split(",");
		int[] height = new int[arr.length];
		for(int j = 0; j<height.length;j++) {
		    height[j] = Integer.parseInt(arr[j]);
		}
      
      System.out.println(ss.maxArea(height));
  }

}

class Solution {
    public int maxArea(int[] height) {
        int LeftNode = 0;
        int RightNode = height.length-1;
        int ans = 0;
        
        while(LeftNode != RightNode) {
        	ans = Math.max(ans, Math.min(height[LeftNode], height[RightNode])*(RightNode-LeftNode));
        	if(height[LeftNode] < height[RightNode]) LeftNode++;
        	else RightNode--;
        }
        
        return ans;
    }
}