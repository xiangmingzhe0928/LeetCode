package top100;

import LinkedList.ListNode;

/**
 *
 *给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * @author: Xiang Mingzhe
 * @version LinkedListCycle.java, v 0.1 2020/1/8 9:10 XiangMingZhe Exp $
 **/
public class LinkedListCycle {

	/**
	 * 判断是否有环
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 找到环开始节点,无环则null
	 *
	 * @param head
	 * @return
	 */
	public ListNode findCyclePoint(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				// 有环 (第一次相遇位置到环开始节点的距离 == 头节点到环开始节点的距离)
				ListNode curr = head;
				while (curr != slow) {
					curr = curr.next;
					slow = slow.next;
				}
				return curr;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;

		System.out.println(new LinkedListCycle().findCyclePoint(head).val);
	}
}
