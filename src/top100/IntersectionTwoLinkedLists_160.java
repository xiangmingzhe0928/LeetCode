package top100;

import LinkedList.ListNode;

/**
 * 找到两个链表的相交点
 *
 *
 * @author: Xiang Mingzhe
 * @version IntersectionTwoLinkedLists_160.java, v 0.1 2020/1/9 14:37 XiangMingZhe Exp $
 **/
public class IntersectionTwoLinkedLists_160 {

	/**
	 * 1.找到A、B的长度差d.
	 * 2.较长的一个链表先行d步,形成AB长度相同。
	 * 3.同时向后遍历两链表
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (null == headA || null == headB) {
			return null;
		}
		int aLength = 0;
		int bLength = 0;
		ListNode aTemp = headA;
		ListNode bTemp = headB;
		while (null != aTemp) {
			aTemp = aTemp.next;
			aLength ++;
		}
		while (null != bTemp) {
			bTemp = bTemp.next;
			bLength ++;
		}
		int diffLength = aLength - bLength;
		if (diffLength > 0) {
			for (int i = 0; i < diffLength; i++) {
				headA = headA.next;
			}

		} else if (diffLength < 0) {
			for (int i = 0; i < Math.abs(diffLength); i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}

		return null;
	}
}
