import java.util.Scanner;
import java.util.Stack;

public class Water {
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
      
      System.out.println(ss.trap(height));
  }

}

class Solution {
    public int trap(int[] height) {
        int sum=0;
        Stack<Integer> stack=new Stack();
        
        for(int index=0;index<height.length;index++) {
        	if(stack.empty()) {
        		stack.push(index);
        	}
        	if(height[index]<=height[stack.peek()]) {
        		stack.push(index);
        	}
        	else {
//        		int hBottom=height[stack.peek()];
        		while(height[stack.peek()]<height[index] && !stack.empty()) {
        			int hBottom=height[stack.peek()];
        			stack.pop();
        			if(stack.empty()) break;
        			int h=Math.min(height[stack.peek()], height[index])-hBottom;
            		sum+=h*(index-stack.peek()-1);
        		}
//        		int h=Math.min(height[stack.peek()], height[index])-hBottom;
//        		sum+=h*(index-stack.peek()-1);
//        		stack.pop();
        		stack.push(index);
        	}
        }
        
        return sum;
    }
}
