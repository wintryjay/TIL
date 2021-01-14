package Algorithm.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
# Question02. Merge K Sorted Lists(Priority Queue, Comparator)
    Eng: You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
         Merge all the linked-lists into one sorted linked-list and return it.
    Kor: 연결된 각 리스트가 오름차순으로 정렬된 k 연결 리스트 배열이 제공됩니다. 모든 연결 목록을 정렬된 하나의 연결 목록으로 병합한 후 반환합니다.

    input:
        lists = [[1, 4, 5], [1, 3, 4], [2, 6]]
    output:
        [1,1,2,3,4,4,5,6]
 */
public class T02_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        T02_MergeKSortedLists a = new T02_MergeKSortedLists();
        ListNode result = a.mergeLists(list);
        System.out.println("=====");
        while (result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeLists(ListNode[] lists) {
        // 1.
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p=newHead;

        for(ListNode node : lists) {
            if(node!=null) {
                queue.offer(node);
            }
        }

        // 2.
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;

            if(node.next!= null) {
                queue.offer(node.next);
            }
        }

        return newHead.next;
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {

        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };
}
