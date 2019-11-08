package wangzheng.wrok07;

import LinkedList.ListNode;

/**
 *
 * 删除倒数第N个节点
 *
 * @author: Xiang Mingzhe
 * @version RemoveLastNNode.java, v 0.1 2019/11/8 11:24 XiangMingZhe Exp $
 **/
public class RemoveLastNNode {

	private static ListNode removeLastNNode(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		if (n <= 0)
			return head;
		ListNode preNode = new ListNode(-1);
		preNode.next = head;
		ListNode firstNode = preNode;
		ListNode lastNode = preNode;
		while (n > 0) {
			firstNode = firstNode.next;
			n-- ;
		}

		while (firstNode.next != null) {
			firstNode = firstNode.next;
			lastNode = lastNode.next;
		}

		// 此时lastNode.next为倒数第n个元素
		lastNode.next = lastNode.next.next;

		return preNode.next;
	}


	public static void main(String[] args) {
		ListNode srcList = ListNode.getListNodeData(5);
		System.out.println(srcList);
		System.out.println("--------------");
//		System.out.println(removeLastNNode(srcList, 0));
//		System.out.println(removeLastNNode(srcList, 1));
		System.out.println(removeLastNNode(srcList, 2));
//		System.out.println(removeLastNNode(srcList, -1));
	}
}
