package LinkedList;

import java.util.List;

/**
 * LinkedList
 * description:反转链表指定k次
 Given a list, rotate the list to the right by k places, where k is non-negative.
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 * author:mingzhe Xiang
 * date:2017/2/21
 */
public class RotateList_61 {

    /**
     * 1->2->3->4->5->NULL and k = 2
     * 反转2次看似 第一次：5-1-2-3-4 | 第二次 4-5-2-3-4 实则可看合并看作一次将4-5子链表反转到表头
     * 则本题跟删除倒数第N个节点一样，利用双指针处理
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;
        ListNode countNode = head;
        //定义快慢指针
        ListNode fastNode = head;
        ListNode slowNode = head;
        //计算链表长度
        int count = 1;
        while(countNode.next!=null){
            count++;
            countNode = countNode.next;
        }
        if(k >= count) k %= count;//对于k大于len的情况 实际循环反转整链表一次相当于未反转  k%count才是有效翻转次数
        if(k == 0)return head;

        //快指针先行k步 （k而不是k-1 是因为在定位到待反转子链表头节点时 需要操作它的前节点）
        int temp = k;
        while (temp > 0){
            fastNode = fastNode.next;
            temp--;
        }
        //快慢指针同时直到快指针到达表尾 此时慢指针刚好到达待反转子链表头节点的前节点
        while(fastNode.next!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        //执行rotate操作
        ListNode newHead = slowNode.next;
        slowNode.next = null;
        fastNode.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
//        ListNode l13 = new ListNode(22);
        l11.next = l12;
//        l12.next = l13;
        System.out.println(rotateRight(l11,2));
    }
}
