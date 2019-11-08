package wangzheng.wrok07;

import LinkedList.ListNode;

/**
 * 反转单链表
 *
 *
 * @author: Xiang Mingzhe
 * @version ReverseSingleLinkedList.java, v 0.1 2019/11/7 17:03 XiangMingZhe Exp $
 **/
public class ReverseSingleLinkedList {

	private static ListNode reverse(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}
		// 前驱节点
		ListNode preNode = null;
		// 当前节点
		ListNode currentNode = head;

		while (head.next != null) {
			head = head.next;
			currentNode.next = preNode;
			preNode = currentNode;
			currentNode = head;
		}
		head.next = preNode;
		return head;
	}

	public static void main(String[] args) {
		ListNode srcList = ListNode.getListNodeData(5);
		System.out.println(srcList);
		System.out.println("--------------");
		System.out.println(reverse(srcList));
	}
}
