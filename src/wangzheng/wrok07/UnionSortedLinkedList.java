package wangzheng.wrok07;

import LinkedList.ListNode;

/**
 *
 * 合并有序链表
 *
 * @author: Xiang Mingzhe
 * @version UnionSortedLinkedList.java, v 0.1 2019/11/8 9:30 XiangMingZhe Exp $
 **/
public class UnionSortedLinkedList {

	private static ListNode unionSortedList(ListNode linkedList1, ListNode linkedList2) {
		if (null == linkedList1)
			return linkedList2;
		if (null == linkedList2)
			return linkedList1;

		ListNode point1 = linkedList1;
		ListNode point1Next = linkedList1.next;
		ListNode point2 = linkedList2;
		ListNode point2Next = linkedList2.next;
		ListNode head = linkedList1.val <= linkedList2.val ? linkedList1 : linkedList2;
		while (point1.next != null && point2.next != null) {

			if (point1.val <= point2.val) {
				point1.next = point2;
				point1 = point1Next;
				point1Next = point1.next;
			} else {
				point2.next = point1;
				point2 = point2Next;
				point2Next = point2.next;
			}
		}

		return head;
	}

	private static ListNode unionSortedList2(ListNode linkedList1, ListNode linkedList2) {
		if (null == linkedList1)
			return linkedList2;
		if (null == linkedList2)
			return linkedList1;

		ListNode head = new ListNode(-1);
		ListNode temp = head;
		while (linkedList1 != null && linkedList2 != null) {
			if (linkedList1.val <= linkedList2.val) {
				temp.next = linkedList1;
				linkedList1 = linkedList1.next;
			} else {
				temp.next = linkedList2;
				linkedList2 = linkedList2.next;
			}

			temp = temp.next;
		}

		if (linkedList1 == null)
			temp.next = linkedList2;
		if (linkedList2 == null)
			temp.next = linkedList1;

		return head.next;
	}

	public static void main(String[] args) {
		ListNode s1 = ListNode.getListNodeData(5, 1 ,2);
		ListNode s2 = ListNode.getListNodeData(10, 2 ,2);
		System.out.println(s1);
		System.out.println(s2);

		System.out.println(unionSortedList2(s1, s2));
	}
}
