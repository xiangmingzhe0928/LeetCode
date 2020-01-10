package top100;

import LinkedList.ListNode;

/**
 *
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author: Xiang Mingzhe
 * @version ReverseLinkedList_206.java, v 0.1 2020/1/10 11:00 XiangMingZhe Exp $
 **/
public class ReverseLinkedList_206 {

	public ListNode reverseList(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}

		ListNode pre = null;
		ListNode curr = head;
//		ListNode next = curr.next;
		ListNode next;
		while (curr.next != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		curr.next = pre;

		return curr;

	}

	public static void main(String[] args) {
		new ReverseLinkedList_206().reverseList(ListNode.getListNodeData(5));
	}
}
