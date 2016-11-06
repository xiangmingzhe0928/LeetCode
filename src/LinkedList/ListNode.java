package LinkedList;

import java.util.List;

/**
 * LinkedList
 * description:链表
 * author:mingzhe Xiang
 * date:2016/11/6
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(ListNode next,int val){
        this.next = next;
        this.val = val;
    }

    @Override
    public String toString() {
        return "value:"+this.val+"--->next:"+this.next;
    }
}
