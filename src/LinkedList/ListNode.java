package LinkedList;

/**
 * LinkedList
 * description:链表
 * author:mingzhe Xiang
 * date:2016/11/6
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
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
		return getListNodeData(n ,1 ,1);
	}

	/**
	 * 提供初始链表数据：以ListNode(1)为head
	 * @param n 初始链表个数 要求n>=1
	 * @param gap 值步长
	 * @return
	 */
	public static ListNode getListNodeData(int n, int startVal, int gap) {
		if (n < 1)
			return null;
		ListNode head = new ListNode(startVal);
		ListNode temp = head;
		for (int i = 2; i <= n; i++) {
			head.next = new ListNode(startVal += gap);
			head = head.next;
		}

		return temp;
	}

	public static void main(String[] args) {
		System.out.println(getListNodeData(10,1,1));
	}
	@Override
	public String toString() {
		return "value:" + this.val + "--->next:" + this.next;
	}

}
