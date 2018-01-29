package LinkedList;

/**
 * LinkedList
 * description:链表
 * author:mingzhe Xiang
 * date:2016/11/6
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode(ListNode next, int val) {
		this.next = next;
		this.val = val;
	}

	/**
	 * 提供初始链表数据：以ListNode(1)为head
	 * @param n 初始链表个数 要求n>=1
	 * @return
	 */
	public static ListNode getListNodeData(int n) {
		if (n < 1)
			return null;
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i = 2; i <= n; i++) {
			head.next = new ListNode(i);
			head = head.next;
		}

		return temp;
	}

	@Override
	public String toString() {
		return "value:" + this.val + "--->next:" + this.next;
	}

}
