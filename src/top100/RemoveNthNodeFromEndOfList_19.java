package top100;

import LinkedList.ListNode;

/**
 *
 * 删除倒数第n个节点
 *
 * @author: Xiang Mingzhe
 * @version RemoveNthNodeFromEndOfList_19.java, v 0.1 2019/12/13 13:44 XiangMingZhe Exp $
 **/
public class RemoveNthNodeFromEndOfList_19 {

	/**
	 * <pre>
	 * 删除链表中 倒数第n个节点
	 * 	1.找到第n个节点：快慢指针 两指针间隔n-1个节点 同时遍历链表 当快指针结束时(.next==null) 慢指针即为倒数第n节点
	 * 	2.删除第n个节点 由(1)知当两指针间隔n-1个节点,快指针在尾节点时,慢指针刚好指向倒数第N节点。因此需要定位到倒数第n+1节点来删除倒数第n节点
	 * </pre>
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (null == head || n <= 0) {
			return head;
		}
		ListNode headPre = new ListNode(-1);
		headPre.next = head;
		ListNode quickP = headPre;
		ListNode slowP = headPre;

		// 快指针先行n步
		while (n > 0 && null != quickP) {
			quickP = quickP.next;
			n -- ;
		}

		if (null == quickP) {
			return null;
		}
		while (null != quickP.next) {
			quickP = quickP.next;
			slowP = slowP.next;
		}

		// 此时slowP指向 倒数第n+1节点
		slowP.next = slowP.next.next;

		return headPre.next;

	}

	public static void main(String[] args) {
		ListNode head = ListNode.getListNodeData(1);
		System.out.println(head);
		System.out.println(removeNthFromEnd(head, 2));
	}
}
