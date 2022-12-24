// TC : O(1) for get and put in average.
// MC : O(N) ; Where N is the number of calls will be made to put.
// problem link : https://leetcode.com/problems/lru-cache/description/

class ListNode {
    
    int key;
    ListNode next;
    ListNode prev;

    ListNode(int key, ListNode prev, ListNode next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList {
    
    ListNode head;
    ListNode trail;
    Map<Integer, ListNode> references;

    DoublyLinkedList() {
        references = new HashMap<>();
    }

    public void addFirst(int key) {
        ListNode curr = new ListNode(key, null, head);
        if (trail == null) {
            trail = curr;
        } else {
            head.prev = curr;
        }

        head = curr;
        references.put(key, curr);
    }

    public void remove(int key) {
        ListNode curr = references.get(key);

        if (curr == null) {
            return;
        } else if (curr == head) {
            pollFirst();
        } else if (curr == trail) {
            pollLast();
        } else {
            ListNode next = curr.next;
            ListNode prev = curr.prev;
            prev.next = next;
            next.prev = prev;
            references.remove(key);
        }
    }

    public int pollFirst() {
        int key = head.key;
        if (head == trail) {
            head = trail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        references.remove(key);
        return key;
    }

    public int pollLast() {
        int key = trail.key;
        if (head == trail) {
            head = trail = null;
        } else {
            trail = trail.prev;
            trail.next = null;
        }

        references.remove(key);
        return key;
    }
}

public class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoublyLinkedList();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);

            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        list.remove(key);
        list.addFirst(key);
        cache.put(key, value);

        if (cache.size() > capacity) {
            key = list.pollLast();
            cache.remove(key);
        }
    }
}
