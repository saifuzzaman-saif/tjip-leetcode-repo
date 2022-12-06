class RandomizedSet {

    // TC = O(1) in average for each function call.
    // MC = O(n) ; where n is the number calls will be made.
    
    List<Integer> vals;
    Map<Integer, Integer> pos;
    Random random;

    public RandomizedSet() {
        vals = new ArrayList<>();
        pos = new HashMap<>();
        random = new Random();
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
        int sz = vals.size();
        vals.set(idx, vals.get(sz-1));
        pos.put(vals.get(idx), idx);

        pos.remove(val);
        vals.remove(sz - 1);
        
        return true;
    }
    
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */