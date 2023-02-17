/**
 * TC = O(1) for each functions in average
 * MC = O(N); where N is the number values will be given.
 * Problem link : https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */

class RandomizedSet {

    private Random rand;
    Map<Integer, Integer> pos;
    List<Integer> vals;

    public RandomizedSet() {
        rand = new Random();
        pos = new HashMap<>();
        vals = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (pos.containsKey(val)) {
            return false;
        }

        vals.add(val);
        pos.put(val, vals.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if (!pos.containsKey(val)) {
            return false;
        }

        int idx = pos.get(val);
        vals.set(idx, vals.get(vals.size() - 1));
        pos.put(vals.get(vals.size() - 1), idx);

        pos.remove(val);
        vals.remove(vals.size() - 1);

        return true;
    }
    
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}
