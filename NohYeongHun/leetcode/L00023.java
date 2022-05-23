package NohYeongHun.leetcode;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class L00023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1) return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (x,y) -> x.val - y.val
        );

        for (int i = 0; i < lists.length; i++) {
            while(lists[i] != null) {
                pq.offer(new ListNode(lists[i].val));
                lists[i] = lists[i].next;
            }
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
        }

        return result.next;
    }
    
    // 문제에 주어진 2차원 배열을 링크드 리스트로 구성
    public static void setUpLinkedList(ListNode[] node, int[][] lists) {
        for (int i = 0; i < lists.length; i++) {
            node[i] = new ListNode(lists[i][0]);
        }

        for (int i = 0; i < lists.length; i++) {
            ListNode cur = node[i];
            for (int j = 1; j < lists[i].length; j++) {
                cur.next = new ListNode(lists[i][j]);
                cur = cur.next;
            }
        }
    }

    // 결과 출력 부분
    public static void printList(ListNode node) {
        ListNode cur = node;
        while (cur.next != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void main(String[] args) {
        // Test code
        int[][] lists = {{2, 3, 9}, {1, 5, 7}, {3, 6, 7, 11}};
        ListNode[] node = new ListNode[lists.length];
        setUpLinkedList(node, lists);
        ListNode combinedNode = new L00023().mergeKLists(node);
        printList(combinedNode);
    }
}
