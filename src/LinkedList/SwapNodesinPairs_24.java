package LinkedList;

/**
 * LinkedList
 * description:LeetCode24题 交换链表中相邻两NODE并返回新的链表
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * author:mingzhe Xiang
 * date:2016/8/6
 */
public class SwapNodesinPairs_24 {

	/**
	 * 从局部到整体来看 交换的仅仅是相邻的2个Node和其他node无关 处理完一组后 同样的方案循环处理后续组
	 *
	 * PS：开始想把交换后node1和和node4的关系也一起考虑 从而推导出一个方程式 Code实现了但过程太麻烦也就失去题目意义了
	 * @param head
	 * @return
	 */
	private static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode flagNode = new ListNode(0);
		flagNode.next = head;
		ListNode virtualHeadNode = flagNode;

		ListNode leftNode, rightNode;
		//将每相邻2个NODE的交换看作一次操作 直道最后一组
		while (flagNode.next != null && flagNode.next.next != null) {
			leftNode = flagNode.next;
			rightNode = flagNode.next.next;

			leftNode.next = rightNode.next;//首轮：1-->3
			rightNode.next = leftNode;//首轮：2-->1
			flagNode.next = rightNode;//首轮：0-->2

			flagNode = flagNode.next.next;//标志位归位 准备下一组swap
		}
		return virtualHeadNode.next;
	}

	/**
	 *
	 * LeetCode 上MostVotes的方案
	 * 递归的方式代码简便 但该方法貌似没有满足题目要求的constant sapce
	 * @param head
	 * @return
	 */
	public static ListNode mostVotes(ListNode head) {
		if ((head == null) || (head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	public static void main(String[] args) {

		System.out.println(swapPairs(ListNode.getListNodeData(5)));
	}
}
