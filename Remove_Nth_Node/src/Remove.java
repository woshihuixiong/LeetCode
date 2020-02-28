
public class Remove {
	public static void main(String[] args) {
		Solution ss=new Solution();
		
		ListNode l=new ListNode(1);
        l.next=new ListNode(2);
        l.next.next=new ListNode(3);
        l.next.next.next=new ListNode(4);
        l.next.next.next.next=new ListNode(5);
        
        l = ss.removeNthFromEnd(l, 5);
        
        ListNode prt = l;
        while(prt!=null) {
        	if(prt.next==null) System.out.printf("%d",prt.val);
        	else System.out.printf("%d -> ",prt.val);
        	prt=prt.next;
        }
        
        
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

//下面是遍历两遍的初代版本
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//    	ListNode cur = head;
//    	int x=0;
//    	while(cur!=null) {
//    		cur = cur.next;
//    		x++;
//    	}
//    	
//    	if(x == n) return head.next;
//    	
//    	ListNode target = head;
//    	int count=0;
//    	while(true) {
//    		if(count == x-n-1) {
//    			if(target.next.next == null) target.next=null;
//    			else target.next = target.next.next;
//    			break;
//    		}
//    		target = target.next;
//    		count++;
//    	}
//    	
//    	return head;
//
//    }
//}


//只遍历一遍，用双指针
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int right=n+1;
		int sign=0;
		
		ListNode L = head;
		ListNode R = head;
		for(int i=0;i<right;i++) {
			if(i==right-2 && R.next==null) {
				sign=1;
				break;
			}
			if(i==right-1 && R.next==null) sign=2;
			R = R.next;
		}
		
		if(sign == 1) {
			return head.next;
		}
		if(sign == 2) {
			head.next=head.next.next;
			return head;
		}
		
		while(R!=null) {
			L = L.next;
			R = R.next;
		}
		
		if(L.next.next == null) L.next = null;
		else L.next = L.next.next;
		
		return head;
	}
}