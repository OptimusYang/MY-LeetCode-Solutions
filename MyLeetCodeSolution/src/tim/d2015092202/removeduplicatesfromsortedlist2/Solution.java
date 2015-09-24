package tim.d2015092202.removeduplicatesfromsortedlist2;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author Tim
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      	LinkedList<ListNode> newList = new LinkedList<ListNode>();
		ListNode newNode = null;
		ListNode tempNode = null;
		ListNode preNode = null;
		ListNode currentNode = head;
		while (currentNode != null) {
			int preVal = Integer.MIN_VALUE;
			int curVal = currentNode.val;
			int nxtVal = Integer.MIN_VALUE;
			if (preNode != null) {
				preVal = preNode.val;
			}
			if (currentNode.next != null) {
				nxtVal = currentNode.next.val;
			}

			if (curVal != preVal && curVal != nxtVal) {
				newList.addLast(new ListNode(curVal));
			}
			preNode = currentNode;
			currentNode = currentNode.next;
		}
		int size = newList.size();
		if(size>0){
			newNode = newList.get(0);
			tempNode = newNode;
			for(int i=1;i<size;i++){
				ListNode tempListNode = newList.get(i);
				tempNode.next = tempListNode;
				tempNode = tempListNode;
			}
		}
		return newNode;
    }
}