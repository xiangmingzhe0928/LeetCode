package LinkedList;

/**
 * LinkedList
 * description:反转单链表
 * 一个经典的老题目了 今天同事讨论起相关的问题 再写下加深下吧
 *
 * @see RotateList_61
 * author:mingzhe Xiang
 * date:2018/1/29
 */
public class ReverseSingleLinkedList {

	private static ListNode reverse(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}

		ListNode prevNode = null;
		ListNode currNode = head;
		ListNode nextNode = head.next;

		while (currNode.next != null) {
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			nextNode = currNode.next;
		}
		currNode.next = prevNode;
		return currNode;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.getListNodeData(5);
		System.out.println("BEFORE:" + head + "\nAFTER:" + reverse(head));
	}
}
