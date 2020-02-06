
public class Add2Nums {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		ListNode l1=new ListNode(0);
        l1.next=new ListNode(0);
        l1.next.next=new ListNode(3);
        
        ListNode l2=new ListNode(0);
        l2.next=new ListNode(0);
        l2.next.next=new ListNode(4);
        
        ListNode ans=ss.addTwoNumbers(l1, l2);
        
        if(ans!=null && ans.next!=null && ans.next.next!=null) {
        	System.out.printf("%d,%d,%d",ans.val,ans.next.val,ans.next.next.val);
        }
//        System.out.printf("%d,%d,%d",ans.val,ans.next.val,ans.next.next.val);
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1=0;
//        long num2=0;
//        int ii=0;
//        int jj=0;
//        ListNode current1=l1;
//        ListNode current2=l2;
//        
//        while(current1!=null) {
//        	num1+=current1.val * Math.pow(10,ii);
//        	ii++;
//        	current1=current1.next;
//        }
//        
//        while(current2!=null) {
//        	num2+=current2.val * Math.pow(10,jj);
//        	jj++;
//        	current2=current2.next;
//        }
//        
//        long num=num1+num2;
//        
//        ListNode ans = new ListNode(0);
//        ListNode current = ans;
//        while(num!=0) {
//        	current.next = new ListNode((int)num%10); //先new next再指向next
//        	num/=10;
//        	current=current.next;
//        }
//        
//        if(ans.next==null) ans.next=new ListNode(0);
//        return ans.next;
//    }
//}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return ans.next;
    }
}