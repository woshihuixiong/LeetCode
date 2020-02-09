import java.util.Scanner;

public class Median {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		Scanner sc = new Scanner(System.in);
        
        System.out.println("Please input the nums1:");
		String str1 = sc.next().toString();
		String[] arr1  = str1.split(",");
		int[] nums1 = new int[arr1.length];
		for(int j = 0; j<nums1.length;j++) {
		    nums1[j] = Integer.parseInt(arr1[j]);
		}
        
		System.out.println("Please input the nums2:");
		String str2 = sc.next().toString();
		String[] arr2  = str2.split(",");
		int[] nums2 = new int[arr2.length];
		for(int j = 0; j<nums2.length;j++) {
		    nums2[j] = Integer.parseInt(arr2[j]);
		}
		
		System.out.printf("The median of the two sorted arrays is: %.1f", ss.findMedianSortedArrays(nums1, nums2));
    }

}

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n=nums1.length;
		int m=nums2.length;
		if((m+n)%2==0) {
			return (double)(getKth(nums1,0,n-1,nums2,0,m-1,(n+m)/2)+getKth(nums1,0,n-1,nums2,0,m-1,(n+m+2)/2))/2;
		}
		else return getKth(nums1,0,n-1,nums2,0,m-1,(n+m+1)/2);
		
	}
	
	private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1=end1-start1+1;
		int len2=end2-start2+1;
		
		if(len1==0) return nums2[start2+k-1];
		if(len2==0) return nums1[start1+k-1];
		
		if(k==1) return Math.min(nums1[start1], nums2[start2]);
		
		int i=start1+Math.min(k/2, len1)-1;
		int j=start2+Math.min(k/2, len2)-1;
		
		if(nums1[i]>nums2[j])
			return getKth(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1));
		else return getKth(nums1, i+1, end1, nums2, start2, end2, k-(i-start1+1));
	}

}
