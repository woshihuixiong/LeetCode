public class MergeLists {
	public static void main(String[] args) {
		Solution ss=new Solution();
		ListNode[] ll = new ListNode[3];
		
		ll[0]=new ListNode(1);
		ll[0].next=new ListNode(4);
		ll[0].next.next=new ListNode(5);
        
		ll[1]=new ListNode(1);
		ll[1].next=new ListNode(3);
		ll[1].next.next=new ListNode(4);
        
		ll[2]=new ListNode(2);
		ll[2].next=new ListNode(6);
        
        ListNode ans=ss.mergeKLists(ll);
        
        ListNode cur = ans;
        while(cur!=null) {
        	System.out.printf("%d->", cur.val);
        	cur = cur.next;
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0) return null;
    	
//    	for(int i=1;i<lists.length;i++) {
//    		lists[0]=mergeTwoLists(lists[0],lists[i]);
//    	}
//    	return lists[0];
    	
    	int step = lists.length;
    	int j = 0;
    	while(step!=0) {
    		for(int i=0; i<step; i+=2) {
    			if(i+1 < step) {
    				lists[j++] = mergeTwoLists(lists[i], lists[i+1]);
    			}
    			else{
    				lists[j++] = lists[i];
    			}
    		}
    		if(step != 1) step = step/2 + step%2;
    		else step=0;
    		j = 0;
    	}
    	
    	return lists[0];

    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}