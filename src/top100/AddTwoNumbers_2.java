package top100;

import LinkedList.ListNode;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version AddTwoNumbers_2.java, v 0.1 2019/12/10 8:58 XiangMingZhe Exp $
 **/
public class AddTwoNumbers_2 {
	/**
	 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	 *
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode head = temp;
		// 进位数
		int carry = 0;
		int sum;
		while (null != l1 || null != l2 || carry != 0) {
			sum = (null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + carry;
			int currentVal = sum % 10;
			carry = sum / 10;
			temp.next = new ListNode(currentVal);
			temp = temp.next;
			l1 = null == l1 ? null : l1.next;
			l2 = null == l2 ? null : l2.next;
		}

		return head.next;
	}

	/**
	 * 分步处理各情况
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static ListNode stepByStep(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode head = temp;
		// 进位数
		int carry = 0;
		int sum;
		while (null != l1 && null != l2) {
			sum = l1.val + l2.val + carry;
			int currentVal = sum % 10;
			carry = sum / 10;
			temp.next = new ListNode(currentVal);
			temp = temp.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		if (null == l1) {
			while (null != l2) {
				sum = l2.val + carry;
				carry = sum / 10;
				temp.next = new ListNode(sum % 10);
				temp = temp.next;
				l2 = l2.next;
			}
		} else {
			while (null != l1) {
				sum = l1.val + carry;
				carry = sum / 10;
				temp.next = new ListNode(sum % 10);
				temp = temp.next;
				l1 = l1.next;
			}
		}

		if (carry == 1) {
			temp.next = new ListNode(1);
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		System.out.println(addTwoNumbers(l1, l2));
	}
}
