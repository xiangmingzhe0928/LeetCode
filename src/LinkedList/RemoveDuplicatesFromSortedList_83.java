package LinkedList;

/**
 * LinkedList
 * description:删除链表中重复节点(同一val只保留一个节点)
 Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 * author:mingzhe Xiang
 * date:2017/2/13
 */
public class RemoveDuplicatesFromSortedList_83 {

	/**
	 * 最容易想到的方式
	 * 类似逐步遍历所有元素，遍历到与next相同val就remove掉next
	 * 这种方式最能理解 但缺点是对于1-1-1-1-2这种本可以只触发一次删除操作(删除1-1-1) 这种方式却需要触发多次删除操作
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		//定义Flag指针
		ListNode flagPoint = head;
		while (flagPoint.next != null) {
			if (flagPoint.val == flagPoint.next.val)
				flagPoint.next = flagPoint.next.next;
			else
				flagPoint = flagPoint.next;
		}
		return head;
	}

	/**
	 * DisCuss上MostVotes方案
	 * 递归的方式处理每一个元素
	 * @param head
	 * @return
	 */
	public static ListNode mostVotes(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = mostVotes(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		//        node3.next = node4;
		//        node4.next = node5;
		//        node5.next = node6;
		System.out.println(deleteDuplicates(node1));
	}
}
