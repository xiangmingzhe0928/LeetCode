package wangzheng.wrok07;

import LinkedList.ListNode;

/**
 *
 * 链表是否含有环
 *
 * @author: Xiang Mingzhe
 * @version LinkedListHasRing.java, v 0.1 2019/11/7 18:20 XiangMingZhe Exp $
 **/
public class LinkedListHasRing {
	private static boolean hasRing(ListNode head) {
		if (null == head || null == head.next) {
			return false;
		}
		// 快指针
		ListNode fastNode = head;
		// 慢指针
		ListNode slowNode = head;

		while (fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;

			if (fastNode == slowNode) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int srcSize = 5;
		ListNode srcList = ListNode.getListNodeData(srcSize);

		System.out.println(String.format("包含环吗:%s", hasRing(srcList)));

		// 尾节点指向[2]节点 模拟构造环形链表
		ListNode midNode = null;
		ListNode tempNode = srcList;
		while ( tempNode.next != null) {
			if (tempNode.val == 2)
				midNode = tempNode;
			tempNode = tempNode.next;
		}
		tempNode.next = midNode;
		System.out.println(String.format("包含环吗:%s", hasRing(srcList)));
	}
}
