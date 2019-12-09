package wangzheng;

import java.util.HashMap;
import java.util.Map;

import LinkedList.ListNode;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version TwoSum.java, v 0.1 2019/12/9 17:07 XiangMingZhe Exp $
 **/
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		Map<Integer, Integer> temp = new HashMap(length);
		int[] res = new int[2];
		for (int i = 0; i < length; i++) {
			int firstKey = target - nums[i];
			if (temp.containsKey(firstKey)) {
				res[0] = temp.get(firstKey);
				res[1] = i;
				break;
			}
			temp.put(nums[i], i);
		}
		return res;
	}

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
		ListNode l1 = new ListNode(9);
		l1.next =  new ListNode(8);
//		l1.next.next =  new ListNode(3);
		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(8);
//		l2.next.next = new ListNode(1);

		System.out.println(l1);
		System.out.println(l2);

		System.out.println(addTwoNumbers(l1, l2));
	}
}
