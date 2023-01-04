// TC = O(1) per each call of get(), put(), remove() on average.
// MC = O(N); where N = number of calls made to put.
// Problem link : https://leetcode.com/problems/design-hashmap/

class ListNode  {
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {

    public static final int MOD = 10007;
    public static final int BASE = 997;
    
    ListNode[] arr;

    public MyHashMap() {
        arr = new ListNode[MOD];
    }
    
    public void put(int key, int value) {
        remove(key);
        int idx = getHashVal(key);
        arr[idx] = new ListNode(key, value, arr[idx]);
    }
    
    public int get(int key) {
        int idx = getHashVal(key);
        ListNode curr = arr[idx];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }

            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = getHashVal(key);
        arr[idx] = deleteFromLinkedList(arr[idx], key);
    }

    private int getHashVal(int x) {
        int hash = 0;
        int multiplier = 1;

        while (x > 0) {
            hash = (hash + (x % 10) * multiplier) % MOD;
            multiplier = (multiplier * BASE) % MOD;
            x /= 10;
        }

        return hash;
    }

    private ListNode deleteFromLinkedList(ListNode head, int key) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            if (curr.key == key) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        if (prev == null) {
            return curr.next;
        } else {
            prev.next = curr.next;
            return head;
        }
    }
}
