/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        int i = 0;
        Node newTail = new Node(head.val);
        Node newHead = newTail;
        Node originTemp = head;
        HashMap <Node, Integer> originalNodeMap = new HashMap<>();
        HashMap <Integer, Node> newNodeMap = new HashMap<>();
        
        while(head != null){
            originalNodeMap.put(head,i);
            newNodeMap.put(i++, newTail);
            head = head.next; 
            if(head != null) {
                newTail.next = new Node(head.val);
                newTail = newTail.next;
            }  
        }

        Node newTemp = newHead;
        i = 0;
        while(originTemp != null){
            newTemp.random = newNodeMap.get(originalNodeMap.get(originTemp.random));
            originTemp = originTemp.next;
            newTemp = newTemp.next;
        }
        
        return newHead;
    }
}
