package top100;

import LinkedList.ListNode;

/**
 * 21. 合并两个有序链表
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLinkedList_21 {

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}

		ListNode tag = new ListNode(-1);
		ListNode head = tag;

		while (null != l1 && null != l2) {
			if (l1.val >= l2.val) {
				tag.next = l2;
				l2 = l2.next;
				tag = tag.next;
			} else {
				tag.next = l1;
				l1 = l1.next;
				tag = tag.next;
			}
		}

		if (null != l1) {
			while (null != l1) {
				tag.next = l1;
				l1 = l1.next;
				tag = tag.next;
			}
		}

		if (null != l2) {
			while (null != l2) {
				tag.next = l2;
				l2 = l2.next;
				tag = tag.next;
			}
		}

		return head.next;
	}

	public static void main(String[] args) {
//		ListNode l1 = ListNode.getListNodeData(4,1,2);
//		ListNode l2 = ListNode.getListNodeData(4,2,2);
//
//		System.out.println(l1);
//		System.out.println(l2);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);

		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);
		System.out.println(mergeTwoLists(l1,l2));
	}
}
