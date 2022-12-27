// TC = O(1) for addAtHead, addAtTail & O(n) for get, addAtIndex, deleteAtIndex; where n is the length of current list size.
// MC = O(n);
// Problem link : https://leetcode.com/problems/design-linked-list/description/

class MyLinkedList {
    
    private static final int DUMMY_VAL = -1;
    
    class Node {
        
        int val;
        Node next;
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    Node head;
    int length;

    public MyLinkedList() {
        head = new Node(DUMMY_VAL, null);
        length = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        
        Node curr = head.next;
        
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        
        Node curr = head;
        
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        
        Node newNode = new Node(val, curr.next);
        curr.next = newNode;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        
        Node curr = head;
        
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        
        Node next = curr.next;
        curr.next = next.next;
        next.next = null;
        length--;
    }
}

