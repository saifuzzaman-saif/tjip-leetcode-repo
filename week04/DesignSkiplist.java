// TC = O(log(n)) for each operation where n is total number inserted data;
// MC = O(n log(n));
// Problem link : https://leetcode.com/problems/design-skiplist/description/

class Skiplist {

    private static final int DUMMY_VAL = 69;

    class Node {
        int data;
        Node next;
        Node down;

        Node (int data, Node next, Node down) {
            this.data = data;
            this.next = next;
            this.down = down;
        }
    }

    Node head;
    Random rand;

    public Skiplist() {
        head = new Node(DUMMY_VAL, null, null);
        rand = new Random();
    }
    
    public boolean search(int target) {
        Node curr = head;

        while (curr != null) {
            while (curr.next != null && curr.next.data < target) {
                curr = curr.next;
            }

            if (curr.next != null && curr.next.data == target) {
                return true;
            }
            curr = curr.down;
        }

        return false;
    }
    
    public void add(int num) {
        Node curr = head;
        Stack<Node> path = new Stack<>();

        while (curr != null) {
            while (curr.next != null && curr.next.data < num) {
                curr = curr.next;
            }

            path.add(curr);
            curr = curr.down;
        }

        boolean goUp = true;
        Node down = null;
        while (goUp && !path.isEmpty()) {
            curr = path.pop();
            curr.next = new Node(num, curr.next, down);
            down = curr;
            goUp = rand.nextInt(100) < 50;
        }

        if (goUp) {
            head = new Node(DUMMY_VAL, null, head);
        }
    }
    
    public boolean erase(int num) {
        Node curr = head;
        boolean isFound = false;

        while (curr != null) {
            while (curr.next != null && curr.next.data < num) {
                curr = curr.next;
            }

            if (curr.next != null && curr.next.data == num) {
                curr.next = curr.next.next;
                isFound = true;
            }
            curr = curr.down;
        }

        return isFound;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */