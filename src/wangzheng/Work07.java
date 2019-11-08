package wangzheng;

import java.util.ArrayList;
import java.util.List;

import LinkedList.ListNode;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version Work07.java, v 0.1 2019/11/8 13:36 XiangMingZhe Exp $
 **/
public class Work07 {

	/**
	 * 链表是否有环
	 * @param head
	 * @return
	 */
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

	/**
	 * 删除倒数第N个节点
	 * @param head
	 * @param n
	 * @return
	 */
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

	/**
	 * 反转点链表
	 * @param head
	 * @return
	 */
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

	/**
	 * 合并有序链表
	 * @param linkedList1
	 * @param linkedList2
	 * @return
	 */
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

	/**
	 * 合并有序链表 简化版
	 * @param linkedList1
	 * @param linkedList2
	 * @return
	 */
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

	/**
	 * 找到链表中间节点
	 * @param head
	 * @return
	 */
	private static List<Integer> findMiddleNode(ListNode head) {
		List<Integer> middleList = new ArrayList<>();
		if (head == null)
			return middleList;
		if (head.next == null) {
			middleList.add(head.val);
			return middleList;
		}


		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		middleList.add(slow.val);
		if (fast.next != null) {
			middleList.add(slow.next.val);
		}

		return middleList;
	}


	public static void main(String[] args) {
		//==============判断环==============
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
		System.out.println("===============判断链表有环==============");

		ListNode srcList2 = ListNode.getListNodeData(5);
		System.out.println(srcList2);
		System.out.println("--------------");
		System.out.println(removeLastNNode(srcList2, 2));
		System.out.println("===============删除倒数第N节点==============");

		//=============================
		ListNode srcList3 = ListNode.getListNodeData(5);
		System.out.println(srcList3);
		System.out.println("--------------");
		System.out.println(reverse(srcList3));
		System.out.println("--------------");
		System.out.println("===============反转链表==============");

		//===============合并有序链表==============
		ListNode s1 = ListNode.getListNodeData(5, 1 ,2);
		ListNode s2 = ListNode.getListNodeData(10, 2 ,2);
		System.out.println(unionSortedList2(s1, s2));
		System.out.println("===============合并有序链表===============");

		//===============链表中间节点==============
		ListNode tempNode6 = ListNode.getListNodeData(5, 1, 1);
		System.out.println(findMiddleNode(tempNode6));
		System.out.println("===============合并有序链表===============");
	}

}
