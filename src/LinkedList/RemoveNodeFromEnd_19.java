package LinkedList;

/**
 * LinkedList
 * description:LeetCode 19 删除链表倒数n个Node 返回表头
 * Given a linked list, remove the nth node from the end of list and return its head.
 For example,
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:Given n will always be valid.Try to do this in one pass.
 * author:mingzhe Xiang
 * date:2016/8/6
 */
public class RemoveNodeFromEnd_19 {

    /**
     * 采用快慢指针来达到题目要求的one pass
     * 快慢指针间隔n的距离 当快指针到达链表末尾时 慢指针刚好指向待删NODE的preNode
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode visualHead = new ListNode(0);//定义一个虚拟头
        visualHead.next = head;

        //初始 快慢指针
        ListNode pFast = visualHead;
        ListNode pSlow = visualHead;

        //快指针先移动n位
        while(n>0){
            pFast = pFast.next;
            n--;
        }
        //快慢指针同时移动
        while(pFast.next != null){
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        //删除待删除NOde
        pSlow.next = pSlow.next.next;
        return visualHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(removeNthFromEnd(head,2));

    }
}
