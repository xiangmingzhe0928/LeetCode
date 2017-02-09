package LinkedList;

/**
 * LinkedList
 * description:删除单链表中指定非尾节点，且只有该节点的访问权限(这是本题的出题题意)
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * author:mingzhe Xiang
 * date:2017/2/9
 */
public class DeleteNodeInLinkedList_237 {


    /**
     * 题目本身不是太复杂
     * 但最初没认真审题，题目要求“given only access to that node”：即是只能访问要删除的节点 不能直接访问其他节点。直接导致思路错误
     * @param node
     */
    public static void deleteNode(ListNode node) {

//        ListNode srcListNode = ListNode.getListNodeData(10);
//        ListNode flagNode = new ListNode(srcListNode,0);
//        while (flagNode.next.next != null){
//            if(flagNode.next.val == node.val){
//                flagNode.next = flagNode.next.next;
//                return;
//            }
//            flagNode = flagNode.next;
//        }

        //只能访问要删除节点：删除后实际可看作deleteNode的next节点前移覆盖了deleteNode
        //将deleteNode.next覆盖deleteNode
        node.val = node.next.val;
        //删除原本的deleteNode.next
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        deleteNode(new ListNode(10));
    }
}
