package LinkedList;

/**
 * LinkedList
 * description:合并两个有序链表
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * author:mingzhe Xiang
 * date:2017/2/21
 */
public class MergeTwoSortedLists_21 {

    /**
     * 最终新链表也是有序的：始终比较当前一轮原来2链表的链表头大小 小的则进入新链表表尾。
     * 典型的递归形式
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode newHead ;
        ListNode nextTime1 = l1;
        ListNode nextTime2 = l2;

        if(l1.val <= l2.val){
            newHead = l1;
            nextTime1 = l1.next;
        }else{
            newHead = l2;
            nextTime2 = l2.next;
        }
        newHead.next = mergeTwoLists(nextTime1,nextTime2);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(12);
        ListNode l13 = new ListNode(22);
        l11.next = l12;
        l12.next = l13;
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(13);
        ListNode l24 = new ListNode(33);
        l22.next = l23;
        l23.next = l24 ;
        System.out.println(mergeTwoLists(l11,l22));
    }
}
