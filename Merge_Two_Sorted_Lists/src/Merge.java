
public class Merge {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        
        ListNode ans=ss.mergeTwoLists(l1, l2);
        
//        if(ans!=null && ans.next!=null && ans.next.next!=null) {
//        	System.out.printf("%d,%d,%d",ans.val,ans.next.val,ans.next.next.val);
//        }
        System.out.printf("%d,%d,%d,%d,%d,%d",ans.val,ans.next.val,ans.next.next.val,ans.next.next.next.val,ans.next.next.next.next.val,ans.next.next.next.next.next.val);
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        
        while(cur1!=null || cur2!=null) {
        	if(cur1==null) {
        		while(cur2!=null) {
        			cur.next = new ListNode(cur2.val);
        			cur=cur.next;
        			cur2=cur2.next;
        		}
        		break;
        	}
        	
        	if(cur2==null) {
        		while(cur1!=null) {
        			cur.next = new ListNode(cur1.val);
        			cur=cur.next;
        			cur1=cur1.next;
        		}
        		break;
        	}
        	
        	if(cur1.val<cur2.val) {
        		cur.next = new ListNode(cur1.val);
        		cur=cur.next;
        		cur1=cur1.next;
        	}
        	
        	else {
        		cur.next = new ListNode(cur2.val);
        		cur=cur.next;
        		cur2=cur2.next;
        	}
        }
        
        return ans.next;
    }
}